package clss;

import java.util.HashMap;

public enum TipoProvedor {
	EMAIL(0,"email"), GOOGLE(1,"google"), FACEBOOK(2,"facebook");
	
	private int id;
	private String nombre;
	
	private static HashMap<Integer,TipoProvedor> idACuenta = new HashMap<>();
	private static HashMap<String,TipoProvedor> nombreACuenta = new HashMap<>();
	
	static {
		for(TipoProvedor tipo : TipoProvedor.values()) {
			idACuenta.put(tipo.id, tipo);
			nombreACuenta.put(tipo.nombre, tipo);
		}
	}
	
	private TipoProvedor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;	
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public static TipoProvedor saberTipo(int numero) {
		
		return idACuenta.get(numero);
	}
	
	public static TipoProvedor saberTipo(String tipo) {
		
		return nombreACuenta.get(tipo);
	}

}
