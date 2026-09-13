package design_patterns.factory_with_ocp;

import design_patterns.factory.CardFactory;

import java.util.function.Supplier;

public class PaymentApp {

    public static void main(String[] args) {
        // figure out the payment mode?
        CreateCard createCard = CardType.CREDIT.getCreateCardSupplier().get();
        createCard.processPayment(200);

        Simple credit = Simple.CREDIT;
        CreateCard orDefault = CardRegistry.map.getOrDefault(credit, null);
        orDefault.processPayment(200);

    }
}
