import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class SubjectLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LinkedList<String> subjects = new LinkedList<>();

		System.out.print("Enter no.of subjects: ");
		int n = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter " + n + " subject names: ");
		for (int i = 0; i < n; i ++) {
			subjects.add(sc.nextLine());
		}

		System.out.println("\nSubjects in the LinkedList are: ");
		
		Iterator<String> itr = subjects.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		sc.close();
	}
}
