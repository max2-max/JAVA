public class AlphabetDisplay extends Thread {
	char currentChar = 'A';

	public void run() {
		try {
			while (currentChar <= 'Z') {
				System.out.print(currentChar + " ");
				currentChar ++;
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AlphabetDisplay a = new AlphabetDisplay();
		a.start();
	}
}
