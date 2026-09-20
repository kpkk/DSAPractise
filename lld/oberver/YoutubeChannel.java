package design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{
    // in memory database
    List<Observer> observers= new ArrayList<>();
    private String videoTitle;
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyUsers() {
        for (Observer observer: observers){
            observer.update(videoTitle);
        }
    }
    @Override
    public void uploadAVideo(String videoTitle){
        this.videoTitle=videoTitle;
        notifyUsers();
    }
}
