package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookService extends Thread {
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;

	public FacebookService(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (Exception e) {
			System.out.println("# FacebookService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		//Echo server
		try {
			//Read request from the client
			String data = this.in.readUTF();			
			System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
			
			//Send response to the client
			this.out.writeUTF(data.toUpperCase());			
			System.out.println("   - FacebookService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
		} catch (Exception e) {
			System.out.println("   # FacebookService error" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (Exception e) {
				System.out.println("   # FacebookService error:" + e.getMessage());
			}
		}
	}

}
