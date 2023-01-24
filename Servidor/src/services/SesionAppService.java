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
		sesion.setUser(user.getEmail());
		DAO.getInstance().storeSesion(sesion);
	}

}
