package ch19;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDown {

	public static void main(String[] args) {
		
		String website = "https://cdn.pixabay.com/photo/2020/07/21/16/24/landscape-5426755_960_720.jpg";
		
		try {
			URL url = new URL(website);
			byte[] buffer = new byte[4096];
			InputStream in = url.openStream();
			OutputStream out = new FileOutputStream("c:/dataex/test.jpg");
			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
