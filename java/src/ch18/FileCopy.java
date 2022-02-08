package ch18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void main(String[] args) {

		String str = "";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String file1 = "c:/dataex/a1.txt";
		String file2 = "c:/dataex/b1.txt";
		try {
			reader = new BufferedReader(new FileReader(new File(file1)));
			writer = new BufferedWriter(new FileWriter(new File(file2)));
			while(true) {
				str = reader.readLine();
				if (str == null)
					break;
				writer.write(str + "\r\n");
			}
			System.out.println("done");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
