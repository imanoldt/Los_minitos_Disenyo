package es.deusto.ingenieria.sd.auctions.client.controller;

import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoDeporte;
import es.deusto.ingenieria.sd.auctions.server.data.dto.SesionDTO;

public class SesionController {
	//Reference to the Service Locator
		private ServiceLocator serviceLocator;
		private long token;

		public SesionController(ServiceLocator serviceLocator, long token) {
			this.serviceLocator = serviceLocator;
			this.token = token;
		}
		
		public void makeSesion(String titulo, int deporte, double km, Date fInicio, int hora, double duracion) {
			try {
				SesionDTO dto = new SesionDTO();
				dto.setDeporte(TipoDeporte.values()[deporte]);
				dto.setDuracion(duracion);
				dto.setfInicio(fInicio);
				dto.setHora(hora);
				dto.setKm(km);
				dto.setTitulo(titulo);
				this.serviceLocator.getService().makeSesion(dto, token);
			} catch(Exception e) {
				System.out.println("# Error during session making: " + e);
			}
		}
		
		
}
