package SalesTax.SalesTax;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import SalesTax.SalesTax.TaxLogger;


 //Constans used for Tax computation
 
public final class TaxConstants {
	
	private static Properties properties;	
	public static FileHandler fileHandler;
	static{
		
		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(new File("src\\config.properties")));
		}catch (FileNotFoundException e) {
			
			TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxConstants", "static method- FileNotFoundException",e.getMessage());
			
		} catch (IOException e) {
			
			TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxConstants", "static method - IOException",e.getMessage());
			
		}
		
		try {
			fileHandler = new FileHandler(properties.getProperty("LOG_FILE_LOCATION"),Boolean.valueOf(properties.getProperty("APPEND_LOG")));
		} catch (FileNotFoundException e) {
			
			TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxConstants", "static method- FileNotFoundException",e.getMessage());
			
		} catch (IOException e) {
			
			TaxLogger.getLogger().entering("SalesTax.SalesTax.TaxConstants", "static method - IOException",e.getMessage());
			
		}
		
	}
	
	public static final int MAX_ARRAY_SIZE = 10;
	public static final int MAX_FILE_SIZE = 4;
		
	public  static final String IMPORTED_TYPE = "IMPORTED";
	public  static final String LOCAL_TYPE = "LOCAL";
			
	public  static final String COMMA = ",";
	public  static final String SPACE = " ";
	
	public static final File TAX_WAIVER_FILE = new File(properties.getProperty("TAX_WAIVER_FILE_LOCATION"));
	public static final int SALES_TAX_PERCENTAGE = Integer.valueOf(properties.getProperty("SALES_TAX_PERCENTAGE"));
	public static final int IMPORT_DUTY_PERCENTAGE = Integer.valueOf(properties.getProperty("IMPORT_DUTY_PERCENTAGE"));
	public  static final double ROUNDUP_FACTOR = Double.valueOf(properties.getProperty("ROUNDUP_FACTOR"));
	
	
	
}

