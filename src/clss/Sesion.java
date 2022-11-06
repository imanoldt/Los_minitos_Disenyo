package clss;

public class Sesion {
	private String titulo;
	private Enum tipo;
	private Double km;
	private String fInicio;
	private Integer hora;
	private Double duracion;

	public Sesion(String titulo, Enum tipo, Double km, String fInicio, Integer hora, Double duracion) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.km = km;
		this.fInicio = fInicio;
		this.hora = hora;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Enum getTipo() {
		return tipo;
	}

	public void setTipo(Enum tipo) {
		this.tipo = tipo;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public String getfInicio() {
		return fInicio;
	}

	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Sesion [titulo=" + titulo + ", tipo=" + tipo + ", km=" + km + ", fInicio=" + fInicio + ", hora=" + hora
				+ ", duracion=" + duracion + "]";
	}

}
