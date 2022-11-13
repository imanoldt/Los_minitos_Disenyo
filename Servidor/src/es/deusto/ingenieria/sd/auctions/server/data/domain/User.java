package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.ArrayList;
import java.util.List;

public class User {	
	private String nickname;
	private String password;
	private String email;
	private String fNac;
	private double peso;
	private int altura;
	private double fCardiacaMaxima;
	private double fCardiacaReposo;
	private String provedor;
	private List<Reto> retos = new ArrayList<>();
	private List<Sesion> sesiones = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nick, String pass, String email, String fNac, double peso, 
			int alt, double fCardMax, double fCardRep, String provedor) {
		this.nickname = nick;
		this.password = pass;
		this.email = email;
		this.fNac = fNac;
		this.peso = peso;
		this.altura = alt;
		this.fCardiacaMaxima = fCardMax;
		this.fCardiacaReposo = fCardRep;
		this.provedor = provedor;
		this.retos = new ArrayList<>();
		this.sesiones = new ArrayList<>();
	}
		
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getfNac() {
		return fNac;
	}

	public void setfNac(String fNac) {
		this.fNac = fNac;
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

	public List<Reto> getRetos() {
		return retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	public void addSesion(Sesion sesion) {
		if (sesion != null && !this.sesiones.contains(sesion)) {
			this.sesiones.add(sesion);
		}
	}
	
	public void addReto(Reto reto) {
		if (reto != null && !this.retos.contains(reto)) {
			this.retos.add(reto);
		}
	}
		
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nickname);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
		result.append(this.retos.size());
		result.append(" retos) - (");
		result.append(this.sesiones.size());
		result.append(" sesiones)");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((User)obj).email);
		}
		
		return false;
	}
}