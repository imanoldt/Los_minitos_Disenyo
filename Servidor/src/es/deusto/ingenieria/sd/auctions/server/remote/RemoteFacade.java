package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoDeporte;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.auctions.server.services.BidAppService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private BidAppService bidService = new BidAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	//TODO REVISAR TODOS LOS EDITS Y COMENTARIOS 
	
	@Override
	public synchronized void regist(String nick, String pass, String email, String fNac, String peso, 
			String alt, String fCardMax, String fCardRep, String provedor) throws RemoteException {
		System.out.println(" * RemoteFacade regist(): " + email + " / " + pass);
		
		User u = new User(nick, pass, email, fNac, Double.valueOf(peso), Integer.valueOf(alt), 
				0, 0, 0);
		if(!loginService.regist(u)) {
			throw new RemoteException("User is already logged in!");
		}
		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
				
		//Perform login() using LoginAppService
		User user = loginService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				//this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<SesionDTO> getSesiones() throws RemoteException {
		System.out.println(" * RemoteFacade getArticle('')");

		//Get Articles using BidAppService
		List<Sesion> sesions = new ArrayList<Sesion>();//TODObidService.getSesiones(null);
		
		if (sesions != null) {
			//Convert domain object to DTO
			return SesionAssembler.getInstance().sesionToDTO(sesions);
		} else {
			throw new RemoteException("getArticles() fails!");
		}
	}
	
	@Override
	public List<RetoDTO> getReto() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<RetoDTO> getRetoActivado() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean activateReto(String nombre) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean makeReto(String nombre, String fInicio, String fFin, double distancia, double objetivo,
			TipoDeporte tDeporte) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean makeSesion(String titulo, TipoDeporte tipo, double km, String fInicio, int hora, double duracion)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}