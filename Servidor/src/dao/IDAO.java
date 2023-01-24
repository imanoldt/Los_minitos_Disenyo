package dao;

import java.util.List;

import domain.*;

public interface IDAO {
	public void storeUser(User u);
	public void storeReto(Reto r);
	public void storeSesion(Sesion s);
	
	public void updateUser(User u);
	public void updateSesion(Sesion s);
	public void updateReto(Reto r);
	
	public User getUser(String mail);
	public List<Reto> getRetos(User u);
	public List<Sesion> getSesiones(User u);
	public List<Reto> getRetosAct(User u);

	public void deleteAllUsers();
}
