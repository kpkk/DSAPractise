package design_patterns.factory_with_ocp;

public class CreateDebitCard extends CreateCard{
    @Override
    Card createCard() {
        return new DebitCard();
    }
}
