import java.sql.*;

public class DeleteEmployee {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java DeleteEmployee <EmployeeNo>");
			return;
		}

		int eno = Integer.parseInt(args[0]);

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE eno = ?");

			ps.setInt(1, eno);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Employee record deleted successfully.");
			} else {
				System.out.println("Employee not found.");
			}

			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
