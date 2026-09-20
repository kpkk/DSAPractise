package design_patterns.state;

public class HasCoinState implements State{

    private VendingMachine vendingMachine;
    public HasCoinState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }
    @Override
    public void insertCoin() {
        System.out.println("Coin has already been inserted");
    }

    @Override
    public void pressButton() {
        System.out.println("Thanks for choosing, please wait for dispensing to begin");
        vendingMachine.setCurrentState(vendingMachine.getDispense());
    }

    @Override
    public void dispenseState() {
        System.out.println("Coin has already been inserted, please press button");
    }
}
