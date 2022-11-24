package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class GoogleService extends UnicastRemoteObject implements IGoogle {
	
	public static GoogleService instance;
	private static Map<String, String> userMap;
	
	private GoogleService() throws RemoteException {
		super();
		userMap = new HashMap<>();
		userMap.put("Kerman", "Urrukoetxea");
		userMap.put("Markel", "Contreras");
		userMap.put("Imanol", "Duran");
		userMap.put("Alvaro", "Garcia");
		userMap.put("Robby", "Retos");
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
	public boolean login(String email, String pass) throws RemoteException {
		if(userMap.containsKey(email)) {
			return pass.equals(userMap.get(email));
		}
		return false;
	}

}
