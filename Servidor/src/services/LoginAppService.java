package services;

import java.rmi.RemoteException;
import java.util.*;

import dao.DAO;
import domain.User;
import domain.UserLocal;
import gateway.Factory;
import gateway.IGateway;

//TODO: Implement Singleton Pattern
public class LoginAppService implements IGateway {
	//private static Map<String, User> userMap = new HashMap<>();
	private static LoginAppService instance;
	
	public static LoginAppService getInstance() {
		if(instance == null) {
			instance = new LoginAppService();
		}
		return instance;
	}
	
	private LoginAppService() {}
		
	public boolean regist(User user) {
		/*
		if(userMap.containsKey(user.getEmail())) {
			return false;
		} 
		userMap.put(user.getEmail(), user);
		return true;
		*/
		if(DAO.getInstance().getUser(user.getEmail()) == null) {
			DAO.getInstance().storeUser(user);
			return true;
		}
		return false;
	}
	
	public User logIn(String email, String password) {
		//TODO: Get User using DAO and check 
		try {
			if(DAO.getInstance().getUser(email) != null) {
				User u = DAO.getInstance().getUser(email);
				if(Factory.getInstance().createGateway(u.getProvedor()).login(email, password)){
					return u;
				}
			}
		} catch(Exception e) {
			System.out.println("# LogIn error: " + e);
			return null;
		}
		return null;
	}
	
	/*
	public static Map<String, User> getUserMap() {
		return userMap;
	}
	*/
	
	public boolean login(String email, String pass) throws RemoteException {
		if(DAO.getInstance().getUser(email) != null) {
			return ((UserLocal) DAO.getInstance().getUser(email)).checkPassword(pass);
		}
		return false;
	}
}