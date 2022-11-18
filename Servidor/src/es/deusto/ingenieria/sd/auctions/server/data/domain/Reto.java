package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.io.Serializable;

public class Reto implements Serializable {
	private String nombre;
	private String fInicio;
	private String fFin;
	private double distancia;
	private double objetivo;
	private String deporte;
	
	public Reto(String nombre, String fInicio, String fFin, double distancia, double objetivo, String deporte) {
		super();
		this.nombre = nombre;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.distancia = distancia;
		this.objetivo = objetivo;
		this.deporte = deporte;
	}

	public Reto() {

	}

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
	
	public String getDeporte() {
		return deporte;
	}
	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
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
		result.append(this.deporte);
		
		return result.toString();		
	}
	
	/*
	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fInicio=" + fInicio + ", fFin=" + fFin + ", distancia=" + distancia
				+ ", objetivo=" + objetivo + ", tDeporte=" + deporte + "]";
	}
	*/
}