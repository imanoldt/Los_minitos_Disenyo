package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.Date;

public class UserLocal extends User {
	private String password;
	
	public UserLocal(String nick, String pass, String email, Date fNac, double peso, 
			int alt, double fCardMax, double fCardRep, int provedor) {
		super(nick, email, fNac, peso, alt, fCardMax, fCardRep, provedor);
		this.password = pass;
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
}
