package design_patterns.adapter;

public class RazorPayAdapter implements PaymentProcessor{

    private RazorPayAPI razorPayAPI;
    public RazorPayAdapter(RazorPayAPI razorPayAPI){
        this.razorPayAPI=razorPayAPI;
    }

    @Override
    public void pay(double amount) {
        razorPayAPI.makePayment(amount);
    }
}
