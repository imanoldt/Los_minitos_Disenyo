package es.deusto.ingenieria.sd.org.datanucleus.jdo.dao;

import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Shelf;

public interface IProductDAO {
	public void storeProduct(Product product);
	public Product getProduct(String name);
	public void updateProduct(Product product);
	
	public List<Product> getProducts();
	public List<Book> getBooks();
	public Shelf getShelf(String name);

	public void deleteAllProducts();
}