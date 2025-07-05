import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    // Adds a product to the cart with a specific quantity.
    // Throws an exception if the requested quantity exceeds available stock.

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    // Returns the list of all items in the cart.
    public List<CartItem> getItems() {
        return items;
    }

    // Checks whether the cart is empty.
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
