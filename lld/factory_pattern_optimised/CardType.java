package design_patterns.factory_with_ocp;

import java.util.function.Supplier;

public enum CardType {


    CREDIT(CreateCreditCard::new),
    DEBIT(CreateDebitCard::new);

    private Supplier<CreateCard> createCardSupplier;

    CardType(Supplier<CreateCard> createCardSupplier) {
        this.createCardSupplier=createCardSupplier;
    }

    public Supplier<CreateCard> getCreateCardSupplier() {
        return createCardSupplier;
    }
}
