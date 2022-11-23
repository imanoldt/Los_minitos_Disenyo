package services;

import java.util.*;

import domain.TipoProvedor;
import domain.User;
import domain.UserLocal;
import gateway.ExternalServersGateway;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	private static Map<String, User> userMap = new HashMap<>();
		
	public boolean regist(User user) {
		if(userMap.containsKey(user.getEmail())) {
			return false;
		} 
		userMap.put(user.getEmail(), user);
		return true;
	}
	
	public User login(String email, String password) {
		//TODO: Get User using DAO and check 	
		ExternalServersGateway.getInstance().login(TipoProvedor.GOOGLE);
		ExternalServersGateway.getInstance().login(TipoProvedor.FACEBOOK);
		
		if(userMap.containsKey(email)) {
			User u = userMap.get(email);
			if(u.getProvedor().compareTo(TipoProvedor.LOCAL) == 0) {
				UserLocal uL = (UserLocal) u;
				if(uL.checkPassword(password)) {
					return uL;
				} 
			} else {
				return u;
			}
		}
		return null;
	}
	
	public static Map<String, User> getUserMap() {
		return userMap;
	}
}