package es.deusto.ingenieria.sd.datanucleus.jdo;

import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Book;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Copy;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Product;
import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Shelf;
import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.IProductDAO;
import es.deusto.ingenieria.sd.org.datanucleus.jdo.dao.ProductDAO;

public class LocalTest_Copies {

	public static void main(String[] args) {
		IProductDAO productDAO = new ProductDAO();

		createProductTest(productDAO);
		createBookTest(productDAO);
		
		getAllProductsTest(productDAO);

		updateProductTest(productDAO);
		updateBookTest(productDAO);

		checkCopiesTest(productDAO);
		
		updateCopyShelf(productDAO);
		
		deleteAllObjects(productDAO);
	}

	protected static void createProductTest(IProductDAO productDAO) {
		try {
			System.out.println(" - Creating 2 new products ... ");
			
			Product product = new Product("Sony Xperia", "A standard mobile from Sony", 300d);
			productDAO.storeProduct(product);			
			
			product = new Product("iPad", "A standard iPad from Apple", 500d);
			productDAO.storeProduct(product);
		} catch (Exception ex) {
			System.out.println(" $ Error creating a new product: " + ex.getMessage());
		}
	}

	protected static void createBookTest(IProductDAO productDAO) {
		try {
			System.out.println(" - Creating 2 new books ... ");
			
			Book book = new Book("The Hobbit", "Basic Edition", 60d, "J.R.R. Tolkien", "0-321-12722-0", "Oxford Press");
			Book book1 = new Book("Dracula", "Paperback Edition", 5d, "Bram Stoker", "0-342-232345-0", "Dover Publishing");
			Shelf shelf = new Shelf("First Shelf");
			book.addCopy("2", "Perfect, almost new", shelf);
			book1.addCopy("4", "Scratches on front cover", shelf);
			book1.addCopy("6", "Reasonable", shelf);
			
			productDAO.storeProduct(book);
			productDAO.storeProduct(book1);
		} catch (Exception ex) {
			System.out.println(" $ Creating a new book: " + ex.getMessage());
		}
	}

	protected static void getAllProductsTest(IProductDAO productDAO) {
		try {
			List<Product> products = productDAO.getProducts();
			System.out.println("     - Mixture of Products and Books ...");
			
			for (Product productAux : products) {
				System.out.println("        # " + productAux);
			}
		} catch (Exception ex) {
			System.out.println(" $ Error getting Mixture of Products and Books: " + ex.getMessage());
		}
	}

	protected static void updateProductTest(IProductDAO productDAO) {
		try {
			Product product = productDAO.getProduct("Sony Xperia");
			System.out.println(" - Detaching and updating a product: " + product);
			product.setDescription("Reduced Priced Mobile");
			productDAO.updateProduct(product);
			System.out.println("     - Attaching a product after changing description: " + product);
		} catch (Exception ex) {
			System.out.println(" $ Error detaching-attaching: " + ex.getMessage());
		}
	}

	protected static void updateBookTest(IProductDAO productDAO) {
		try {
			List<Book> books = productDAO.getBooks();

			if (!books.isEmpty()) {
				Book book = books.get(0);
				System.out.println(" - Updating book copies (new copy in new shelf): " + book);
				Shelf shelf = new Shelf("Second Shelf");
				book.addCopy("5", "Good state", shelf);
				productDAO.updateProduct(book);
				System.out.println("   * New copy in new shelf added: " + book);
			}
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving the updated book: " + ex.getMessage());
		}
	}

	protected static void checkCopiesTest(IProductDAO productDAO) {
		try {
			Book updatedBook = (Book) productDAO.getProduct("Dracula");
			System.out.println("   * Retrieving updated book: " + updatedBook);
			System.out.println("   * Number of copies of this book: " + updatedBook.getCopies().size());

			for (Copy copy : updatedBook.getCopies()) {
				System.out.println("     # " + copy);
			}
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving updated book: " + ex.getMessage());
		}
	}

	protected static void updateCopyShelf(IProductDAO productDAO) {
		try {
			Book updatedBook = (Book) productDAO.getProduct("The Hobbit");
			System.out.println("   * Retrieving updated book: " + updatedBook);
			Shelf existingShelf = (Shelf) productDAO.getShelf("First Shelf");
			System.out.println(" - Adding a new copy to an existing shelf: " + existingShelf.getIdentifier());
			updatedBook.addCopy("7", "Bad state", existingShelf);
			productDAO.updateProduct(updatedBook);
			System.out.println("   * New copy added to an existing shelf : " + updatedBook);
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving updated a book: " + ex.getMessage());
		}
	}

	protected static void deleteAllObjects(IProductDAO productDAO) {
		try {
			productDAO.deleteAllProducts();
			System.out.println("   ==== DB emptied ====    ");
		} catch (Exception ex) {
			System.out.println(" $ Error emptying DB: " + ex.getMessage());
		}
	}
}