package SalesTax.SalesTax;

import SalesTax.SalesTax.TaxException;
import SalesTax.SalesTax.TaxCalculator;

public class Product {

	private int quantity;
	private String name;
	
	private double price;
	private double taxAmount;
		
	private String itemType;
	
	private TaxCalculator taxCalculator;

	public double getNetTotal() {
		return (getTotal() + getTaxAmount());
	}

	
	 // Get the Quantity
	 
	public int getQuantity() {
		return quantity;
	}
	//Set the quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	
	// Product Constructor
	 
	public Product(int quantity, String name, double price){
		
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		
		taxCalculator = new TaxCalculator(this);
		
	}
	
	
	// Returns the total items
	
	public double getTotal() {
		
		return (this.getQuantity() * this.getPrice());
	}

	public double getTaxAmount() {
		return taxAmount;
	}
	
	public void setTaxAmount(double taxAmount) {
		this.taxAmount =  taxAmount;
	}

	
	
	// Computes the tax for the product
	 
	public double computeTax() throws TaxException {
		return (taxCalculator.calculateBasicTax() + taxCalculator.calculateImportDutyTax());
	}
	
}

