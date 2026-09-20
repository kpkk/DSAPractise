package design_patterns.proxy;

public class BankApp {

    public static void main(String[] args) {
        ProxyBankAccount proxyBankAccount = new ProxyBankAccount(true);
        proxyBankAccount.withdraw(200);
    }
}
