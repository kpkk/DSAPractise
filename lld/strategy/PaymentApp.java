package design_patterns.strategy;

public class PaymentApp {

    private PaymentStrategy paymentStrategy;
    public PaymentApp(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public void payBill(double amount){
        paymentStrategy.pay(amount);
    }

    public static void main(String[] args) {
        PaymentStrategy cardPaymentStrategy = new UPIPaymentStrategy();
        PaymentApp paymentApp = new PaymentApp(cardPaymentStrategy);
        paymentApp.payBill(200);
    }
}
