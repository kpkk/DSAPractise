package design_patterns.proxy;

public class RealBankAccount implements BankAccount{

    @Override
    public void withdraw(double amount) {
        System.out.println("withdrawing an amount"+amount+" from the account");
    }
}
