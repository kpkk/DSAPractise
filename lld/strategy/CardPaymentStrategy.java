package design_patterns.strategy;

public class CardPaymentStrategy implements PaymentStrategy{


    @Override
    public void pay(double amount) {
        System.out.println("Paying the amount "+amount+" through the card");
    }
}
