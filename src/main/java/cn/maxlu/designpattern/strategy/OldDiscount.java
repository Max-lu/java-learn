package cn.maxlu.designpattern.strategy;

public class OldDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double price) {
        System.out.println("old discount...");
        return price * 0.5;
    }
}
