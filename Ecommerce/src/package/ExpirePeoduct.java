import java.time.LocalDate;

public class ExpirePeoduct extends Product {
    // Expiry date of the product
    private LocalDate expiryDate;
    // Weight of the product in kilograms
    private double weight;

    // Constructor to initialize a perishable product.
    public ExpirePeoduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    // Checks if the product is expired by comparing today's date with the expiry
    // date.
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    // Gets the weight of the product in kilograms .
    public double getWeight() {
        return weight;
    }
}
