package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GoogleService extends UnicastRemoteObject implements IGoogle {
	public static GoogleService instance;
	
	private GoogleService() throws RemoteException {
		super();
	}
	
	public static GoogleService getInstance() {
		if(instance == null) {
			try {
				instance = new GoogleService();
			} catch(Exception e) {
				System.err.println("  # Error initializing Google service(): " + e.getMessage());
			}
		}
		
		return instance;
	}
	
	
	
	@Override
	public void login() throws RemoteException {
		System.out.println("Hola");
	}

}
