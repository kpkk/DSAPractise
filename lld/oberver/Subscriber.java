package design_patterns.observer;

public class Subscriber implements Observer{

    private String name;
    public Subscriber(String name){
        this.name=name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name+" is received a notification on a new video "+videoTitle+" from channel");
    }
}
