import java.sql.*;

public class DatabaseMetaDataExample {  // Rename the class here
    public static void main(String[] args) {
        try {
            // Register PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Establish connection to the database
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_db", "postgres", "postgres");

            // Get metadata for the database
            DatabaseMetaData dbmd = con.getMetaData();

            // Print database information
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("User Name: " + dbmd.getUserName());

            System.out.println("\nList of Tables: ");
            System.out.println("----------");

            // Get all tables in the database
            ResultSet rs = dbmd.getTables(null, null, "%", new String[] {"TABLE"});

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            // Close the connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
