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
			String alt, String fCardMax, String fCardRep, int provedor) {
		try {
			UserDTO dto = new UserDTO();
			dto.setAltura(Integer.valueOf(alt));
			dto.setEmail(email);
			dto.setProvedor(provedor);
			dto.setfCardiacaMaxima(Double.valueOf(fCardMax));
			dto.setfCardiacaReposo(Double.valueOf(fCardRep));
			dto.setfNac(fNac);
			dto.setNickname(nick);
			dto.setPassword(pass);
			dto.setPeso(Double.valueOf(peso));
			this.serviceLocator.getService().regist(dto);
		} catch (RemoteException e) {
			System.out.println("# Error during registration: " + e);
		}
	}
	
	public boolean login(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().login(email, password);			
			return true;
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