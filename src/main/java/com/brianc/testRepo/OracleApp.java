package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class OracleProductNode{
    IProduct product;
    int quantity;
    OracleProductNode( IProduct product, int quantity ) {
        this.product = product;
        this.quantity = quantity;
    }
}

interface ICompany {
    List<IUser> getUsers();
    void setUsers(List<IUser> users);
    List< OracleProductNode > getProducts();
    void setProducts(List< OracleProductNode > products);
    void addProduct(IProduct product, int quantity);
    void addUser(IUser user);
    void makeOrder(List< OracleProductNode> products, IUser user);
}

interface IProduct {
    int getId();
    void setId( int id);
    String getName();
    void setName( String name);
    double getPrice();
    void setPrice( double price);
    double getShippingCost();
    void setShippingCost( double shippingCost);
}

interface IUser {
    int getId();
    void setId(int id);
    String getName();
    void setName(String name);
    double getBalance();
    void setBalance(double balance);
    List< OracleProductNode > getOrders();
    void setOrders(List< OracleProductNode > orders);
}

public class OracleApp {
	

	public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8");
        Company company = new Company();

        String[] a = "1,product1,20,2,20".split(",");
    	company.addProduct( new Product(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3])), Integer.parseInt(a[4]));
		
    	a = "2,product2,30,1,10".split(",");
    	company.addProduct( new Product(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3])), Integer.parseInt(a[4]));
		
    	a = "3,product3,25,3,60".split(",");
    	company.addProduct( new Product(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3])), Integer.parseInt(a[4]));

		a = "1,user1,1200".split(",");
        company.addUser(new User( Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2])));
		
        a = "2,user2,1000".split(",");
        company.addUser(new User( Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2])));

        //========== Orders
        final String[] AA = "1,1|5,2|2".split(",");
        IUser u = company.getUsers().stream().filter(x -> x.getId() == Integer.parseInt(AA[0])).findFirst().orElse(null);
        if(u == null) {
        	throw new Exception("User not found");
        }
        List< OracleProductNode > orderProducts = new ArrayList<>();
        for (int j = 1; j < AA.length; j++) {
        	String[] b = AA[j].split("\\|");
        	OracleProductNode curr = company.getProducts()
        			.stream()
        			.filter( x -> x.product.getId() == Integer.parseInt(b[0]))
        			.findFirst().orElse(null);
        	
        	if(curr != null) {
        		OracleProductNode c = new OracleProductNode(curr.product, Integer.parseInt(b[1]));
        		orderProducts.add(c);
        	}   
        }
        company.makeOrder(orderProducts, u);

        //===============
        final String[] AAA = "2,2|1,3|3,1|2".split(",");
        u = company.getUsers().stream().filter(x -> x.getId() == Integer.parseInt(AAA[0])).findFirst().orElse(null);
        if(u == null) {
        	throw new Exception("User not found");
        }
        
        orderProducts = new ArrayList<>();
        for (int j = 1; j < AAA.length; j++) {
        	String[] b = AAA[j].split("\\|");
        	OracleProductNode curr = company.getProducts()
        			.stream()
        			.filter(x -> x.product.getId() == Integer.parseInt(b[0]))
        			.findFirst().orElse(null);
        	
        	if ( curr != null ) {
        		OracleProductNode c = new OracleProductNode(curr.product, Integer.parseInt(b[1]));
        		orderProducts.add(c);
        	}   
        }
        company.makeOrder(orderProducts, u);

        company.getProducts().stream()
            .sorted( Comparator.comparing(x -> x.product.getId()))
            .map(x -> x.product.getName() + ":" + x.quantity)
            .collect(Collectors.toList())
            .forEach(System.out::println);

	}//end of main
 }//end of Solution