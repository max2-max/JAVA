import java.util.Scanner;
import java.util.TreeSet;

public class SortedIntegers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TreeSet<Integer> numbers = new TreeSet<>();

		System.out.print("Enter no.of elements: ");
		int n = sc.nextInt();
		
		System.out.println("Enter " + n + " integers: ");
		for (int i = 0; i < n; i ++) {
			numbers.add(sc.nextInt());
		}

		System.out.println("Elements in sorted order: ");
		System.out.println(numbers);

		System.out.print("Enter element to search: ");
		int key = sc.nextInt();

		if (numbers.contains(key)) {
			System.out.println("Element " + key + " is found.");
		} else {
			System.out.println("Element " + key + " is not found.");
		}
		sc.close();
	}
}
