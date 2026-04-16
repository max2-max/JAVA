import java.sql.*;
import java.util.Scanner;

public class Teacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nTeacher Menu");
			System.out.println("1.Add Teacher");
			System.out.println("2.Show Java Teachers");
			System.out.println("3.Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					addTeacher(sc);
					break;
				case 2:
					showJavaTeachers();
					break;
				case 3:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice!");				}
		}
	}

	static void addTeacher(Scanner sc) {
		try {
			System.out.print("Enter Teacher No: ");
			int tno = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Teacher Name: ");
			String tname = sc.nextLine();

			System.out.print("Enter Subject: ");
			String subject = sc.nextLine();

			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

				PreparedStatement ps = con.prepareStatement("INSERT INTO teacher VALUES(?, ?, ?)");

				ps.setInt(1, tno);
				ps.setString(2, tname);
				ps.setString(3, subject);

				ps.executeUpdate();
				System.out.println("Teacher added successfully!");
			} catch (SQLException e) {
				System.out.println("Database Error: " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	static void showJavaTeachers() {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM teacher WHERE UPPER(subject) = ?");

			ps.setString(1, "JAVA");

			try {
				ResultSet rs = ps.executeQuery();
				System.out.println("\nJAVA Teachers");

				boolean found = false;
				while (rs.next()) {
					int tno = rs.getInt("tno");
					String tname = rs.getString("tname");
					String subject = rs.getString("subject");

					System.out.println(tno + " | " + tname + " | " + subject);
					found = true;
				}

				if (!found) {
					System.out.println("No JAVA teachers found.");
				}
			} catch (SQLException e) {
				System.out.println("Error fetching records: " + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Error fetching records: " + e.getMessage());
		}
	}
}

