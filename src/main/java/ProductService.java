import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> products = new ArrayList<>();

    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Product " + name + " Not Found");
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean isAvailable(Product product, int amount) {
        return product.getAmount() >= amount;
    }

    public void increaseProductAmount(Product product, int amount) {
        product.setAmount(product.getAmount() + amount);
    }

    public void decreaseProductAmount(Product product, int amount) {
        if (!isAvailable(product, amount)) {
            throw new IllegalArgumentException("Not enough amount for " + product.getName());
        }

        product.setAmount(product.getAmount() - amount);
    }

    public List<Product> listProducts() {
        return products;
    }

}
