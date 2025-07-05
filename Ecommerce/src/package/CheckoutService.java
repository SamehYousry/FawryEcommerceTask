import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        List<ShippableItem> toShip = new ArrayList<>();
        double subtotal = 0; 
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            // Validate: Product is not expired
            if (p.isExpired()) {
                throw new IllegalStateException(p.getName() + " is expired.");
            }
            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalStateException(p.getName() + " out of stock.");
            }
            p.reduceQuantity(item.getQuantity());
            // Add to subtotal
            subtotal += item.getTotalPrice();
            // Directly add shippable product to the shipping list with its quantity
            if (p instanceof Shippable) {
                toShip.add(new ShippableItem((Shippable) p, item.getQuantity()));

            }
            // Special handling for NotExpire products that are shippable
            else if (p instanceof NotExpire) {
                NotExpire np = (NotExpire) p;

                if (np.isShippable()) {
                    // Wrap non-shippable product as Shippable and add with quantity to shipping
                    // list
                    toShip.add(new ShippableItem(new Shippable() {
                        public String getName() {
                            return np.getName();
                        }

                        public double getWeight() {
                            return np.getWeight();
                        }
                    }, item.getQuantity()));

                }
            }
        }
        // Determine shipping cost
        double shipping = toShip.isEmpty() ? 0 : 30;
        // Final total = subtotal + shipping
        double total = subtotal + shipping;
        // Validate: Customer has enough balance
        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance.");
        }
        // Deduct total amount from customer's balance
        customer.deduct(total);
        // Ship the items if any exist
        if (!toShip.isEmpty()) {
            new ShippingService().ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t\t%.0f\n", item.getQuantity(), item.getProduct().getName(),
                    item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t\t%.0f\n", subtotal);
        System.out.printf("Shipping\t\t%.0f\n", shipping);
        System.out.printf("Amount\t\t\t%.0f\n", total);
        System.out.printf("Remaining Balance\t%.0f\n", customer.getBalance());
    }
}
