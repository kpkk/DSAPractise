package design_patterns.singleton_pattern;

public class SingletonThreadSafe {
    private static SingletonThreadSafe instance;

    private SingletonThreadSafe(){
    }
 // t1, t2 -> t2 (in progress) t1- will wait
    public static synchronized SingletonThreadSafe getInstance(){
        if(instance==null){
            instance=new SingletonThreadSafe();
        }
        return instance;
    }
}
