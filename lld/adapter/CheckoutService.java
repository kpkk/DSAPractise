package design_patterns.adapter;

public class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor){
        this.paymentProcessor=paymentProcessor;
    }

    public void pay(int amount){
        paymentProcessor.pay(amount);
    }

    public static void main(String[] args) {


        // pay through Razor
        RazorPayAPI razorPayAPI = new RazorPayAPI();
        RazorPayAdapter razorPayAdapter = new RazorPayAdapter(razorPayAPI);
        PaypalAdapter paypalAdapter = new PaypalAdapter(new PaypalAPI());
        CheckoutService checkoutService = new CheckoutService(paypalAdapter);
        checkoutService.pay(200);
    }

}
