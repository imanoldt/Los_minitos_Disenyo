package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoDeporte;
import es.deusto.ingenieria.sd.auctions.server.data.dto.ArticleDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.CategoryDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	
	
	public void regist(String email, String password) throws RemoteException;

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public List<RetoDTO> getReto() throws RemoteException;
	
	public List<RetoDTO> getRetoActivado() throws RemoteException;
	
	public List<SesionDTO> getSesiones() throws RemoteException;
	
	public boolean makeSesion(String titulo, TipoDeporte tipo, double km, 
			String fInicio, int hora, double duracion) throws RemoteException;
	
	public boolean makeReto(String nombre, String fInicio, String fFin, double distancia, 
			double objetivo, TipoDeporte tDeporte) throws RemoteException;
	
	public boolean activateReto(String nombre) throws RemoteException;
}