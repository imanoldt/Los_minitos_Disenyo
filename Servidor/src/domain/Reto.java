package domain;

import java.io.Serializable;
import java.util.Date;

public class Reto implements Serializable {
	private String nombre;
	private Date fInicio;
	private Date fFin;
	private double distancia;
	private double objetivo;
	private TipoDeporte deporte;
	
	public Reto(String nombre, Date fInicio, Date fFin, double distancia, double objetivo, TipoDeporte deporte) {
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

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
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
	
	public TipoDeporte getDeporte() {
		return deporte;
	}
	
	public void setDeporte(TipoDeporte deporte) {
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