package clss;

public class User {
	
	private String nombre;
	private String email;
	private String DNI;
	
	
	
	public User(String nombre, String email, String dNI) {
		super();
		this.nombre = nombre;
		this.email = email;
		DNI = dNI;

	}
	
	public User() {
		super();
		this.nombre = null;
		this.email = null;
		DNI = null;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", email=" + email + ", DNI=" + DNI +"]";
	}
	
	

}
