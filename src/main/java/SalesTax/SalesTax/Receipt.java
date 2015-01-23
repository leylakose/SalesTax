package SalesTax.SalesTax;


import SalesTax.SalesTax.TaxUtility;

public class Receipt {


 // Generates the receipts
 
public static void generateReceipt(Product[] products,Batch salesBatch){
		
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\tQuantity\tItem\t\tPrice\t\tTotal\t\tTax\t\tTotal Price");
	
		System.out.println("---------------------------------------------------------------------------------------------------");
	for(int i =0;i<products.length;i++){
		System.out.println("\t"+products[i].getQuantity()+"\t\t"+products[i].getName()+"\t"+(products[i].getName().length() > 7 ? "" : "\t")+
				TaxUtility.round(products[i].getPrice())+"\t\t"+TaxUtility.round(products[i].getTotal())+"\t\t"+
				TaxUtility.round(products[i].getTaxAmount())+"\t\t"+ TaxUtility.round(products[i].getNetTotal()));
	}
	
	System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t      Sales Tax Total : " + TaxUtility.round(salesBatch.getGrandTaxTotal()));
		System.out.println("\t\t\t\t\t\t\t\t\t  Grand Total : " + TaxUtility.round(salesBatch.getGrandTotal()));
	
}
}
