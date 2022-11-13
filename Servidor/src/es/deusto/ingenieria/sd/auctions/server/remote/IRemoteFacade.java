package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public void regist(String nick, String pass, String email, String fNac, String peso, 
			String alt, String fCardMax, String fCardRep, String provedor) throws RemoteException;

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<String> getDeporte() throws RemoteException;
	
	public String[] getDeporteRet() throws RemoteException;
	
	public List<String> getReto() throws RemoteException;
	
	public List<String> getRetoActivado() throws RemoteException;
	
	public void makeSesion(String titulo, String deporte, double km, String fInicio, 
			int hora, double duracion) throws RemoteException;
	
	public void makeReto(String nombre, String fInicio, String fFin, 
			double distancia, double objetivo, String deporte) throws RemoteException;
	
	public void activateReto(String nombre) throws RemoteException;
}