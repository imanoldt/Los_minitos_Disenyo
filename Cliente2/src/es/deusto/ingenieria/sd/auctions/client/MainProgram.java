package es.deusto.ingenieria.sd.auctions.client;

import java.awt.EventQueue;
import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;
import windows.VentanaLoginN;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		/*
		LoginController loginController = new LoginController(serviceLocator);
		LoginDialog loginDialog = new LoginDialog(loginController);			
		BidController bidController = new BidController(serviceLocator);			
		BidWindow bidWindow = new BidWindow(bidController);
		
		//Login
		loginDialog.login();		
		//Get Categories
		
		//Logout
		loginDialog.logout();
		*/
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