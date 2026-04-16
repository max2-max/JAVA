class PrintThread extends Thread {
	String text;
	int n;

	PrintThread(String text, int n) {
		this.text = text;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i ++) {
			System.out.println(text + " " + i);
		}
	}
}

public class MultiThread {
	public static void main(String[] args) {
		PrintThread t1 = new PrintThread("COVID19", 10);
		PrintThread t2 = new PrintThread("LOCKDOWN2020", 20);
		PrintThread t3 = new PrintThread("VACCINATED2021", 30);

		t1.start();
		t2.start();
		t3.start();
	}
}
