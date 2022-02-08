package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class SortFile {
	public static void main(String[] args) {
		List<Integer> items = new ArrayList<>();
		String f1 = "c:/data/input.txt";
		String f2 = "c:/data/output.txt";

		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));
			int count = 0;
			String str = "";
			while ((str = reader.readLine()) != null) {
				items.add(Integer.parseInt(str));
			}
			int[] nums = new int[items.size()];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = items.get(i);
			}
			int temp = 0;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] > nums[j]) {
						temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
				}
			}
			for (int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
				writer.write(nums[i] + "\r\n");
			}
			System.out.println("정렬이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
