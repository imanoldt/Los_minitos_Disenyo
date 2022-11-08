package clss;

import java.util.HashMap;

public enum EstadoCuenta {
	DESCONECTADO(0,"desconectado"),CONECTADO(1,"conectado");
	
	private int id;
	private String nombre;
	
	private static HashMap<Integer,EstadoCuenta> idACuenta = new HashMap<>();
	private static HashMap<String,EstadoCuenta> nombreACuenta = new HashMap<>();
	
	static {
		for(EstadoCuenta estado : EstadoCuenta.values()) {
			idACuenta.put(estado.id, estado);
			nombreACuenta.put(estado.nombre, estado);
		}
	}
	
	private EstadoCuenta(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;	
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public static EstadoCuenta saberEstado(int numero) {
		
		return idACuenta.get(numero);
	}
	
	public static EstadoCuenta saberEstado(String tipo) {
		
		return nombreACuenta.get(tipo);
	}

}
