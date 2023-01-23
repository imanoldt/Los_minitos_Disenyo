package dao;

import java.util.List;

import domain.*;

public interface IDAO {
	public void storeUser(User u);
	public User getUser(String mail, String pass);
	public void updateUser(User u);
	
	public List<Reto> getRetos(User u);
	public List<Sesion> getSesiones(User u);
	public List<Reto> getRetosAct(User u);

	public void deleteAllUsers();
}
