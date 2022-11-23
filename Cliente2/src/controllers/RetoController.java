package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.TipoDeporte;
import dto.RetoDTO;
import remote.ServiceLocator;

public class RetoController {
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;
	private long token;

	public RetoController(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public void makeReto(String nombre, Date fInicio, Date fFin, double distancia, double objetivo, int deporte) {
		try {
			RetoDTO dto = new RetoDTO();
			dto.setDeporte(TipoDeporte.values()[deporte]);
			dto.setDistancia(distancia);
			dto.setfFin(fFin);
			dto.setfInicio(fInicio);
			dto.setNombre(nombre);
			dto.setObjetivo(objetivo);
			this.serviceLocator.getService().makeReto(dto, token);
		} catch(Exception e) {
			System.out.println(" # Error during reto making: " + e);
		}
	}
	
	public List<String> getReto() {
		try {
			List<RetoDTO> list = this.serviceLocator.getService().getReto();
			List<String> sList = new ArrayList<>();
			for(RetoDTO dto: list) {
				sList.add(dto.toString());
			}
			return sList;
		} catch(Exception e) {
			System.out.println(" # Error during get Reto: " + e);
			return null;
		}
	}
	
	public List<String> getRetoAct() {
		try {
			List<RetoDTO> list = this.serviceLocator.getService().getRetoActivado();
			List<String> sList = new ArrayList<>();
			for(RetoDTO dto: list) {
				sList.add(dto.toString());
			}
			return sList;
		} catch(Exception e) {
			System.out.println(" # Error during get RetoAct: " + e);
			return null;
		}
	}
	
	public void makeRetoAct(String s) {
		try {
			this.serviceLocator.getService().activateReto(s, token);
		} catch(Exception e) {
			System.out.println(" # Error Activate Reto: " + e);
		}
	}
}
