package design_patterns.singleton_pattern;

public class SingletonBillPlughImpl {

   // private static SingletonBillPlughImpl instance;

    private SingletonBillPlughImpl(){

    }
    private static final class BillPlughSingleton{
        private static final SingletonBillPlughImpl instance = new SingletonBillPlughImpl();
    }

    public static SingletonBillPlughImpl getInstance(){
        return BillPlughSingleton.instance;
    }
}
