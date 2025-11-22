# Python script to generate HTML files for remaining experiments
# This will be run to create Experiment4-7.html

import re

def create_html(exp_num, title, programs):
    html_template = f'''<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Experiment {exp_num} - {title}</title>
    <style>
        * {{ margin: 0; padding: 0; box-sizing: border-box; }}
        body {{ font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; line-height: 1.6; color: #333; background-color: #f5f5f5; padding: 20px; }}
        .container {{ max-width: 1200px; margin: 0 auto; background: white; padding: 40px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); border-radius: 8px; }}
        .breadcrumb {{ margin-bottom: 20px; font-size:0.9em; }}
        .breadcrumb a {{ color: #3498db; text-decoration: none; }}
        .breadcrumb a:hover {{ text-decoration: underline; }}
        header {{ border-bottom: 3px solid #2c3e50; padding-bottom: 20px; margin-bottom: 30px; }}
       h1 {{ color: #2c3e50; font-size: 2.2em; margin-bottom: 10px; }}
        h2 {{ color: #2980b9; font-size: 1.5em; margin-top: 40px; margin-bottom: 15px; padding-bottom: 10px; border-bottom: 2px solid #ecf0f1; }}
        .code-container {{ position: relative; margin: 20px 0; background: #f8f9fa; border: 1px solid #dee2e6; border-radius: 6px; overflow: hidden; }}
        .code-header {{ background: #2c3e50; color: white; padding: 10px 15px; display: flex; justify-content: space-between; align-items: center; font-size: 0.9em; }}
        .code-filename {{ font-weight: 500; }}
        .copy-btn {{ background: #3498db; color: white; border: none; padding: 5px 15px; border-radius: 4px; cursor: pointer; font-size: 0.85em; transition: background 0.3s; }}
        .copy-btn:hover {{ background: #2980b9; }}
        .copy-btn.copied {{ background: #27ae60; }}
        pre {{ margin: 0; padding: 20px; overflow-x: auto; background: #282c34; color: #abb2bf; font-family: 'Consolas', 'Monaco', 'Courier New', monospace; font-size: 0.9em; line-height: 1.5; }}
        footer {{ margin-top: 50px; padding-top: 20px; border-top: 1px solid #ddd; text-align: center; color: #7f8c8d; font-size: 0.9em; }}
        .back-to-top {{ position: fixed; bottom: 30px; right: 30px; background: #3498db; color: white; width: 50px; height: 50px; border-radius: 50%; border: none; cursor: pointer; font-size: 1.2em; box-shadow: 0 2px 10px rgba(0,0,0,0.2); display: none; }}
        .back-to-top:hover {{ background: #2980b9; }}
    </style>
</head>
<body>
    <div class="container">
        <div class="breadcrumb"><a href="index.html">← Back to Index</a></div>
        <header>
            <h1>Experiment {exp_num} - {title}</h1>
        </header>
        <main>
{programs}
        </main>
        <footer><p><a href="index.html">← Back to Index</a> | Experiment {exp_num} - {title}</p></footer>
    </div>
    <button class="back-to-top" onclick="scrollToTop()" id="backToTop">↑</button>
    <script>
        function copyCode(button) {{
            const codeBlock = button.closest('.code-container').querySelector('code');
            const text = codeBlock.textContent;
            navigator.clipboard.writeText(text).then(() => {{
                const originalText = button.textContent;
                button.textContent = 'Copied!';
                button.classList.add('copied');
                setTimeout(() => {{
                    button.textContent = originalText;
                    button.classList.remove('copied');
                }}, 2000);
            }}).catch(err => {{
                alert('Failed to copy code.');
            }});
        }}
        window.onscroll = function() {{
            const button = document.getElementById('backToTop');
            if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {{
                button.style.display = 'block';
            }} else {{
                button.style.display = 'none';
            }}
        }};
        function scrollToTop() {{
            window.scrollTo({{top: 0, behavior: 'smooth'}});
        }}
    </script>
</body>
</html>'''
    return html_template

def extract_code_blocks_from_md(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Find all code blocks
    pattern = r'```java\n(.*?)```'
    codes = re.findall(pattern, content, re.DOTALL)
    
    # Find all section headers
    headers = re.findall(r'^##\s+(.+)$', content, re.MULTILINE)
    
    programs_html = ""
    for i, (header, code) in enumerate(zip(headers, codes), 1):
        # Extract filename from code comment
        filename_match = re.search(r'//\s*(\w+\.java)', code)
        filename = filename_match.group(1) if filename_match else f"Program{i}.java"
        
        programs_html += f'''            <h2>{i}. {header.strip("*")}</h2>
            <div class="code-container">
                <div class="code-header"><span class="code-filename">{filename}</span><button class="copy-btn" onclick="copyCode(this)">Copy</button></div>
                <pre><code>{code.strip()}</code></pre>
            </div>
'''
    
    return programs_html

# Generate files for Experiment 4-7
experiments = [
    (4, "Interfaces & Abstract Classes"),
    (5, "Exception Handling"),
    (6, "File Handling"),
    (7, "Multithreading")
]

for exp_num, title in experiments:
    md_file = f"Experiment{exp_num}.md"
    html_file = f"Experiment{exp_num}.html"
    
    programs_html = extract_code_blocks_from_md(md_file)
    html_content = create_html(exp_num, title, programs_html)
    
    with open(html_file, 'w', encoding='utf-8') as f:
        f.write(html_content)
    
    print(f"Created {html_file}")

print("All HTML files generated successfully!")
