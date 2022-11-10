package clss;

public class User {

	private String email;
	private String nombre;
	private String fNacimiento;
	private double peso;
	private int altura;
	private double fCardiacaMaxima;
	private double fCardiacaReposo;
	private TipoProvedor provedor;
	private int estado;

	public User(String email, String nombre, String fNacimiento, double peso, int altura, double fCardiacaMaxima,
			double fCardiacaReposo, TipoProvedor provedor, int estado) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fNacimiento = fNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.fCardiacaMaxima = fCardiacaMaxima;
		this.fCardiacaReposo = fCardiacaReposo;
		this.provedor = provedor;
		this.estado = estado;
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getfCardiacaMaxima() {
		return fCardiacaMaxima;
	}

	public void setfCardiacaMaxima(double fCardiacaMaxima) {
		this.fCardiacaMaxima = fCardiacaMaxima;
	}

	public double getfCardiacaReposo() {
		return fCardiacaReposo;
	}

	public void setfCardiacaReposo(double fCardiacaReposo) {
		this.fCardiacaReposo = fCardiacaReposo;
	}

	public TipoProvedor getProvedor() {
		return provedor;
	}

	public void setProvedor(TipoProvedor provedor) {
		this.provedor = provedor;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", nombre=" + nombre + ", fNacimiento=" + fNacimiento + ", peso=" + peso
				+ ", altura=" + altura + ", fCardiacaMaxima=" + fCardiacaMaxima + ", fCardiacaReposo=" + fCardiacaReposo
				+ ", provedor=" + provedor + ", estado=" + estado + "]";
	}

}
