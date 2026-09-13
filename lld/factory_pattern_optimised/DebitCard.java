package design_patterns.factory_with_ocp;

public class DebitCard implements Card {
    @Override
    public void pay(double amount) {
        System.out.println("paying the amount "+amount+" through debit card");
    }
}
