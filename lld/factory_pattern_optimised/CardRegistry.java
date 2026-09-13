package design_patterns.factory_with_ocp;

import java.util.Map;

public class CardRegistry {

    public static final Map<Simple, CreateCard> map= Map.of(
            Simple.CREDIT, new CreateCreditCard(),
            Simple.DEBIT, new CreateDebitCard()
    );

}
