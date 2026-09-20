package design_patterns.adapter;

public class PaypalAPI {

    public void sendAmount(double amount){
        System.out.println("paying the amount "+amount+" through paypal api");
    }
}
