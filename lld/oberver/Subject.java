package design_patterns.observer;

public interface Subject {

    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notifyUsers();
    void uploadAVideo(String videoTitle);
}
