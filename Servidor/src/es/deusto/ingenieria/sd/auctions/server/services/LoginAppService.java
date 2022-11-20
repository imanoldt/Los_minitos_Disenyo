package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.*;

import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoProvedor;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.domain.UserLocal;

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