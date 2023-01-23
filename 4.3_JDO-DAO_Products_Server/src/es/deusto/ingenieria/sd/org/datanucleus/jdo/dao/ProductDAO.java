package es.deusto.ingenieria.sd.org.datanucleus.jdo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Shelf;

public class ProductDAO implements IProductDAO {

	private PersistenceManagerFactory pmf;

	public ProductDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	public void storeProduct(Product product) {
		this.storeObject(product);
	}

	public void storeBook(Book book) {
		this.storeProduct(book);
	}

	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public List<Product> getProducts() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Product> products = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Products.");

			tx.begin();
			Extent<Product> extent = pm.getExtent(Product.class, true);

			for (Product product : extent) {
				products.add(product);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return products;
	}

	public List<Book> getBooks() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Book> books = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Books.");

			tx.begin();
			Extent<Book> extent = pm.getExtent(Book.class, true);

			for (Book book : extent) {
				books.add(book);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return books;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts(String condition) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Product> products = new ArrayList<Product>();

		try {
			System.out.println("   * Executing a Query for Products given a condition: " + condition);

			tx.begin();
			Extent<Product> extent = pm.getExtent(Product.class, true);
			Query<Product> query = pm.newQuery(extent, condition);

			for (Product product : (List<Product>) query.execute()) {
				products.add(product);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return products;
	}

	public Product getProduct(String name) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Product product = null;

		try {
			System.out.println("   * Querying a Product: " + name);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Product.class.getName() + " WHERE name == '" + name + "'");
			query.setUnique(true);
			product = (Product) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return product;
	}

	public Shelf getShelf(String name) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Shelf shelf = null;

		try {
			System.out.println("   * Querying a Shelf: " + name);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Shelf.class.getName() + " WHERE identifier == '" + name + "'");
			query.setUnique(true);
			shelf = (Shelf) query.execute();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return shelf;
	}

	public void updateProduct(Product product) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(product);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public void deleteAllProducts() {
		System.out.println("- Cleaning the DB...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			// Getting ready for removing objects - Remove Relationships between Copy and Shelf
			Extent<Book> extentB = pm.getExtent(Book.class, true);
			
			for (Book b : extentB) {
				b.removeCopies();
			}
			
			// Updating the database so changes are considered before commit
			pm.flush();

			Query<Shelf> query1 = pm.newQuery(Shelf.class);
			System.out.println(" * '" + query1.deletePersistentAll() + "' shelves deleted from the DB.");

			// Deleting All Products - Copies in Books will be deleted due to 'delete on cascade'
			Query<Product> query2 = pm.newQuery(Product.class);
			System.out.println(" * '" + query2.deletePersistentAll() + "' products deleted from the DB.");

			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
}