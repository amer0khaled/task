public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        ShippingService shippingService = new ShippingService();

        Product cheese = new ShippableProduct("Cheese", 100, 5, 0.2);
        Product biscuits = new ShippableProduct("Biscuits", 150, 3, 0.7);
        Product scratchCard = new Product("ScratchCard", 50, 10);

        productService.addProduct(cheese);
        productService.addProduct(biscuits);
        productService.addProduct(scratchCard);

        Customer customer = new Customer("Alice", 1000, productService);

        customer.getCart().addProduct(cheese, 2);
        customer.getCart().addProduct(biscuits, 1);
        customer.getCart().addProduct(scratchCard, 1);

        customer.getCart().checkout(customer, shippingService);
    }

}

