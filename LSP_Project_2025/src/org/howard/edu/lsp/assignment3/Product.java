package org.howard.edu.lsp.assignment3;

/**
 * Represents a product with details such as ID, name, price, category, and price range.
 * <p>
 * This class holds the data for a product but does not perform transformations.
 * Transformations should be applied using a separate class such as ProductTransform.
 */
public class Product {
    private String productID;
    private String name;
    private double price;
    private String category;
    private String priceRange;
    
    /**
     * Constructs a Product object with the specified details.
     *
     * @param productID =  the unique identifier for the product
     * @param name = the name of the product
     * @param price = the price of the product
     * @param category =  the category of the product (ex: "Electronics")
     */

    public Product(String productID, String name, double price, String category) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category.trim();
    }

    // Getters

    /**
     * Returns the product ID.
     *
     * @return the unique identifier of the product
     */
    public String getProductID() { return productID; }
    /**
     * Returns the product name.
     *
     * @return the name of the product
     */
    public String getName() { return name; }
    
    /**
     * Returns the product price.
     *
     * @return the price of the product
     */
    public double getPrice() { return price; }
    
    /**
     * Returns the product category.
     *
     * @return the category of the product
     */
    public String getCategory() { return category; }
    
    /**
     * Returns the price range assigned to the product.
     *
     * @return the price range (e.g., "Low", "Medium", "High", "Premium")
     */
    public String getPriceRange() { return priceRange; }

    // Setters
    /**
     * Sets the product name.
     *
     * @param name = the new name for the product
     */
    public void setName(String name) { this.name = name; }
    /**
     * Sets the product price.
     *
     * @param price = the new price for the product
     */
    public void setPrice(double price) { this.price = price; }
    
    /**
     * Sets the product category.
     *
     * @param category = the new category for the product
     */
    public void setCategory(String category) { this.category = category.trim(); }
    
    /**
     * Sets the price range for the product.
     *
     * @param priceRange = the new price range (e.g., "Low", "Medium", "High", "Premium")
     */
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }

    // CSV output
    /**
     * Converts the product to a CSV-formatted string.
     *
     * @return a string representing the product in CSV format
     */
    public String toCSVRow() {
        return productID + "," + name + "," + String.format("%.2f", price) + "," + category + "," + priceRange;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return a string describing the product
     */
    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, price=%.2f, category=%s, range=%s]",
                productID, name, price, category, priceRange);
    }
}
