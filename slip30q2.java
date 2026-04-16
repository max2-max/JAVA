import java.sql.*;

public class ScrollableResultSetDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql:practice_db", "postgres", "postgres");

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = st.executeQuery("SELECT * FROM teacher");

			if (rs.first()) {
				System.out.println("First Record:");
				display(rs);
			}

			if (rs.next()) {
				System.out.println("\nNext Record:");
				display(rs);
			}

			if (rs.previous()) {
				System.out.println("\nPrevious Record:");
				display(rs);
			}

			if (rs.last()) {
				System.out.println("\nLast Record:");
				display(rs);
			}

			if (rs.absolute(2)) {
				System.out.println("\nRecord at Position 2:");
				display(rs);
			}

			if (rs.relative(-1)) {
				System.out.println("\nRelative Move(-1):");
				display(rs);
			}

			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	static void display(ResultSet rs) throws SQLException {
		System.out.println(rs.getInt("tno") + "\t" + rs.getString("tname") + "\t" + rs.getDouble("salary"));
	}
}
