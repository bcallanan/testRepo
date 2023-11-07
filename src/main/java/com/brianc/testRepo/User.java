/**
 * 
 */
package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author home
 *
 */
public class User implements IUser {

	public User() {}
	
	public User(int id, String name, int balance) {
		this.id = id;
		this.balance = (double) balance;
		this.orders = new ArrayList<>();
		this.name=name;
	}

	private Integer id;
	private String name;
	private Double balance;
	private List< OracleProductNode> orders;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + ", orders=" + orders + "]";
	}

	@Override
	public String getName() {return name;}
	@Override
	public void setName(String name) { this.name = name; }

	@Override
	public double getBalance() { return balance; }
	@Override
	public void setBalance(double balance) { this.balance = balance; }

	@Override
	public int getId() { return id;	}
	@Override
	public void setId(int id) {	this.id=id;	}

	@Override
	public List< OracleProductNode > getOrders() {	return orders;	}
	@Override
	public void setOrders(List< OracleProductNode > orders) { this.orders = orders; }
}
