package SalesTax.SalesTax;

import java.util.logging.Level;
import java.util.logging.Logger;

import SalesTax.SalesTax.TaxConstants;


  //Logger class for tax computation

public class TaxLogger {
	
	private static Logger logger;
	
	static{
		
		try {
			logger = Logger.getLogger("TaxLogger");
			logger.addHandler(TaxConstants.fileHandler);
			logger.setLevel(Level.ALL);
		} catch (SecurityException e) {
			logger.entering("SalesTax.SalesTax.TaxLogger", "main method - TaxException", e.getMessage());
		}
		
	}
	
	
	 // Get the logger reference
	 
	public static Logger getLogger(){
		return logger;
	}
}

