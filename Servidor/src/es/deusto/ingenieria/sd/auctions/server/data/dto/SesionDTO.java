package es.deusto.ingenieria.sd.auctions.server.data.dto;



public class SesionDTO {
	//This attribute is needed to implement the "Serializable" interface.
		private static final long serialVersionUID = 1L;
		private String titulo;
		private double km;
		private String fInicio;
		private int hora;
		private double duracion;

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
