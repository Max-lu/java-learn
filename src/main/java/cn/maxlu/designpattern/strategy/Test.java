package cn.maxlu.designpattern.strategy;

public class Test {
    public static void main(String[] args) {
        DiscountContext context = new DiscountContext();
        double price = 20;
        System.out.println("price:" + context.getDiscount(price));

        //change strategy
        context.setStrategy(new NewDiscount());
        System.out.println("price:" + context.getDiscount(price));
    }
}
