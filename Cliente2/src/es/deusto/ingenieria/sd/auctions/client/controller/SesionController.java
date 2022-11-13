package es.deusto.ingenieria.sd.auctions.client.controller;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.client.remote.ServiceLocator;

public class SesionController {
	//Reference to the Service Locator
		private ServiceLocator serviceLocator;

		public SesionController(ServiceLocator serviceLocator) {
			this.serviceLocator = serviceLocator;
		}
		
		public List<String> getDeporte() {
			try {
				return this.serviceLocator.getService().getDeporte();
			} catch (Exception e) {
				System.out.println("Error during getDep: " + e);
				return null;
			}
		}
		
		
}
