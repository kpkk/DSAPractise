package design_patterns.factory;

public class PaymentApp {

    public static void main(String[] args) {
        // pay using credit / debit card as desired

        // I need to confirm card type that we are going to use
        CardFactory cardFactory = new CardFactory();
        // call the pay method on the card
        Card credit = cardFactory.createCard("debit");
        credit.pay(200);
    }
}
