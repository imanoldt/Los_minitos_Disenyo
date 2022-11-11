package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Sesion;

public class SesionAssembler {
	private static SesionAssembler instance;

	private SesionAssembler() { }
	
	public static SesionAssembler getInstance() {
		if (instance == null) {
			instance = new SesionAssembler();
		}

		return instance;
	}

	public SesionDTO sesionToDTO(Sesion sesion) {
		SesionDTO dto = new SesionDTO();
		
		dto.setDuracion(sesion.getDuracion());
		dto.setfInicio(sesion.getfInicio());
		dto.setHora(sesion.getHora());
		dto.setKm(sesion.getKm());
		dto.setTipo(sesion.getTipo());
		dto.setTitulo(sesion.getTitulo());
				
		return dto;
	}
	
	public List<SesionDTO> sesionToDTO(List<Sesion> sesions) {
		List<SesionDTO> dtos = new ArrayList<>();
		
		for (Sesion sesion : sesions) {
			dtos.add(this.sesionToDTO(sesion));
		}
		
		return dtos;		
	}
}