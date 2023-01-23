package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class User implements Serializable {	
	private String nickname;
	private String email;
	private Date fNac;
	private double peso;
	private int altura;
	private double fCardiacaMaxima;
	private double fCardiacaReposo;
	private TipoProvedor provedor;
	@Join
	@Persistent(dependentElement = "true")
	private List<Reto> retos = new ArrayList<>();
	@Join
	@Persistent(dependentElement = "true")
	private List<Reto> retosAct = new ArrayList<>();
	@Join
	@Persistent(dependentElement = "true")
	private List<Sesion> sesiones = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nick, String email, Date fNac, double peso, 
			int alt, double fCardMax, double fCardRep, int provedor) {
		this.nickname = nick;
		this.email = email;
		this.fNac = fNac;
		this.peso = peso;
		this.altura = alt;
		this.fCardiacaMaxima = fCardMax;
		this.fCardiacaReposo = fCardRep;
		this.provedor = TipoProvedor.values()[provedor];
		this.retos = new ArrayList<>();
		this.sesiones = new ArrayList<>();
	}
		
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
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
	
	public TipoProvedor getProvedor() {
		return provedor;
	}
	
	public void setProvedor(int provedor) {
		this.provedor = TipoProvedor.values()[provedor];
	}
	
	public void setProvedor(TipoProvedor provedor) {
		this.provedor = provedor;
	}

	public List<Reto> getRetos() {
		return retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	
	public List<Reto> getRetosAct() {
		return retosAct;
	}
	
	public void setRetosAct(List<Reto> retosAct) {
		this.retosAct = retosAct;
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
		result.append(this.retosAct.size());
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