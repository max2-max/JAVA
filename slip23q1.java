import java.util.Scanner;

class VowelThread extends Thread {
	String str;

	VowelThread(String s) {
		str = s.toLowerCase();
	}

	public void run() {
		try {
			for (int i = 0; i < str.length(); i ++) {
				char ch = str.charAt(i);

				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					System.out.println("Vowel: " + ch);
					Thread.sleep(3000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class DisplayVowels {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String input = sc.nextLine();

		VowelThread vt = new VowelThread(input);
		vt.start();

		sc.close();
	}
}
