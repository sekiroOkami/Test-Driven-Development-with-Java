package examples.mail;

// the SUT
public class UserNotifications {
    private MailServer mailServer;

    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }

    public void welcomeNewUser() {
        mailServer.sendEmail("test@example.com", "Welcome", "Welcome to your account");
    }
}
