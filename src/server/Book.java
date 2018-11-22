package server;

import download.Product;

public class Book extends Product {
	
	private String isbn;

	public Book(String description, String isbn, double price) {
		super(description, price);
		this.isbn = isbn;
		// TODO Auto-generated constructor stub
	}
	
	public String getDescription() {
		return super.getDescription()+""+isbn + "" + this.price;
	}
	
	

}
