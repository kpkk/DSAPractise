package design_patterns.state;

public class NoCoinState implements State{

    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }
    @Override
    public void insertCoin() {
        System.out.println("Thanks for inserting the coin, choose from menu..");
        vendingMachine.setCurrentState(vendingMachine.getHasCoin());
    }

    @Override
    public void pressButton() {
        System.out.println("please insert a coin..");
    }

    @Override
    public void dispenseState() {
        System.out.println("please insert a coin..");
    }
}
