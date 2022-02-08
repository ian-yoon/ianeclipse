package ch19;

import java.net.InetAddress;

public class InetAddressEx {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getByName("naver.com");
			System.out.println(address);
			InetAddress[] addresses = InetAddress.getAllByName("naver.com");
			for (InetAddress i : addresses) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
