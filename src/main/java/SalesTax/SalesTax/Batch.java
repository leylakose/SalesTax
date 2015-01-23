package SalesTax.SalesTax;

import SalesTax.SalesTax.TaxConstants;
import SalesTax.SalesTax.TaxUtility;

public class Batch {
	
	private double[] itemTotal = new double[TaxConstants.MAX_ARRAY_SIZE]; 
	private double[] salesTaxTotal = new double[TaxConstants.MAX_ARRAY_SIZE];
	
	private Product[] products;
	private int size;
	
	
	// Calculates the sum of all products
	public double getGrandItemTotal() {
		return (TaxUtility.calculateTotal(itemTotal));
	}
	
	
	// Calculates the sum of all sales tax  to each of the products 
	public double getGrandTaxTotal() {
		return (TaxUtility.calculateTotal(salesTaxTotal));
	}	
	
	 // Calculates the sum of all products with sales tax	 
	public double getGrandTotal() {
		return (getGrandItemTotal() + getGrandTaxTotal());
	}

	
	 //Get specific product 
	public Product getProducts(int index) {
		return products[index];
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getItemTotal(int index) {
		return itemTotal[index];
	}

	public void setItemTotal(double itemTotal,int index) {
		this.itemTotal[index] = itemTotal;
	}

	public double getSalesTaxTotal(int index) {
		return salesTaxTotal[index];
	}

	public void setSalesTaxTotal(double salesTaxTotal,int index) {
		this.salesTaxTotal[index] = salesTaxTotal;
	}

	public double getTotal(int index) {
		return getItemTotal(index) + getSalesTaxTotal(index);
	}

	
}
