package domain;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Sesion implements Serializable {
	private String titulo;
	private TipoDeporte deporte;
	private double km;
	private Date fInicio;
	private int hora;
	private double duracion;
	private String user;

	public Sesion(String titulo, TipoDeporte deporte, double km, Date fInicio, int hora, double duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.km = km;
		this.fInicio = fInicio;
		this.hora = hora;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", deporte=" + deporte + ", km=" + km + ", fInicio=" + fInicio + ", hora=" + hora
				+ ", duracion=" + duracion + "]";
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

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

}
