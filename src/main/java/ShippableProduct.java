public class ShippableProduct extends Product implements Shippable{

    private double weight;

    public ShippableProduct(String name, double price, int amount, double weight) {
        super(name, price, amount);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
