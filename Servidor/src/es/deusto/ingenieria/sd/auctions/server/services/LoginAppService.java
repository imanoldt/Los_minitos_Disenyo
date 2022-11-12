package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.*;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	private Map<String, User> userMap = new HashMap<>();
		
	public boolean regist(User user) {
		if(userMap.containsKey(user.getEmail())) {
			return false;
		} 
		userMap.put(user.getEmail(), user);
		return true;
	}
	
	public boolean login(String email, String password) {
		//TODO: Get User using DAO and check 		
		if(userMap.containsKey(email)) {
			return password.equals(userMap.get(email).checkPassword(password));
		}
		return false;
	}
}