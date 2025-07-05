import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        // Create perishable products with expiry dates and weights
        // (name, price, quantity, expiry date, weight (kg))
        Product cheese = new ExpirePeoduct("Cheese", 100, 18, LocalDate.of(2025, 7, 5), 0.2);
        Product biscuits = new ExpirePeoduct("Biscuits", 100, 5, LocalDate.of(2025, 7, 10), 0.7);
        // Create a non-perishable product that requires shipping.
        Product tv = new NotExpire("TV", 5000, 2, true, 2);
        // Create a non-shippable non-perishable product (e.g., mobile scratch card)
        Product scratchCard = new NotExpire("Scratch Card", 50, 10, false, 0);
        // Create a customer with 1000 balance
        Customer customer = new Customer(1000);

        // Create a cart and add products to it
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        // Perform checkout process
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}
