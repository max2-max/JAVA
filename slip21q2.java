class Data {
	private int value;
	private boolean flag = false;

	public synchronized void produce(int v) throws InterruptedException {
		while (flag) {
			wait();
		}

		value = v;
		System.out.println("Produced: " + value);
		flag = true;
		notify();
	}

	public synchronized void consume() throws InterruptedException {
		while (!flag) {
			wait();
		}

		System.out.println("Consumed: " + value);
		flag = false;
		notify();
	}
}

class Producer extends Thread {
	Data d;

	Producer(Data d) {
		this.d = d;
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i ++) {
				d.produce(i);
			}
		} catch (Exception e) {
		}
	}
}

class Consumer extends Thread {
	Data d;

	Consumer(Data d) {
		this.d = d;
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i ++) {
				d.consume();
			}
		} catch (Exception e) {
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Data d = new Data();
		new Producer(d).start();
		new Consumer(d).start();
	}
}
