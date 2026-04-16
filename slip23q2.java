import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StudentName {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please pass student names through command line.");
			return;
		}

		ArrayList<String> students = new ArrayList<>();

		for (String name : args) {
			students.add(name);
		}

		System.out.println("Student name using iterator: ");
		Iterator<String> itr = students.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("\nStudent Names using ListIterator(Forward): ");

		ListIterator<String> litr = students.listIterator();

		while (litr.hasNext()) {
			System.out.println(litr.next());
		}

		System.out.println("\nStudent names using ListIterator(Backward): ");
		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}
	}
}
