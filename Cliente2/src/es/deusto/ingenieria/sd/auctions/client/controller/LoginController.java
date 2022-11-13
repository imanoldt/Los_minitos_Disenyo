package es.deusto.ingenieria.sd.auctions.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//This class implements Controller pattern.
public class LoginController {	
	
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;
	//This attibute stores the token when login success
	private long token = -1; //-1 = login has not been done or fails

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public void regist(String nick, String pass, String email, String fNac, String peso, 
			String alt, String fCardMax, String fCardRep, String provedor) {
		try {
			this.serviceLocator.getService().regist(nick, pass, email, fNac, peso, alt, 
				fCardMax, fCardRep, provedor);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
	}
	
	public boolean login(String email, String password) {
		try {
			if(this.token == -1) {
				this.token = this.serviceLocator.getService().login(email, password);			
				return true;
			}
			return false;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public void logout() {
		try {
			this.serviceLocator.getService().logout(this.token);
			this.token = -1;
		} catch (RemoteException e) {
			System.out.println("# Error during logout: " + e);
		}
	}

	public long getToken() {
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}
}