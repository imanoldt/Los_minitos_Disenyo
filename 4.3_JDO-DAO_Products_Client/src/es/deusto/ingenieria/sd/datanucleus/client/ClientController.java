package es.deusto.ingenieria.sd.datanucleus.client;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.dto.ProductDTO;

public class ClientController {
	public static void main(String[] args) throws RemoteException {
		RMIServiceLocator rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
		List<ProductDTO> products = rsl.getService().getProducts();
		System.out.println("Mixture of Products and Books ...");

		for (ProductDTO p : products) {
			System.out.println(p);
		}
	}
}