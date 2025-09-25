package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.List;

/**
 * Handles writing a list of Product objects to a CSV file.
 * <p>
 * Each Product is written as a single row, including the CSV header.
 * This class does not modify the products themselves; it only outputs them to a file.
 */
public class CSVWriter {

	/**
     * Writes the given products to a CSV file, including a header row.
     * <p>
     * Each product's data is written in CSV format: ProductID, Name, Price, Category, PriceRange
     *
     * @param outputPath the file path where the CSV will be written
     * @param products the list of Product objects to write
     * @throws IOException if an I/O error occurs while writing the file
     */
    public void writeProducts(String outputPath, List<Product> products) throws IOException {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.append("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                writer.append(product.toCSVRow()).append("\n");
            }
        }
    }
}
