package examples.mail;


// It has a single responsibility to record the fact that the sendEmail() was called
// and capture the actual parameter values sent to that method.
public class MockMailServer implements MailServer {
    boolean wasCalled;
    String actualRecipient;
    String actualSubject;
    String actualText;

    @Override
    public void sendEmail(String recipient, String subject, String text) {
        wasCalled = true;
        actualRecipient = recipient;
        actualSubject = subject;
        actualText = text;
    }
}
