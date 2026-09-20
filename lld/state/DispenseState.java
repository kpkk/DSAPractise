package design_patterns.state;

public class DispenseState implements State{

    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, while dispensing in process");
    }

    @Override
    public void pressButton() {
        System.out.println("Please wait, while dispensing in process");
    }

    @Override
    public void dispenseState() {
        System.out.println("item is being dispensed");
        vendingMachine.setCurrentState(vendingMachine.getNoCoin());

    }
}
