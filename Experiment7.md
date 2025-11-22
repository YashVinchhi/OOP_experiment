## **1. Write a program to implement the following:**

(i) Print the name of a thread
(ii) Change the name of a thread
(iii) Make the thread wait
(iv) Display details of a thread

### **Code :**

```java
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
```

---

## **2. Write a Java program that implements Thread class methods.**

Methods to implement:

* `run()`
* `start()`
* `getName()`
* `setName()`
* `getPriority()`
* `setPriority()`
* `sleep()`

### **Code :**

```java
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
```

---

## **3. Implement a multithread application containing three threads:**

* **Thread 1:** Generates a random integer every 1 second
* If the random number is **even** → **Thread 2** prints its **square**
* If the random number is **odd** → **Thread 3** prints its **cube**

### **Code :**

```java
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

	public EvenConsumer(SharedData data) { this.data = data; }

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

	public OddConsumer(SharedData data) { this.data = data; }

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

class MultiThreadRandom {
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
		synchronized (data) { data.notifyAll(); }

		cEven.join();
		cOdd.join();

		System.out.println("All threads finished.");
	}
}
```

