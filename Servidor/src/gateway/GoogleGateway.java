package gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;

import domain.TipoProvedor;
import remote.IGoogle;

public class GoogleGateway implements IGateway {
	private static GoogleGateway instance;
	private IGoogle googleServer;
	
	private GoogleGateway() {
		try {
			String URL = "//127.0.0.1:1099/GoogleServer";
			this.googleServer = (IGoogle) Naming.lookup(URL);
		} catch(Exception e) {
			System.err.println("# Error locating remote services: " + e);
		}
	}
	
	public static GoogleGateway getInstance() {
		if(instance == null) {
			instance = new GoogleGateway();
		}
		
		return instance;
	}
	
	public boolean login(String email, String pass) throws RemoteException {
		System.out.println("   - LogIn from Google Servers");
		
		try {
			return this.googleServer.login(email, pass);
		} catch(Exception e) {
			System.out.println(" $ Error LogIn with Google: " + e);
			return false;
		}
	}
}
