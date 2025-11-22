// ThreadMethodsDemo.java
class ThreadMethodsDemo extends Thread {
    public ThreadMethodsDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " running: step " + i);
                Thread.sleep(500); // sleep demonstrates timed wait
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethodsDemo t = new ThreadMethodsDemo("DemoThread");

        // set and get name
        System.out.println("Name before: " + t.getName());
        t.setName("DemoThread-Renamed");
        System.out.println("Name after: " + t.getName());

        // priority
        System.out.println("Priority before: " + t.getPriority());
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority after: " + t.getPriority());

        // start() will cause the JVM to call run() in a new thread
        t.start();

        // sleep in main to show main thread pausing
        System.out.println("Main sleeping for 1 second...");
        Thread.sleep(1000);

        // show that the thread may still be alive
        System.out.println("Is thread alive? " + t.isAlive());

        // wait for completion
        t.join();
        System.out.println("ThreadMethodsDemo finished");
    }
}
