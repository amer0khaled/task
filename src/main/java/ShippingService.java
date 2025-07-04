import java.util.Map;

public class ShippingService {

    public void shipProducts(Map<Shippable, Integer> products) {
        System.out.println("Shipping the Products:");
        double totalWeight = 0;

        for (var p : products.entrySet()) {
            Shippable item = p.getKey();
            Integer quantity = p.getValue();

            System.out.println(quantity + "x " + item.getName());
            totalWeight += item.getWeight() * quantity;
        }
        System.out.println("Total package weight " + totalWeight + "kg\n");
    }

}
