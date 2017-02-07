package designpattern.strategy;

public class DiscountContext {
    private DiscountStrategy strategy;

    public double getDiscount(double price) {
        if (strategy == null) {
            return new OldDiscount().getDiscount(price);
        }
        return strategy.getDiscount(price);
    }

    public DiscountStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
}
