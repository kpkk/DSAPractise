package design_patterns.singleton_pattern;

import java.util.Calendar;

public class SingletonTester extends Thread {

    @Override
    public void run() {
        SingletonBillPlughImpl instance = SingletonBillPlughImpl.getInstance();
        System.out.println(instance.hashCode());
    }

    public static void main(String[] args) {
//        SingletonLazyInit instance = SingletonLazyInit.getInstance();
//        SingletonLazyInit instance1 = SingletonLazyInit.getInstance();
//        SingletonLazyInit instance2 = SingletonLazyInit.getInstance();
//        System.out.println(instance.hashCode());
//        System.out.println(instance2.hashCode());
//        System.out.println(instance.hashCode()==instance2.hashCode());
//
//        // test the singleton eager initialisation
//        SingletonEagerInit instance3 = SingletonEagerInit.getInstance();
//        SingletonEagerInit instance4 = SingletonEagerInit.getInstance();
//        System.out.println(instance3.hashCode());
//        System.out.println(instance4.hashCode());
//        System.out.println(instance3.hashCode()==instance4.hashCode());

        Thread t1 = new SingletonTester();
        Thread t2 = new SingletonTester();

        t1.start();
        t2.start();
    }
}
