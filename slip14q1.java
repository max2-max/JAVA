import java.io.*;
import java.util.*;

class FileSearchThread extends Thread {
	private File file;
	private String searchString;

	FileSearchThread(File file, String searchString) {
		this.file = file;
		this.searchString = searchString;
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int lineNo = 0;

			while ((line = br.readLine()) != null) {
				lineNo ++;
				if (line.contains(searchString)) {
					System.out.println("Found in File: " + file.getName() + " at line: " + lineNo);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class SimpleSearchEngine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter string to search: ");
		String searchString = sc.nextLine();

		File folder = new File(".");

		File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

		if (files != null) {
			for (File f : files) {
				FileSearchThread t = new FileSearchThread(f, searchString);
				t.start();
			} 
		} else {
			System.out.println("No text files found.");
		}
		sc.close();
	}
}
