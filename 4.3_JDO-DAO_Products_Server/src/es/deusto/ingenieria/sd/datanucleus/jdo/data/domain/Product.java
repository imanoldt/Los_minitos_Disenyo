/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. 
 **********************************************************************/
package es.deusto.ingenieria.sd.datanucleus.jdo.data.domain;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Product {

	private String name;
	private String description;
	private double price;

	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Product: " + name + " [" + description + "]";
	}
}