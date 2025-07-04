import java.time.LocalDate;

public class ExpriableProduct extends Product implements Expirable{
    private LocalDate createdDate;
    private LocalDate expireDate;
    private int expirationDuration;

    public ExpriableProduct(String name, double price, int amount, int expirationDuration) {
        super(name, price, amount);
        this.expirationDuration = expirationDuration;
        createdDate = LocalDate.now();
        expireDate = createdDate.plusYears(expirationDuration);

    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public boolean isExpired() {
        return expireDate != null && expireDate.isBefore(LocalDate.now());
    }

}
