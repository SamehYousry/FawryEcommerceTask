public class Customer {
    // Current balance available in the customer's account
    private double balance;

    // Constructor to initialize customer with a starting balance.
    public Customer(double balance) {
        this.balance = balance;
    }

    // Gets the current balance of the customer.
    public double getBalance() {
        return balance;
    }

    // Deducts an amount from the customer's balance after checkout.
    public void deduct(double amount) {
        balance -= amount;
    }

}
