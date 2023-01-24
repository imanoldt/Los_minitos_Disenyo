package services;

import dao.DAO;
import domain.Sesion;
import domain.User;
import domain.UserLocal;

public class SesionAppService {
	private static SesionAppService instance;
	
	public static SesionAppService getInstance() {
		if(instance == null) {
			instance = new SesionAppService();
		}
		return instance;
	}
	
	private SesionAppService() {}
	
	public void makeSesion(Sesion sesion, User user) {
		UserLocal u = (UserLocal) DAO.getInstance().getUser(user.getEmail());
		System.out.println("HOLA: " + u.getEmail());
		u.getSesiones().add(sesion);
		System.out.println("HOLI");
		DAO.getInstance().updateUser(u);
		System.out.println("ADIOS");
	}

}
