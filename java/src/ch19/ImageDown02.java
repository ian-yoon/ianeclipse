package ch19;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDown02 {

	public static void main(String[] args) throws Exception {

		String website = "https://cdn.pixabay.com/photo/2021/08/23/17/53/cat-6568422_960_720.jpg";

		URL url = new URL(website);
		byte[] buffer = new byte[4096];
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("c:/dataex/test02.jpg");
		int length = 0;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		System.out.println("done");

	}

}
