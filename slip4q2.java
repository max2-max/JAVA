import java.util.*;

public class CitySTDCode {
	public static void main(String[] args) {
		HashMap<String, Integer> cityCodes = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		cityCodes.put("Pune", 20);
		cityCodes.put("Mumbai", 22);
		cityCodes.put("Delhi", 11);

		int choice;

		do {
			System.out.println("1.Add city");
			System.out.println("2.Remove city");
			System.out.println("3.Search city");
			System.out.println("4.Exit");

			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					System.out.print("Enter city name: ");
					String city = sc.nextLine();

					if (cityCodes.containsKey(city)) {
						System.out.println("City already exists!");
					} else {
						System.out.print("Enter STD Code: ");
						int code = sc.nextInt();
						cityCodes.put(city, code);
						System.out.println("City added successfully.");
					}
					break;

				case 2:
					System.out.print("Enter city name to remove: ");
					city = sc.nextLine();

					if (cityCodes.remove(city) != null) {
						System.out.println("City removed successfully.");
					} else {
						System.out.println("City not found.");
					}
					break;

				case 3:
					System.out.print("Enter city name to search: ");
					city = sc.nextLine();

					if (cityCodes.containsKey(city)) {
						System.out.println("City found: " + cityCodes.get(city));
					} else {
						System.out.println("City not found!");
					}
					break;

				case 4:
					System.out.println("Exiting the program...");
					break;

				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 4);
	}
}
