package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class Reto {
	private String nombre;
	private String fInicio;
	private String fFin;
	private double distancia;
	private double objetivo;
	
	public Reto(String nombre, String fInicio, String fFin, double distancia, double objetivo) {
		super();
		this.nombre = nombre;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.distancia = distancia;
		this.objetivo = objetivo;
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

	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", fInicio=" + fInicio + ", fFin=" + fFin + ", distancia=" + distancia
				+ ", objetivo=" + objetivo + ", tDeporte=" + "]";
	}
}