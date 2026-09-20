package design_patterns.adapter;


// module our current system is trying to integrate
public class RazorPayAPI {

    public void makePayment(double amount){
        System.out.println("paying the amount "+amount+" through Razor pay");
    }
}
