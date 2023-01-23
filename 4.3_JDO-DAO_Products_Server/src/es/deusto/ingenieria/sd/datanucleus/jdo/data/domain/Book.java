/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. 
 **********************************************************************/
package es.deusto.ingenieria.sd.datanucleus.jdo.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Join;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Book extends Product {

	private String author;
	private String isbn;
	private String publisher;
	
	// 1 to N bidirectional association and delete on cascade (dependentElement) for copies
	// default-fetch-group so when book is retrieved from db, copies will be retrieved as well
	@Persistent(defaultFetchGroup = "true", mappedBy = "book", dependentElement = "true")
	@Join
	private List<Copy> copies;

	public Book(String name, String description, double price, String author, String isbn, String publisher) {
		super(name, description, price);
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.copies = new ArrayList<Copy>();
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void addCopy(String copyNum, String state, Shelf shelf) {
		Copy copy = new Copy();
		copy.setCopyNum(copyNum);
		copy.setState(state);
		copy.setBook(this);
		copy.setShelf(shelf);
		copies.add(copy);
	}

	public List<Copy> getCopies() {
		return copies;
	}

	public void removeCopies() {
		for (Copy c : copies) {
			c.discardCopy();
		}
	}

	public String toString() {
		return "Book: " + author + " - " + this.getName() + " [" + super.getDescription() + "]";
	}
}