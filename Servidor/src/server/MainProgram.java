package server;

import java.rmi.Naming;

import remote.IRemoteFacade;
import remote.RemoteFacade;

public class MainProgram {

	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = RemoteFacade.getInstance();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Strava Server '" + name + "' started!!");
			System.out.println(" * Strava Socket '" + args[3] + ":" + args[4] + "' started!");
		} catch (Exception ex) {
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
