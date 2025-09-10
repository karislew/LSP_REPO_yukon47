/**
 * Name: Karis Lewis
 * 
 * AI Usage Requirement: 
 * 	I used AI (ChatGPT) in this assignment when I was confused on which direction to take in terms of transforming the data.
 * For example, after changing the variables with if statements I was unsure how to append the data back to the transform.csv. 
 * I knew variables needed to be used, but I tried using just variables I received the error: "The method append(CharSequence, int, int) in the type OutputStreamWriter is not applicable for the arguments (String, String, Double, String, String)"
 * After trying to format the append, I used ChatGPT to help me come up with a solution. My prompt was (I want to use java eclipse FileWriter writer & append to a csv but how do I use variables from my while loop)?
 * It taught me to format a string, and pass that to the writer, which I then modified to fit this situation.
 * Another issue I ran into was the Category not being read correctly, therefore the price was not being changed. I looked up ways to compare strings and used contains & equals, then found that the if statement would only work with contains.
 * After identifying the issue I asked ChatGPT what the issue would be, and the output was that my string has extra characters before or after the string I was expecting. With that I found the trim method and applied that to my code.
 * 
 * 
 * Documentation of External Sources: 
 * External Source Usage: 
 * Link: https://www.youtube.com/watch?v=Ag-JPiwp1Oo&t=410s
 * Usage: Used approach to learn how to read and write CSV files with java; adapted to transform read csv file and write to a new csv file.
 * 
 * 
 * Assumptions: 
 * Assuming that the correct information has been entered into the products csv file (ie. price is a number, categories are spelled correctly) 
 * 
 * Design Rationale: 
 * Created variables equal to either null or 0 at the start so that I could have the try statements
 * Knew I had to use readline and take string (which can function as array) and set up variables for each header in order to access the data to perform transformations
 * Used if statements to define the criteria 
 * added a few catch statements for errors 
 * 
 * Tested: 
 * I tested the solution by running it multiple times, that included deleting the products csv and making sure i received an error message.
 * deleting the transform csv and making sure the correct output showed 
 * Deleting the rows from the products csv, to ensure the transform csv only read the header
 * 
 * 
 */
package org.howard.edu.lsp.assignment2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class ETLPipeline {
	public static void main(String[] args) throws IOException  {
		String csvFileName = System.getProperty("user.dir")+ "/data/products.csv";
		String csvOutFileName= System.getProperty("user.dir") + "/data/transformed.csv";
		//instantiating variables
		FileWriter writer = null;
		FileReader reader= null;
		BufferedReader bfrreader = null;
		Integer readCount = 0;
		Integer transformCount = 0;
		Integer skipped = 0;
		
		try {
		
			writer= new FileWriter(csvOutFileName);
			reader = new FileReader(csvFileName);
			bfrreader = new BufferedReader(reader);
			
			String line;
			String header = bfrreader.readLine();
			
			//only if products does not have header details (blank page)
			if(header!=null) {
				writer.append("ProductID,Name,Price,Category,PriceRange \n");
			}
			 
			while((line = bfrreader.readLine())!=null) {
				//getting information
				String[] data = line.split(",");
				String ProductID = data[0];
				String Name = data[1];
				Double Price = Double.parseDouble(data[2]);
				Double Discount = null;
				String Category = data[3].trim();
				String PriceRange = null;
				readCount = readCount + 1;
			
				//Transform 1 
				Name = Name.toUpperCase();
				
				//Transform 2
				if(Category.equalsIgnoreCase("Electronics")) {
					Discount = Price * 0.10;
					Price = Price - Discount;
					Price = Math.round(Price*100.0)/100.00;
					
					//Transform 3 
					if(Price > 500.00) {
						Category = "Premium Electronics";
					}
				}
			
				//Transform 4 
				if (Price>= 00.00 && Price<=10.00) {
					PriceRange = "Low";
				}
				else if(Price>=10.01 && Price<=100.00) {
					PriceRange = "Medium";
				
				}
				else if(Price>=100.01 && Price<=500.00) {
					PriceRange = "High";
				}
				else if(Price>=500.01) {
					PriceRange = "Premium";
				}
				
				//String csvLine = ProductID + "," + Name + "," + Price + "," + Category + "," + PriceRange + "\n";
				String csvLine = ProductID + "," + Name + "," + String.format("%.2f", Price) + "," + Category + "," + PriceRange + "\n";
				writer.append(csvLine);
				transformCount++;
				
			}
			//if i transformed less than i read, then something was skipped 
			skipped = readCount - transformCount;
			System.out.println("Rows Read: "+ readCount + ", Rows Transformed: " + transformCount + ", Rows Skipped: "+ skipped + ", CSV file created at: " + csvOutFileName);
		
		}catch(FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			return;
		}
		catch(Exception e) {
			System.out.println("An error has occurred: " + e.getMessage());
			return;
			
		}finally {
			try 
			{
				if (bfrreader!=null){bfrreader.close();}
				if(writer!=null) {writer.close();}
			}catch(Exception e) 
			{
				System.out.println("File not closed: " + e.getMessage() );
				return;
			}
			
		}
		
	}
	
}
