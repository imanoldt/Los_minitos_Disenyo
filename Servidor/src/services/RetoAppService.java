package services;

import domain.Reto;
import domain.User;

public class RetoAppService {
	private static RetoAppService instance;
	
	public static RetoAppService getInstance() {
		if(instance == null) {
			instance = new RetoAppService();
		}
		return instance;
	}
	
	private RetoAppService() {}

	public void makeReto(Reto reto, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getRetos().add(reto);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
	
	public void activateReto(Reto reto, User user) {
		User u = LoginAppService.getUserMap().get(user.getEmail());
		u.getRetosAct().add(reto);
		LoginAppService.getUserMap().put(user.getEmail(), u);
	}
}
