package design_patterns.adapter;

public class PaypalAdapter implements PaymentProcessor{

    private PaypalAPI paypalAPI;

    public PaypalAdapter(PaypalAPI paypalAPI){
        this.paypalAPI=paypalAPI;
    }

    @Override
    public void pay(double amount) {
     paypalAPI.sendAmount(amount);
    }
}
