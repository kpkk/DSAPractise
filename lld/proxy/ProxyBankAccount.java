package design_patterns.proxy;

public class ProxyBankAccount implements BankAccount{

    private RealBankAccount realBankAccount;
    private boolean isAuthenticated;

    public ProxyBankAccount(boolean isAuthenticated){
        this.isAuthenticated=isAuthenticated;
        realBankAccount=new RealBankAccount();
    }

    @Override
    public void withdraw(double amount) {
        if(!isAuthenticated)
            throw new RuntimeException("user is not authenticated");
        realBankAccount.withdraw(amount);

    }
}
