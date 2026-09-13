package design_patterns.factory_with_ocp;

public abstract class CreateCard {

    abstract Card createCard();

    public void processPayment(double amount){
        Card card = createCard();
        card.pay(amount);
    }
}
