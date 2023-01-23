package es.deusto.ingenieria.sd.datanucleus.jdo.remote;

import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Shelf;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.dto.ProductAssembler;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.dto.ProductDTO;
import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.IProductDAO;
import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.ProductDAO;

public class ProductFinderServer extends UnicastRemoteObject implements IProductFinder {
	private IProductDAO dao;

	private static final long serialVersionUID = 1L;

	public ProductFinderServer() throws RemoteException {
		super();
		
		//Test DAO when the Server Starts
		dao = new ProductDAO();
		
		Product product1 = new Product("iPad Air 2020", "A new iPad from Apple", 600d);
		dao.storeProduct(product1);
		
		Book book1 = new Book("Greenlights", "First Edition", 500d, "Matthew McConaughey", "978-0593139134", "Crown");
		Shelf shelf = new Shelf("Fifth Shelf");
		book1.addCopy("49", "Perfect, almost new", shelf);
		book1.addCopy("62", "Scratches on front cover", shelf);
		
		dao.storeProduct(book1);
	}

	@Override
	public List<ProductDTO> getProducts() throws RemoteException {
		List<Product> products = dao.getProducts();
		System.out.println("Returning Products to client ....");
				
		return new ProductAssembler().domainObjectListToDTO(products);
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Attention: arguments missing");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IProductFinder server = new ProductFinderServer();
			Naming.rebind(name, server);
			System.out.println("Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("Product Finder Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}
}