package design_patterns.facade;

import java.io.InputStreamReader;
import java.util.Arrays;

public class ShoppingClient {


    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.executeOrder("",
                "",200,
                "", 1);
    }
}
