package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("시작합니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			System.exit(1);
		}

		Socket clientSocket = null;
		clientSocket = serverSocket.accept();
		System.out.println("Client's ip: " + clientSocket.getInetAddress().getHostAddress());

		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String receive = "";
		String send = "Welcome!!";
		writer.println(send);

		Scanner sc = new Scanner(System.in);
		while (true) {
			receive = reader.readLine();
			if (receive == null || receive.equals("q")) {
				break;
			}
			System.out.println("[client] " + receive);
			System.out.println("input(quit:q):");
			send = sc.nextLine();
			writer.println(send);
			if (send.equals("q")) {
				break;
			}
		}

		sc.close();
		writer.close();
		reader.close();
		clientSocket.close();
		serverSocket.close();

	}

}
