package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

/**
 * Handles reading product data from a CSV file and converting it into Product objects.
 * <p>
 * Assumes the first row of the CSV file is a header. Each following row should
 * contain these columns in order: ProductID, Name, Price, Category.
 */
public class CSVReader {

    /**
     * Reads products from the given input file path.
     *
     * @param inputPath Path to the products CSV file
     * @return List of Product objects
     * @throws IOException If reading fails
     */
    public List<Product> readProducts(String inputPath) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String header = reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String id = data[0];
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String category = data[3];
                    Product product = new Product(id, name, price, category);
                    products.add(product);
                }
            }
        }
        return products;
    }
}
