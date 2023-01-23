package services;

import dao.DAO;
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
		User u = DAO.getInstance().getUser(user.getEmail());
		u.getRetos().add(reto);
		DAO.getInstance().updateUser(u);
	}
	
	public void activateReto(Reto reto, User user) {
		User u = DAO.getInstance().getUser(user.getEmail());
		u.getRetosAct().add(reto);
		DAO.getInstance().updateUser(u);
	}
}
