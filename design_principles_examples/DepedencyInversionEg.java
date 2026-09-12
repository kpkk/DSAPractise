package solid_design_principles;

interface Notify{
    void send(String message);
}
class EmailNotificationClass implements Notify{
    public void send(String message){
        System.out.println("email has been sent"+message);
    }
}
class SMSNotification implements  Notify{
    public void send(String message){
        System.out.println("SMS has been sent"+message);
    }
}
class NotificationService{
    Notify notify;
    NotificationService(Notify notify){
        this.notify=notify;
    }
}
public class DepedencyInversionEg {
    public static void main(String[] args) {
        Notify email = new EmailNotificationClass();
        NotificationService notificationService = new NotificationService(email);
    }

}
