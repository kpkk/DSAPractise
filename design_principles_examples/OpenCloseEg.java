package solid_design_principles;

class PaymentSer{
    public void pay(String paymentType, double amount){
        // UPI, Credit card, Debit card-> GpAY,Bitcoin
        // switch
        if(paymentType.equals("UPI"))
            System.out.println("pay with UPI");
        else if(paymentType.equals("creditcard"))
            System.out.println("pay with credit card");
        else if(paymentType.equals("debit card"))
            System.out.println("pay with debit card");
    }
}
interface PaymentType{
    void pay(double amount);
}

class UpiPayment implements PaymentType{

    @Override
    public void pay(double amount) {
        System.out.println("paying with UPI");
    }
}

class DebitCardPayment implements PaymentType{

    @Override
    public void pay(double amount) {
        System.out.println("paying with debit card");
    }
}

class BitCoinPayment implements PaymentType{

    @Override
    public void pay(double amount) {
        System.out.println("paying with bit coin");
    }
}
class PaymentService{

    PaymentType paymentType;
    public void payment(PaymentType type, double amount){
        paymentType.pay(amount);
    }
}
public class OpenCloseEg {
    public static void main(String[] args) {
        PaymentSer payService = new PaymentSer();
        payService.pay("credit card", 200.0);

        PaymentType bitCoinPayment = new BitCoinPayment();
        PaymentType debitCardPayment = new DebitCardPayment();
        PaymentService paymentService = new PaymentService();
        paymentService.payment(bitCoinPayment, 20.0);
    }

}
