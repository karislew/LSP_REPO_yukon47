/**
 * Karis Lewis
 */
package org.howard.edu.lsp.assignment2;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
	public static void main(String[] args) throws IOException{
		String csvFileName= System.getProperty("user.dir") + "/data/products.csv";
		FileWriter writer= null;
		
		try {
		writer = new FileWriter(csvFileName);
		
		writer.append("ProductID,Name,Price,Category \n"); 
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
