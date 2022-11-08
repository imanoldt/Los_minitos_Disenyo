package clss;

import java.util.HashMap;

public enum TipoDeporte {
	CICLISMO(0,"ciclismo"), RUNNING(1,"running");
	
	private int id;
	private String nombre;
	
	private static HashMap<Integer,TipoDeporte> idDeporte = new HashMap<>();
	private static HashMap<String,TipoDeporte> nombreDeporte = new HashMap<>();
	
	static {
		for(TipoDeporte tipo : TipoDeporte.values()) {
			idDeporte.put(tipo.id, tipo);
			nombreDeporte.put(tipo.nombre, tipo);
			
		}
	}
	
	private TipoDeporte(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;	
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public static TipoDeporte saberTipo(int numero) {
		
		return idDeporte.get(numero);
	}
	
	public static TipoDeporte saberTipo(String tipo) {
		
		return nombreDeporte.get(tipo);
	}
	
	
}
