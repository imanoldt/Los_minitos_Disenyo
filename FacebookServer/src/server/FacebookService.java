package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FacebookService extends Thread {
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private static Map<String, String> userMap;

	public FacebookService(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			userMap = new HashMap<>();
			userMap.put("Kerman", "Urrukoetxea");
			userMap.put("Markel", "Contreras");
			userMap.put("Imanol", "Duran");
			userMap.put("Alvaro", "Garcia");
			userMap.put("Robby", "Retos");
			this.start();
		} catch (Exception e) {
			System.out.println("# FacebookService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		//Echo server
		try {
			//Read request from the client
			String email = this.in.readUTF();	
			String pass = this.in.readUTF();	
			System.out.println("   - FacebookService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + email + " : " + pass + "'");		
			
			//Send response to the client
			String resp;
			resp = login(email, pass);
			this.out.writeUTF(resp);			
			System.out.println("   - FacebookService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + resp + "'");
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
	
	private String login(String email, String pass) {
		if(userMap.containsKey(email)) {
			if(pass.equals(userMap.get(email))) {
				return "1";
			}
		}
		return "0";
	}

}
