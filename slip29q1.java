import java.sql.*;

public class DonarMetaData {
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM donar");
	
			ResultSetMetaData rsmd = rs.getMetaData();

			int colCount = rsmd.getColumnCount();

			System.out.println("Number of Columns: " + colCount);
			System.out.println("----------");

			for (int i = 1; i <= colCount; i ++) {
				System.out.println("Column Number: " + i);
				System.out.println("Column Name: " + rsmd.getColumnName(i));
				System.out.println("Column Type: " + rsmd.getColumnTypeName(i));
				System.out.println("Column Size: " + rsmd.getColumnDisplaySize(i));
				System.out.println("Nullable: " + (rsmd.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));

				System.out.println("----------");
			}

			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
