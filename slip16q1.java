import java.util.TreeSet;

public class TreeSetColors {
	public static void main(String[] args) {
		TreeSet<String> colors = new TreeSet<>();

		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("Orange");
		colors.add("White");

		System.out.println("Colors in ascending order: ");
		for (String color : colors) {
			System.out.println(color);
		}
	}
}
