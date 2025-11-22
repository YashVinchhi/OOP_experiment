// ThisKeywordDemo.java
class ThisDemo {
    String name;

    ThisDemo(String name) {
        // 'this' distinguishes instance variable from parameter
        this.name = name;
    }

    public void setName(String name) {
        this.name = name; // this refers to current instance
    }

    public void show() {
        System.out.println("Name = " + this.name);
    }

    public static void main(String[] args) {
        ThisDemo td = new ThisDemo("Original");
        td.show();
        td.setName("Updated");
        td.show();
    }
}
