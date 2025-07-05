import java.util.List;

public class ShippingService {

    // Prints shipping information for each item including name, quantity, and total
    // weight.
    // Also calculates and prints the total shipment weight.
    public void ship(List<ShippableItem> items) {
        System.out.println(" Shipping the following items ");
        double totalWeight = 0;// total weight of the entire shipment (in kg)

        for (ShippableItem item : items) {
            Shippable product = item.getProduct();
            int quantity = item.getQuantity();
            double weight = product.getWeight() * quantity;
            // Print: "[quantity]x [product name] [total weight in grams]g"
            System.out.printf("%dx %s\t\t%.0fg\n", quantity, product.getName(), weight * 1000);

            totalWeight += weight;
        }
        // Print final total shipment weight in kilograms
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}
