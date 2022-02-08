package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTableServer implements Runnable {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public MultiTableServer() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("started...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
			System.exit(1);
		}
		while (true) {
			try {
				socket = serverSocket.accept();
				InetAddress ip = socket.getInetAddress();
				System.out.println("client's ip: " + ip);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				Thread th = new Thread(this);
				th.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MultiTableServer();
	}

	@Override
	public void run() {
		while (true) {
			int table;
			try {
				table = dis.readInt();
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(table + "x" + i + "=" + table * i + "\r\n");
				}
				dos.writeUTF(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
