import java.sql.*;
import java.util.Scanner;

public class EmployeeMenu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			int choice;

			do {
				System.out.println("\nEmployee Menu");
				System.out.println("1.Insert");
				System.out.println("2.Update");
				System.out.println("3.Display");
				System.out.println("4.Exit");

				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
					case 1:
						System.out.print("Enter Employee No: ");
						int eno = sc.nextInt();
						sc.nextLine();

						System.out.print("Enter Employee Name: ");
						String ename = sc.nextLine();

						System.out.print("Enter Salary: ");
						double salary = sc.nextDouble();

						PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES(?, ?, ?)");

						ps.setInt(1, eno);
						ps.setString(2, ename);
						ps.setDouble(3, salary);

						int rows = ps.executeUpdate();

						if (rows > 0) {
							System.out.println("Record inserted successfully!");
						}
						break;

					case 2:
						System.out.print("Enter Employee No to update salary: ");

						eno = sc.nextInt();
						
						System.out.print("Enter new Salary: ");
						salary = sc.nextDouble();

						PreparedStatement ps1 = con.prepareStatement("UPDATE employee SET salary = ? WHERE eno = ?");

						ps1.setDouble(1, salary);
						ps1.setInt(2, eno);

						int urows = ps1.executeUpdate();

						if (urows > 0) {
							System.out.println("Salary updated successfully!");
						} else {
							System.out.println("Employee not found!");
						}
						break;

					case 3:
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM employee");

						System.out.println("\neno\tename\tsalary");
						System.out.println("--------------------");

						while (rs.next()) {
							System.out.println(rs.getInt("eno") + "\t" + rs.getString("ename") + "\t" + rs.getDouble("salary"));
						}
						break;

					case 4:
						System.out.println("Exiting...");
						break;

					default:
						System.out.println("Invalid choice! Try again.");
				}
			} while (choice != 4);

			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		sc.close();
	}
}
