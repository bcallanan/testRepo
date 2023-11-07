/**
 * 
 */
package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author home
 *
 */
public class Company implements ICompany {

	public Company() {
		products= new ArrayList<>();
		users = new ArrayList<>();
	}
	
	public Company( List< OracleProductNode > products, List<IUser> users ) {
		this.products = products;
		this.users = users;
	}

	private List< OracleProductNode > products;
	private List<IUser> users;

	@Override
	public void addProduct(IProduct product, int quantity) {
		if ( products == null ) {
			products= new ArrayList<>();
		}
		products.add( new OracleProductNode( product, quantity));
	}

	@Override
	public void addUser(IUser user) {
		if ( users == null ) {
			users = new ArrayList<>();
		}
		users.add( user );
	}

	@Override
	public List< OracleProductNode > getProducts() { return products; }
	@Override
	public List<IUser> getUsers() {	return users; }
	@Override
	public void setProducts(List< OracleProductNode > products) { this.products = products; }
	@Override
	public void setUsers(List<IUser> users) { this.users = users; }

	@Override
	public void makeOrder(List< OracleProductNode > products, IUser user) {
		
		if ( products != null && ! products.isEmpty() && user != null ) {
			List< OracleProductNode > userOrders = user.getOrders();
			
			Double shippingCost = 0d;
			for ( OracleProductNode nodeProduct: products ) {
				Optional< OracleProductNode > stockItem =
						this.products.stream()
							.filter( item -> item.product.getId() == nodeProduct.product.getId())
							.findFirst();

				if ( stockItem.isPresent() ) {
					int quantity = stockItem.get().quantity;
					if ( nodeProduct.quantity > quantity && quantity > 0 ) {
						// no stock or the quantity requested was equal or < zero
					}
					else {
						
						if ( shippingCost < stockItem.get().product.getShippingCost()) {
							shippingCost = stockItem.get().product.getShippingCost();
						}
						
						userOrders.add( nodeProduct );
					}
				}
			}
			
			// check balance
			double userBalance = user.getBalance();
			
		   	Optional<Double> sumOfProductPrice = products
	    			.stream()
	    			.map( (node) -> node.product.getPrice() * node.quantity )
	    			.reduce( (acc, x) -> acc + x );
		   	
		   	Double orderTotal = sumOfProductPrice.get() + shippingCost ;
		   	
		   	if ( userBalance < orderTotal )  {
		   		
		   		// no order - insufficent funds
		   		userOrders.clear();
		   	}
		   	else {
		   		// Sufficient funds
		   		OracleProductNode node = null;
				for ( OracleProductNode orderedProduct: userOrders ) {
					Optional< OracleProductNode > stockItem =
							this.products.stream()
								.filter( item -> item.product.getId() == orderedProduct.product.getId())
								.findFirst();

					if ( stockItem.isPresent() ) {
						node = stockItem.get();
						node.quantity = node.quantity - orderedProduct.quantity;
					}
					else {
						// the order was trumped by something else and there's no product
						// Probably throw a custom exception here "NoMoreProductException()" 
					}
				}
				
				user.setBalance( user.getBalance() - orderTotal);
		   	}
		}
	}
}
