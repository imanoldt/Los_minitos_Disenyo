package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoDeporte;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public void regist(UserDTO dto) throws RemoteException;

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<RetoDTO> getReto() throws RemoteException;
	
	public List<RetoDTO> getRetoActivado() throws RemoteException;
	
	public List<SesionDTO> getSesion() throws RemoteException;
	
	public void makeSesion(SesionDTO dto, long token) throws RemoteException;
	
	public void makeReto(RetoDTO dto, long token) throws RemoteException;
	
	public void activateReto(String nombre, long token) throws RemoteException;
}