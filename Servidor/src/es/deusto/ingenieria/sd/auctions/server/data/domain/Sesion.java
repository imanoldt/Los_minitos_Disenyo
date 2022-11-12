package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class Sesion {
	private String titulo;
	
	private double km;
	private String fInicio;
	private int hora;
	private double duracion;

	public Sesion(String titulo, double km, String fInicio, int hora, double duracion) {
		super();
		this.titulo = titulo;
	
		this.km = km;
		this.fInicio = fInicio;
		this.hora = hora;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", km=" + km + ", fInicio=" + fInicio + ", hora=" + hora
				+ ", duracion=" + duracion + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public String getfInicio() {
		return fInicio;
	}

	public void setfInicio(String fInicio) {
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
