public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance, ProductService productService) {
        this.name = name;
        this.balance = balance;
        cart = new Cart(productService);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makePayment(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Not Enough balance.");
        }
        balance -= amount;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
