package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;

	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}

	public static RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		dto.setDeporte(reto.getDeporte());
		dto.setDistancia(reto.getDistancia());
		dto.setfFin(reto.getfFin());
		dto.setfInicio(reto.getfInicio());
		dto.setNombre(reto.getNombre());
		dto.setObjetivo(reto.getObjetivo());
				
		return dto;
	}
	
	public List<RetoDTO> retoToDTO(List<Reto> retos) {
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;		
	}
}
