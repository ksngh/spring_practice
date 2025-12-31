public class UserService {

    private final NotificationSender notificationSender;

    public UserService() {
        this.notificationSender = new NotificationSender();
    }

    public void register(String username) {
        System.out.println("register user: " + username);
        notificationSender.send("welcome " + username);
    }
}