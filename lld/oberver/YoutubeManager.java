package design_patterns.observer;

public class YoutubeManager {

    public static void main(String[] args) {
        Subscriber john = new Subscriber("John");
        Subscriber doe = new Subscriber("doe");
        Subscriber Alex = new Subscriber("Alex");

        YoutubeChannel channel = new YoutubeChannel();
        channel.subscribe(john);
        channel.subscribe(doe);
        channel.subscribe(Alex);

        channel.uploadAVideo("Design patterns");
        channel.unSubscribe(john);
        channel.uploadAVideo("DSA");
    }

}
