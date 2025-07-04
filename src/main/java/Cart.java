import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> cartItems;
    private ProductService productService;
    private static final double SHIPPING_RATE = 10;

    public Cart(ProductService productService) {
        cartItems = new HashMap<>();
        this.productService = productService;
    }

    public void addProduct(Product product, int amount) {
        if (!productService.isAvailable(product, amount)) {
            throw new IllegalArgumentException("Only " + product.getAmount()
                    + " units of " + product.getName()
                    + " are available.");
        }

        int currentAmount = cartItems.getOrDefault(product, 0);
        cartItems.put(product, currentAmount + amount);
        productService.decreaseProductAmount(product, amount);

    }

    public void removeProduct(Product product, int amount) {
        Integer currentAmount = cartItems.get(product);

        if (currentAmount == null) {
            throw new IllegalArgumentException(product.getName() + " is not in the cart");
        }

        if (currentAmount < amount) {
            throw new IllegalArgumentException("You only have " + currentAmount + " units of " + product.getName() + " in the cart.");
        }

        if (currentAmount == amount) {
            cartItems.remove(product);
        } else {
            cartItems.put(product, currentAmount - amount);
        }

        productService.increaseProductAmount(product, amount);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (var item : cartItems.entrySet()) {
            totalPrice += item.getKey().getPrice() * item.getValue();
        }
        return totalPrice;
    }

    private double calculateSubtotal() {
        double subtotal = 0;
        for (var item : cartItems.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();

            subtotal += product.getPrice() * quantity;

        }

        return subtotal;
    }

    private double calculateShippingFee() {
        double shippingFee = 0;

        for (var item : cartItems.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();

            if (product instanceof Shippable shippable) {
                shippingFee += shippable.getWeight() * quantity * SHIPPING_RATE;
            }
        }

        return shippingFee;
    }


    public void checkout() {
        if (cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        double subtotal = 0;
        double shippingFee = 0;



    }

    public void listCart() {
        System.out.println("Cart Contains:");
        for (var item : cartItems.entrySet()) {
            System.out.println(item.getKey() + " >> " + item.getValue());
        }
    }

}
