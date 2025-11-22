// MultiThreadRandom.java
import java.util.Random;

class SharedData {
    int number;
    boolean available = false; // indicates producer has produced
    boolean processed = false; // indicates consumer processed current number
    boolean finished = false;  // to signal termination
}

class Producer extends Thread {
    private final SharedData data;
    private final int iterations;
    private final Random rnd = new Random();

    public Producer(SharedData data, int iterations) {
        this.data = data;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                int n = rnd.nextInt(100) + 1; // 1..100
                synchronized (data) {
                    // wait until previous number is consumed
                    while (data.available && !data.processed) {
                        data.wait();
                    }
                    data.number = n;
                    data.available = true;
                    data.processed = false;
                    System.out.println("Producer generated: " + n);
                    data.notifyAll();
                }
                Thread.sleep(1000); // generate every 1 second
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            synchronized (data) {
                data.finished = true;
                data.notifyAll();
            }
        }
    }
}

class EvenConsumer extends Thread {
    private final SharedData data;

    public EvenConsumer(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (data) {
                    while (!data.available && !data.finished) data.wait();
                    if (data.finished && !data.available) break;
                    if (data.available && (data.number % 2 == 0) && !data.processed) {
                        int val = data.number;
                        System.out.println("EvenConsumer: square of " + val + " = " + (val * val));
                        data.processed = true;
                        data.available = false;
                        data.notifyAll();
                    } else if (data.finished) {
                        break;
                    } else {
                        // not the consumer for this number; wait for next notify
                        data.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class OddConsumer extends Thread {
    private final SharedData data;

    public OddConsumer(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (data) {
                    while (!data.available && !data.finished) data.wait();
                    if (data.finished && !data.available) break;
                    if (data.available && (data.number % 2 != 0) && !data.processed) {
                        int val = data.number;
                        System.out.println("OddConsumer: cube of " + val + " = " + (val * val * val));
                        data.processed = true;
                        data.available = false;
                        data.notifyAll();
                    } else if (data.finished) {
                        break;
                    } else {
                        data.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MultiThreadRandom {
    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();
        Producer p = new Producer(data, 10); // produce 10 numbers
        EvenConsumer cEven = new EvenConsumer(data);
        OddConsumer cOdd = new OddConsumer(data);

        // start all threads
        cEven.start();
        cOdd.start();
        p.start();

        // wait for producer to finish
        p.join();

        // ensure consumers exit
        synchronized (data) {
            data.notifyAll();
        }

        cEven.join();
        cOdd.join();

        System.out.println("All threads finished.");
    }
}
