package design_patterns.facade;

public class PaymentService {

    public void pay(double amount, String productId){
        System.out.println(" paid for the product "+productId+" an amount "+amount);
    }
}
