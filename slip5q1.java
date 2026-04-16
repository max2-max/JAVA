import java.util.*;

public class StudentHashTable {
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<>();

		ht.put("1234567890", "ABC");
		ht.put("0987654321", "LMN");
		ht.put("6437281837", "PQR");
		ht.put("6378218374", "XYZ");

		System.out.println("Student details: ");

		Enumeration<String> keys = ht.keys();

		while (keys.hasMoreElements()) {
			String mobile = keys.nextElement();
			String name = ht.get(mobile);

			System.out.println("Mobile No: " + mobile + " Student Name: " + name);
		}
	}
}
