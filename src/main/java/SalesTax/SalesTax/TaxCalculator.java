package SalesTax.SalesTax;

import java.util.ArrayList;

import SalesTax.SalesTax.Product;
import SalesTax.SalesTax.TaxException;


 //Calculates different kinds of tax for the product

public class TaxCalculator{
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public TaxCalculator(Product product){
		
		this.product = product;
	}
	
	
	 // Calculates the Basic Tax for the product
	public double calculateBasicTax() throws TaxException{
		
		double basicTaxValue = 0.0;
		boolean flagValue = false;
		
		// load the tax Waiver file for inputs - can be used to update from outside
		ArrayList<String> basicTaxWaiverItems = TaxUtility.loadFromFile(TaxConstants.TAX_WAIVER_FILE,false);
		
			for(int i = 0;i<basicTaxWaiverItems.size(); i++){
							
							if(product.getName().equalsIgnoreCase(basicTaxWaiverItems.get(i))){
								
								//10 % of the value
								flagValue = true;
								break;
								
							}
						
					}
				
			basicTaxValue = (flagValue != true) ? (product.getPrice() * TaxConstants.SALES_TAX_PERCENTAGE)/100 : 0.0;
		
			System.out.print("Basic Tax :"+ basicTaxValue);
			return basicTaxValue;
	}
	
	
	  //Calculates the Import duty tax for the product
	 
	public double calculateImportDutyTax(){
		
		double importDutyTaxValue = 0.0;
				
		importDutyTaxValue = (product.getItemType().equalsIgnoreCase(TaxConstants.IMPORTED_TYPE)) ? (product.getPrice() * TaxConstants.IMPORT_DUTY_PERCENTAGE)/100 : 0.0;
		
		System.out.print("  || Import Duty :"+ importDutyTaxValue);
		System.out.println("\n");
		return importDutyTaxValue;	
	}
}
