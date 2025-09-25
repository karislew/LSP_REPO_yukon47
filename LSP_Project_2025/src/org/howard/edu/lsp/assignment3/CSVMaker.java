/**
 * Karis Lewis
 */
package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class to create a sample CSV file of products.
 * <p>
 * This class generates a CSV file named "products.csv" with sample product data
 * including ProductID, Name, Price, and Category. It is intended for testing
 * the ETL pipeline - items sampled are from example in Assignment 2 document
 */

public class CSVMaker{
	/**
     * Main method to create the sample CSV file.
     * <p>
     * Writes a fixed set of products to the CSV file. The file is created in the
     * data directory of the current working directory.
     *
     * @param args =  command-line arguments 
     * @throws IOException if an I/O error occurs while writing the file
     */
	
	public static void main(String[] args) throws IOException{
		
		String csvFileName= System.getProperty("user.dir") + "/data/products.csv";
		FileWriter writer= null;
		
		try {
		writer = new FileWriter(csvFileName);
		//writes header
		writer.append("ProductID,Name,Price,Category \n"); 
		
		//adding sample data
		writer.append("1,Book,12.99,Education \n");
		writer.append("2,Laptop,999.99,Electronics \n");
		writer.append("3,Notebook,2.49,Stationery \n");
		writer.append("4,Headphones,199.99,Electronics \n");
		writer.append("5,Pencil,0.99,Stationery \n");
		writer.append("6,Smartphone,699.49,Electronics \n");
		
		writer.close();
		System.out.println("CSV file created at  " + csvFileName);
	
	}catch(Exception e) {
		System.out.println("An error has occurred: " + e.getMessage());
	}finally {
		try {
			if(writer!=null) {
				writer.close();
			}
		}catch(Exception e) {
			System.out.println("An error has occurred: " + e.getMessage());
		}
	}
	}
}
