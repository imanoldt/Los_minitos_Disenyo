package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class Sesion {
	private String titulo;
	private String deporte;
	private double km;
	private String fInicio;
	private int hora;
	private double duracion;

	public Sesion(String titulo, String deporte, double km, String fInicio, int hora, double duracion) {
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDeporte() {
		return deporte;
	}
	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
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
