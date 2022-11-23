package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.TipoDeporte;
import dto.RetoDTO;
import dto.SesionDTO;
import remote.ServiceLocator;

public class SesionController {
	//Reference to the Service Locator
		private ServiceLocator serviceLocator;
		private long token;

		public SesionController(ServiceLocator serviceLocator, long token) {
			this.serviceLocator = serviceLocator;
			this.token = token;
		}
		
		public List<String> getSesion() {
			try {
				List<SesionDTO> list = this.serviceLocator.getService().getSesion();
				List<String> sList = new ArrayList<>();
				for(SesionDTO dto: list) {
					sList.add(dto.toString());
				}
				return sList;
			} catch(Exception e) {
				System.out.println(" # Error during get Sesion: " + e);
				return null;
			}
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
