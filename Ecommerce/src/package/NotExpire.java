public class NotExpire extends Product {
    private boolean shippable;
    private double weight;

    // Constructor to initialize a NotExpire product.
    public NotExpire(String name, double price, int quantity, boolean shippable, double weight) {
        super(name, price, quantity);
        this.shippable = shippable;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    // Checks if the product needs to be shipped.
    public boolean isShippable() {
        return shippable;
    }

    // Get the weight of the product in kilo
    public double getWeight() {
        return weight;
    }
}
