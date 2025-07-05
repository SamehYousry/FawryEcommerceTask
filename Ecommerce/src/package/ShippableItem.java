public class ShippableItem {

    // The product that needs to be shipped (implements Shippable)
    private Shippable product;
    // The number of units of the product to be shipped
    private int quantity;

    // Constructor to initialize a ShippableItem with product and quantity.
    public ShippableItem(Shippable product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Returns the shippable product.
    public Shippable getProduct() {
        return product;
    }

    // Returns the quantity of the product to be shipped.
    public int getQuantity() {
        return quantity;
    }
}
