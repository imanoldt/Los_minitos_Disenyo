package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Reto;
import domain.Sesion;
import domain.TipoDeporte;
import domain.User;
import domain.UserLocal;
import dto.RetoAssembler;
import dto.RetoDTO;
import dto.SesionAssembler;
import dto.SesionDTO;
import dto.UserDTO;
import services.LoginAppService;
import services.RetoAppService;
import services.SesionAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = LoginAppService.getInstance();
	private SesionAppService sesionAppService = SesionAppService.getInstance();
	private RetoAppService retoAppService = RetoAppService.getInstance();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	//TODO REVISAR TODOS LOS EDITS Y COMENTARIOS 
	
	@Override
	public synchronized void regist(UserDTO dto) throws RemoteException {
		System.out.println(" * RemoteFacade regist(): " + dto.getEmail() + " / " + dto.getPassword());
		
		User u;
		if(dto.getProvedor() == 0) {
			u = new UserLocal(dto.getNickname(), dto.getPassword(), dto.getEmail(), dto.getfNac(), dto.getPeso(), dto.getAltura(), 
				dto.getfCardiacaMaxima(), dto.getfCardiacaReposo(), dto.getProvedor());
		} else {
			u = new User(dto.getNickname(), dto.getEmail(), dto.getfNac(), dto.getPeso(), dto.getAltura(), 
				dto.getfCardiacaMaxima(), dto.getfCardiacaReposo(), dto.getProvedor());
		}
		if(!loginService.regist(u)) {
			throw new RemoteException("User is already logged in!");
		}
		
	}
	
	@Override
	public void makeSesion(SesionDTO dto, long token) throws RemoteException {
		System.out.println(" * Making Sesion: " + dto.getTitulo() + " " + dto.getDeporte().toString());
		Sesion sesion = new Sesion(dto.getTitulo(), dto.getDeporte(), dto.getKm(), dto.getfInicio(), dto.getHora(), dto.getDuracion());
		User user = serverState.get(token);
		sesionAppService.makeSesion(sesion, user);
	}
	
	@Override
	public void makeReto(RetoDTO dto, long token) throws RemoteException {
		System.out.println(" * Making Reto: " + dto.getNombre() + " " + dto.getDeporte().toString());
		Reto reto = new Reto(dto.getNombre(), dto.getfInicio(), dto.getfFin(), 
				dto.getDistancia(), dto.getObjetivo(), dto.getDeporte());
		User user = serverState.get(token);
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
	public List<RetoDTO> getReto() throws RemoteException {
		List<RetoDTO> retos = new ArrayList<>();
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getRetos()) {
			retos.add(RetoAssembler.retoToDTO(r));
		}
		return retos;
	}
	
	@Override
	public List<RetoDTO> getRetoActivado() throws RemoteException {
		List<RetoDTO> retos = new ArrayList<>();
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getRetosAct()) {
			retos.add(RetoAssembler.retoToDTO(r));
		}
		return retos;
	}
	
	@Override
	public List<SesionDTO> getSesion() throws RemoteException {
		List<SesionDTO> retos = new ArrayList<>();
		for(Sesion r: LoginAppService.getUserMap().get(serverState.get(serverState.keySet().toArray()[0]).getEmail()).getSesiones()) {
			retos.add(SesionAssembler.sesionToDTO(r));
		}
		return retos;
	}
	
	@Override
	public void activateReto(String nombre, long token) throws RemoteException {
		System.out.println(" * Activating Reto: " + nombre);
		User user = serverState.get(token);
		Reto reto = null;
		for(Reto r: LoginAppService.getUserMap().get(serverState.get(token).getEmail()).getRetos()) {
			if(r.toString().equals(nombre)) {
				reto = r;
			}
		}
		if(reto != null) {
			retoAppService.activateReto(reto, user);
		}
	}
	
}