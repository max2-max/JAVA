import java.util.Random;

class LifeCycleThread extends Thread {
	int sleepTime;

	LifeCycleThread(String name) {
		super(name);
	}

	public void run() {
		Random r = new Random();
		sleepTime = r.nextInt(5000);

		System.out.println("Thread created: " + getName());
		System.out.println(getName() + " going to sleep for " + sleepTime + " ms");

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(getName() + " is dead");
	}
}

public class ThreadLifeCycle {
	public static void main(String[] args) {
		LifeCycleThread t1 = new LifeCycleThread("Thread-A");
		LifeCycleThread t2 = new LifeCycleThread("Thread-B");
		LifeCycleThread t3 = new LifeCycleThread("Thread-C");

		t1.start();
		t2.start();
		t3.start();
	}
}
