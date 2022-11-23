package cliente;

import java.awt.EventQueue;

import remote.ServiceLocator;
import windows.VentanaLoginN;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		serviceLocator.setService(args[0], args[1], args[2]);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginN frame = new VentanaLoginN(serviceLocator);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}