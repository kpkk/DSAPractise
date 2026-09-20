package design_patterns.state;

public class OrderApp {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        // negative use case, shouldn't be allowed
        vendingMachine.dispenseItem();

        // positive scenario, where I want to go step by step
        vendingMachine.insertCoin();
        vendingMachine.pressButton();
        vendingMachine.dispenseItem();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();
        vendingMachine.dispenseItem();
    }
}
