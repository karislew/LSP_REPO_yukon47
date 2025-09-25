package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Main class that coordinates reading, transforming, and writing product data.
 */
public class ETLPipeline {

	/**
	 * Main class that runs the ETL method for product data.
	 * <p>
	 * This class reads product data from a CSV file, applies transformations using
	 * ProductTransform, and writes the transformed data to an output CSV file.
	 */
    public static void main(String[] args) {
    	/**
         * Start of the program
         * <p>
         * The method performs the following steps:
         * <ol>
         *   <li>Reads products from the input CSV file using CSVReader.</li>
         *   <li>Applies transformations to each product using ProductTransform.</li>
         *   <li>Writes the transformed products to an output CSV file using CSVWriter.</li>
         *   <li>Prints counts of rows read, transformed, and skipped, and the output file path.</li>
         * </ol>
         *
         * @param args  = command-line arguments
         */
    	
        String inputPath = System.getProperty("user.dir") + "/data/products.csv";
        String outputPath = System.getProperty("user.dir") + "/data/transformed_products.csv";

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ProductTransform transformer = new ProductTransform();

        try {
            // Read products from CSV
            List<Product> products = reader.readProducts(inputPath);
            int readCount = products.size();

            // Transform each product using ProductTransform
            for (Product product : products) {
                transformer.transform(product);
            }

            // Write transformed products to output CSV
            writer.writeProducts(outputPath, products);

            int transformCount = products.size();
            
            int skipped = readCount - transformCount;

            System.out.println("Rows Read: " + readCount 
                               + ", Rows Transformed: " + transformCount 
                               + ", Rows Skipped: " + skipped 
                               + ", CSV file created at: " + outputPath);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
