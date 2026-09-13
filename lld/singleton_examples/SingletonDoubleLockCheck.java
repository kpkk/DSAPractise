package design_patterns.singleton_pattern;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonDoubleLockCheck {

    private static volatile SingletonDoubleLockCheck instance;

    private SingletonDoubleLockCheck(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingletonDoubleLockCheck getInstance(){
        if(instance==null){
            synchronized (SingletonDoubleLockCheck.class){
                if (instance==null)
                    instance=new SingletonDoubleLockCheck();
            }
        }
        return instance;
    }
}
