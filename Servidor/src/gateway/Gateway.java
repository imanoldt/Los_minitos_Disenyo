package gateway;

import java.rmi.RemoteException;

public interface Gateway {
	public boolean login(String email, String pass) throws RemoteException;
}
