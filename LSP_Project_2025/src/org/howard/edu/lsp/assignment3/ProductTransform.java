package org.howard.edu.lsp.assignment3;

/**
 * Handles transformations for Product objects.
 * <p>
 * Transformations include:
 * <ul>
 *   <li>Uppercasing product names</li>
 *   <li>Applying a discount for Electronics products</li>
 *   <li>Setting the price range based on the final price</li>
 * </ul>
 */
public class ProductTransform {
	/**
     * Applies the various transformations (as listed above) 
     *
     * @param product = the product to be transformed
     */

    public void transform(Product product) {
        uppercaseName(product);
        applyElectronicsDiscount(product);
        assignPriceRange(product);
    }
    /**
     * Converts the product's name to uppercase
     *
     * @param p = the product whose name will be updated
     */

    private void uppercaseName(Product p) {
        p.setName(p.getName().toUpperCase());
    }
    /**
     * Applies a 10% discount if the product belongs to the Electronics category.
     * If the discounted price is above 500, the category is set to
     * "Premium Electronics".
     *
     * @param p = the product to apply the discount to
     */

    private void applyElectronicsDiscount(Product p) {
        if (p.getCategory().equalsIgnoreCase("Electronics")) {
            double discounted = p.getPrice() * 0.90; // 10% discount
            discounted = Math.round(discounted * 100.0) / 100.0;
            p.setPrice(discounted);

            if (discounted > 500.0) {
                p.setCategory("Premium Electronics");
            }
        }
    }
    /**
     * Assigns a price range label ("Low", "Medium", "High", "Premium")
     * based on the product's price.
     *
     * @param p = the product to update with a price range
     */

    private void assignPriceRange(Product p) {
        double price = p.getPrice();
        if (price <= 10.00) p.setPriceRange("Low");
        else if (price <= 100.00) p.setPriceRange("Medium");
        else if (price <= 500.00) p.setPriceRange("High");
        else p.setPriceRange("Premium");
    }
}
