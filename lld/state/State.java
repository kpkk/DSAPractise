package design_patterns.state;

public interface State {
    void insertCoin();
    void pressButton(); // has a coin
    void dispenseState();
}
