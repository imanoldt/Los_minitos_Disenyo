/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. 
 **********************************************************************/
package es.deusto.ingenieria.sd.datanucleus.jdo.data.domain;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class Copy {

	private String copyNum;
	private String state;
	private Book book;
	
	// when the copy is retrieved from the db, the shelf will be retrieved as well
	@Persistent(defaultFetchGroup = "true")
	private Shelf shelf;

	public String getCopyNum() {
		return copyNum;
	}

	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toString() {
		return "Copy: " + copyNum + " [" + state + "]" + "in shelf: " + shelf.getIdentifier();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
		shelf.addCopy(this);
	}

	public void discardCopy() {
		shelf.removeCopy(this);
		shelf = null;
	}
}