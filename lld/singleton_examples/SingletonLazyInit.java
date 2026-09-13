package design_patterns.singleton_pattern;


// lazy initialisation
public class SingletonLazyInit {
    // encapsulation
    private static SingletonLazyInit instance;

    private SingletonLazyInit(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingletonLazyInit getInstance(){
        if(instance==null)
            instance=new SingletonLazyInit();
        return instance;
    }

}








// eager, lazy
// strong composition. // eager injection
class User{ // user has address
    private Address b;  // composition
        User (Address b){
            this.b=b;
        }

    public static void main(String[] args) {
            // eager injection
        // I'm injecting the address into the user object during its creation time
        User a = new User(new Address());
    }
}


// lazy injection
class Address{ // has a relationship
    private TownInfo c;
    Address(){ // Association

    }
    public void setTownInfo(TownInfo c){
        this.c=c;
    }

    public static void main(String[] args) {
        Address b = new Address();
        TownInfo townInfo = new TownInfo();
        // lazy injection
        // I'm setting the town info, once the object is created and later in time
        b.setTownInfo(townInfo);
    }
}

class TownInfo{

}

