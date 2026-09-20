package design_patterns.adapter;

public class CardPayment implements PaymentProcessor{

    @Override
    public void pay(double amount) {
        System.out.println("paying the amount "+amount+" through the card");
    }
}
