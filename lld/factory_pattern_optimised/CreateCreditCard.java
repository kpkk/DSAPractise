package design_patterns.factory_with_ocp;

public class CreateCreditCard extends CreateCard{
    @Override
    Card createCard() {
        return new CreditCard();
    }
}
