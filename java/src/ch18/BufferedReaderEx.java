package ch18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("input: ");
		String str;
		try {
			str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
