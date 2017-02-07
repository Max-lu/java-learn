package designpattern.strategy;

public class NewDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        System.out.println("new discount...");
        return price * 0.7;
    }
}
