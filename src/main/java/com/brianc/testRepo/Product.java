/**
 * 
 */
package com.brianc.testRepo;

/**
 * @author home
 *
 */
public class Product implements IProduct {
	
	public Product() {}
	
	public Product(int id, String name, int price, int shippingCost) {
		this.shippingCost = (double) shippingCost;
		this.id = id;
		this.price = (double) price;
		this.name=name;
	}

	private int id;
	private String name;
	private Double price;
	private Double shippingCost;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", shippngCost=" + shippingCost + "]";
	}

	@Override
	public String getName() { return name; }
	@Override
	public void setName(String name) { this.name = name; }
	
	@Override
	public int getId() { return id; }
	@Override
	public void setId(int id) {	this.id=id;	}

	@Override
	public double getPrice() { return price; }
	@Override
	public void setPrice(double price) { this.price = price; }

	@Override
	public double getShippingCost() { return shippingCost;	}
	@Override
	public void setShippingCost(double shippingCost) { this.shippingCost = shippingCost; }
}
