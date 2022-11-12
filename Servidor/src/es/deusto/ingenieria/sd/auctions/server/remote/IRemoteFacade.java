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
	
	public List<RetoDTO> getReto() throws RemoteException;
	
	public List<RetoDTO> getRetoActivado() throws RemoteException;
	
	public List<SesionDTO> getSesiones() throws RemoteException;
	
	public boolean makeSesion(String titulo, double km, 
			String fInicio, int hora, double duracion) throws RemoteException;
	
	public boolean makeReto(String nombre, String fInicio, String fFin, double distancia, 
			double objetivo) throws RemoteException;
	
	public boolean activateReto(String nombre) throws RemoteException;
}