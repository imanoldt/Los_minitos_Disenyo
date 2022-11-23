package gateway;

import java.rmi.Naming;
import remote.IGoogle;

public class ExternalServersGateway {
	
	private static ExternalServersGateway instance;
	private IGoogle googleServer;
	
	private ExternalServersGateway() {
		try {
			String URL = "//127.0.0.1:1099/GoogleServer";
			this.googleServer = (IGoogle) Naming.lookup(URL);
		} catch(Exception e) {
			System.err.println("# Error locating remote google service: " + e);
		}
	}
	
	public static ExternalServersGateway getInstance() {
		if(instance == null) {
			instance = new ExternalServersGateway();
		}
		
		return instance;
	}
	
	public void login() {
		System.out.println("   - LogIn from Google Servers");
		
		try {
			this.googleServer.login();
		} catch(Exception e) {
			System.out.println(" $ Error LogIn with Google: " + e);
		}
	}

}
