import java.util.LinkedList;

public class StringLinkedList {
	public static void main(String[] args) {
		LinkedList<String> stringList = new LinkedList<>();

		stringList.add("Apple");
		stringList.add("Banana");
		stringList.add("Orange");
		System.out.println("Original List: " + stringList);

		stringList.add("Grapes");
		System.out.println("List after adding 'Grapes': " + stringList);

		if (!stringList.isEmpty()) {
			stringList.removeFirst();
			System.out.println("List after deleting the firs element: " + stringList);
		} else {
			System.out.println("List is empty. Cannot remove the first element.");
		}

		System.out.println("List in reverse order: ");
		for (int i = stringList.size() - 1; i >= 0; i --) {
			System.out.println(stringList.get(i));
		}
	}
}
