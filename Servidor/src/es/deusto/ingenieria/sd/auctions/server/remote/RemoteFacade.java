package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;
import es.deusto.ingenieria.sd.auctions.server.services.RetoAppService;
import es.deusto.ingenieria.sd.auctions.server.services.SesionAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private SesionAppService sesionAppService = new SesionAppService();
	private RetoAppService retoAppService = new RetoAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	//TODO REVISAR TODOS LOS EDITS Y COMENTARIOS 
	
	@Override
	public synchronized void regist(UserDTO dto) throws RemoteException {
		System.out.println(" * RemoteFacade regist(): " + dto.getEmail() + " / " + dto.getPassword());
		
		User u = new User(dto.getNickname(), dto.getPassword(), dto.getEmail(), dto.getfNac(), dto.getPeso(), dto.getAltura(), 
				dto.getfCardiacaMaxima(), dto.getfCardiacaReposo(), dto.getProvedor());
		if(!loginService.regist(u)) {
			throw new RemoteException("User is already logged in!");
		}
		
	}
	
	@Override
	public void makeSesion(String titulo, String deporte, double km, String fInicio, int hora, double duracion)
			throws RemoteException {
		System.out.println(" * Making Sesion: " + titulo + " " + deporte);
		Sesion sesion = new Sesion(titulo, deporte, km, fInicio, hora, duracion);
		User user = serverState.get(serverState.keySet().toArray()[0]);
		sesionAppService.makeSesion(sesion, user);
	}
	
	@Override
	public void makeReto(String nombre, String fInicio, String fFin, double distancia, double objetivo,
			String deporte) throws RemoteException {
		System.out.println(" * Making Reto: " + nombre + " " + deporte);
		Reto reto = new Reto(nombre, fInicio, fFin, distancia, objetivo, deporte);
		User user = serverState.get(serverState.keySet().toArray()[0]);
		retoAppService.makeReto(reto, user);
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
				this.serverState.put(token, user);		
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
	public List<String> getDeporte() throws RemoteException {
		return SesionDTO.getTipoDeporte();
	}
	
	@Override
	public String[] getDeporteRet() throws RemoteException {
		return RetoDTO.getTDeporte();
	}
	
	@Override
	public List<RetoDTO> getReto() throws RemoteException {
		List<RetoDTO> retos = new ArrayList<>();
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getRetos()) {
			retos.add(RetoAssembler.retoToDTO(r));
		}
		return retos;
	}
	
	@Override
	public List<String> getRetoActivado() throws RemoteException {
		List<String> retos = new ArrayList<>();
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getRetosAct()) {
			retos.add(RetoAssembler.retoToDTO(r).toString());
		}
		return retos;
	}
	
	@Override
	public void activateReto(String nombre) throws RemoteException {
		System.out.println(" * Activating Reto: " + nombre);
		User user = serverState.get(serverState.keySet().toArray()[0]);
		Reto reto = null;
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getRetos()) {
			if(r.toString().equals(nombre)) {
				reto = r;
			}
		}
		if(reto != null) {
			retoAppService.activateReto(reto, user);
		}
	}
	
}