import java.util.LinkedList;

public class LinkedListOperation {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		list.addFirst(5);
		list.removeLast();

		System.out.println("LinkedList elements: " + list);
		System.out.println("Size of LinkedList: " + list.size());
	}
}
