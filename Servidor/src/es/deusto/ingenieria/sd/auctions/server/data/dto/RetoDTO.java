package es.deusto.ingenieria.sd.auctions.server.data.dto;


public class RetoDTO {
	private String nombre;
	private String fInicio;
	private String fFin;
	private double distancia;
	private double objetivo;
	
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
		
		return result.toString();		
	}
}
