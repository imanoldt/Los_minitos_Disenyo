package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoDeporte;

public class RetoDTO {
	private String nombre;
	private String fInicio;
	private String fFin;
	private double distancia;
	private double objetivo;
	private TipoDeporte tDeporte;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getfInicio() {
		return fInicio;
	}

	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}

	public String getfFin() {
		return fFin;
	}

	public void setfFin(String fFin) {
		this.fFin = fFin;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(double objetivo) {
		this.objetivo = objetivo;
	}

	public TipoDeporte gettDeporte() {
		return tDeporte;
	}

	public void settDeporte(TipoDeporte tDeporte) {
		this.tDeporte = tDeporte;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nombre);
		result.append(" - ");
		result.append(this.fInicio);
		result.append(" - ");
		result.append(this.fFin);
		result.append(" - ");
		result.append(this.distancia);
		result.append(" - ");
		result.append(this.objetivo);
		result.append(" - ");
		result.append(this.tDeporte);
		
		return result.toString();		
	}
}
