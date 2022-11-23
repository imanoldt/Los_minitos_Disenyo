package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.TipoDeporte;

public class SesionDTO implements Serializable{
	//This attribute is needed to implement the "Serializable" interface.
	private String titulo;
	private TipoDeporte deporte;
	private double km;
	private Date fInicio;
	private int hora;
	private double duracion;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public TipoDeporte getDeporte() {
		return deporte;
	}
	
	public void setDeporte(TipoDeporte deporte) {
		this.deporte = deporte;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.titulo);
		result.append(" - ");
		result.append(this.km);
		result.append("km - Session begin: ");
		result.append(this.fInicio);
		result.append(" - Start time: ");
		result.append(this.hora);
		result.append(" - Tot. Time: ");
		result.append(this.duracion);
		result.append(" minutes");
			
		return result.toString();
	}
}
