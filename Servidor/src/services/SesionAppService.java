package services;

import domain.Sesion;
import domain.User;

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
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getSesiones().add(sesion);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}

}
