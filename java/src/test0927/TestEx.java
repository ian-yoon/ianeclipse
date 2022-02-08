package test0927;

//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Random;
//import java.util.Scanner;

public class TestEx {

	public static void main(String[] args) {

		int[] num = new int[1000];
		num[0] = 100;
		num[4] = 200;
		num[9] = 300;
		num[999] = 500;
		for (int j = 0; j < num.length; j++) {
			if (Integer.valueOf(num[j]) > 0) {
				System.out.println((j+1) + "번째 위치: " + num[j]);
			}
		}
		
	}

}
