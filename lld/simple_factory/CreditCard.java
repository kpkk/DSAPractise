package design_patterns.factory;

public class CreditCard implements Card{

    @Override
    public void pay(double amount) {
        System.out.println("paying the amount "+amount+" through credit card");
    }
}
