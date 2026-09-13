package design_patterns.singleton_pattern;

public class SingletonEagerInit {

    private static final SingletonEagerInit instance= new SingletonEagerInit();

    private SingletonEagerInit(){
        System.out.println("The object is eagerly created");
    }

    public static SingletonEagerInit getInstance(){
        return instance;
    }
}
