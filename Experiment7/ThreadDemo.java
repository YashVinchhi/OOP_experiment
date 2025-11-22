// ThreadDemo.java
class ThreadDemo extends Thread {
    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // demonstrate the thread doing work and waiting (sleep)
            System.out.println("[run] Thread " + getName() + " started.");
            Thread.sleep(1000); // make the thread wait for 1 second
            System.out.println("[run] Thread " + getName() + " finished work.");
        } catch (InterruptedException e) {
            System.out.println("[run] Thread " + getName() + " interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo t = new ThreadDemo("Worker-1");

        // (i) Print the name of a thread
        System.out.println("Name before start: " + t.getName());

        // (ii) Change the name of a thread
        t.setName("MyWorkerThread");
        System.out.println("Name after setName: " + t.getName());

        // Start the thread
        t.start();

        // (iii) Make the (main) thread wait until t finishes using join()
        System.out.println("Main thread waiting for child thread to finish...");
        t.join();

        // (iv) Display details of a thread
        System.out.println("Details: id=" + t.getId() + ", name=" + t.getName() + ", alive=" + t.isAlive());
    }
}
