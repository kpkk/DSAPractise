package design_patterns.state;

public class VendingMachine {

    private State noCoin;
    private State hasCoin;
    private State dispense;
    private State currentState;

    public State getHasCoin() {
        return hasCoin;
    }

    public State getDispense() {
        return dispense;
    }

    public State getNoCoin() {
        return noCoin;
    }



    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public VendingMachine(){
        noCoin= new NoCoinState(this);
        hasCoin=new HasCoinState(this);
        dispense=new DispenseState(this);

        // default state
        currentState=noCoin;
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void pressButton(){
        currentState.pressButton();
    }

    public void dispenseItem(){
        currentState.dispenseState();
    }

}
