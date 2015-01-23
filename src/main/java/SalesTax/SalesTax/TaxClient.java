package SalesTax.SalesTax;


import SalesTax.SalesTax.Batch;
import SalesTax.SalesTax.Product;
import SalesTax.SalesTax.Receipt;
import SalesTax.SalesTax.TaxException;
import SalesTax.SalesTax.TaxLogger;
import SalesTax.SalesTax.TaxConstants;
import SalesTax.SalesTax.TaxUtility;

public class TaxClient {
	
	public static void main(String[] args) throws TaxException {
		
		TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxClient", "main method");
		
		String numberOfEntries="";
		String itemType = "";
		String value = "";
		
		Batch salesBatch = new Batch();
		
				Entry(numberOfEntries,itemType,value,salesBatch);
			
		}
		
				
	
	private static void Entry(String numberOfEntries,String itemType,String value,Batch salesBatch) throws TaxException
	{
		
		TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxClient", "Entry - input option");
		System.out.println("Items are: book, chocolate, pills, perfume");
		System.out.println("How many Items do you want to compute? Enter the number: ");
		
		try{
		numberOfEntries = TaxUtility.getValues();
		
		//set the batch size
	     salesBatch.setSize(Integer.valueOf(numberOfEntries));
		
		}
		catch(NumberFormatException e){
			
			System.out.println("The number is wrong");
				
		}
		
		
		
		//Stores the item in an array
		Product[] products = new Product[salesBatch.getSize()];
		
		salesBatch.setProducts(products);
		
		for(int i = 0;i<salesBatch.getSize();i++){
			
		//format of input Quantity Item Price
		System.out.println("Enter the particulars in comma separated format : Quantity,Item,Price");
		value = TaxUtility.getValues();
		
		products = TaxUtility.processInformation(value,products,i);
		
		System.out.println("Enter the ItemType : Imported or Not : Y/N");
		itemType = TaxUtility.getValues();
		
		//Set the item type
		products[i].setItemType(itemType.equalsIgnoreCase("Y") ? TaxConstants.IMPORTED_TYPE : TaxConstants.LOCAL_TYPE);
		
		TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxClient", "manualEntry - itemType",products[i].getItemType());
		
			//calculate sales tax for particular item
			products[i].setTaxAmount(products[i].computeTax());
							
			//grand item Total
			salesBatch.setItemTotal(products[i].getTotal(),i);
			salesBatch.setSalesTaxTotal(products[i].getTaxAmount(),i);
			
			System.out.println("Item Price:"+salesBatch.getItemTotal(i)+" || Sales Tax:"+salesBatch.getSalesTaxTotal(i)+" || (Item + Sales Tax):"+salesBatch.getTotal(i));
		
			
		}
		

		Receipt.generateReceipt(products,salesBatch);
	}

	
	 
}