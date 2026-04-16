import java.util.*;

class Square extends Thread {
	int x;

	Square (int n) {
		x = n;
	}

	public void run() {
		int sqr = x * x;
		System.out.println("Square of " + x + " is " + sqr);
	}
}

class Cube extends Thread {
	int x;

	Cube(int n) {
		x = n;
	}

	public void run() {
		int cube = x * x * x;
		System.out.println("Cube of " + x + " is " + cube);
	}
}

class Number extends Thread {
	public void run() {
		Random r = new Random();

		for (int i = 0; i < 10; i ++) {
			int num = r.nextInt(100);
			System.out.println("Random integer generated: " + num);

			if (num % 2 == 0) {
				Square s = new Square(num);
				s.start();
			} else {
				Cube c = new Cube(num);
				c.start();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class MultiThread {
	public static void main(String[] args) {
		Number n = new Number();
		n.start();
	}
}
