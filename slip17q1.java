import java.util.Scanner;
import java.util.TreeSet;

public class SortedIntegers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TreeSet<Integer> numbers = new TreeSet<>();

		System.out.print("Enter value of N: ");
		int n = sc.nextInt();

		System.out.println("Enter " + n + " integers: ");
		for (int i = 0; i < n; i ++) {
			numbers.add(sc.nextInt());
		}

		System.out.println("Sorted integers (without duplicates): ");
		for (Integer num : numbers) {
			System.out.print(num + " ");
		}
		sc.close();
	}
}
