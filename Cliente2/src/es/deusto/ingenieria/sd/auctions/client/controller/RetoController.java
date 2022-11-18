package es.deusto.ingenieria.sd.auctions.client.controller;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;

public class RetoController {
	//Reference to the Service Locator
	private ServiceLocator serviceLocator;

	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public String[] getDeporte() {
		try {
			return this.serviceLocator.getService().getDeporteRet();
		} catch (Exception e) {
			System.out.println(" # Error during getDepRet: " + e);
			return null;
		}
	}
	
	public void makeReto(String nombre, String fInicio, String fFin, double distancia, double objetivo, String deporte) {
		try {
			this.serviceLocator.getService().makeReto(nombre, fInicio, fFin, distancia, objetivo, deporte);
		} catch(Exception e) {
			System.out.println(" # Error during reto making: " + e);
		}
	}
	
	public List<RetoDTO> getReto() {
		try {
			List<RetoDTO> list = this.serviceLocator.getService().getReto();
			return list;
		} catch(Exception e) {
			System.out.println(" # Error during get Reto: " + e);
			return null;
		}
	}
	
	public List<String> getRetoAct() {
		try {
			return this.serviceLocator.getService().getRetoActivado();
		} catch(Exception e) {
			System.out.println(" # Error during get RetoAct: " + e);
			return null;
		}
	}
	
	public void makeRetoAct(String s) {
		try {
			this.serviceLocator.getService().activateReto(s);
		} catch(Exception e) {
			System.out.println(" # Error Activate Reto: " + e);
		}
	}
}
