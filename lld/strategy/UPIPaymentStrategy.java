package design_patterns.strategy;

public class UPIPaymentStrategy implements PaymentStrategy{


    @Override
    public void pay(double amount) {
        System.out.println("Paying the amount "+amount+" through the UPI");
    }
}
