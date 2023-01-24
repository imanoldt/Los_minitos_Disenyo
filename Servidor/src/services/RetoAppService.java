package services;

import java.util.List;

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
		reto.setUser(user.getEmail());
		reto.setIsActive(0);
		DAO.getInstance().storeReto(reto);
	}
	
	public void activateReto(Reto reto, User user) {
		List<Reto> rL = DAO.getInstance().getRetos(user);
		for(Reto r: rL) {
			if(r.toString().equals(reto.toString())) {
				reto.setIsActive(1);
			}
		}
		DAO.getInstance().storeReto(reto);
	}
}
