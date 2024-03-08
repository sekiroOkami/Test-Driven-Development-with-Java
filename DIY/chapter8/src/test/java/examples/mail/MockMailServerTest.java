package examples.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

// record interactions with object that are difficult to control.
// we don't want to be sending actual email to anybody.
// we also would not want to write a test that waited around monitoring the mailbox of a test user.
// The SUT only has responsibility of making the call to sendEmail()
class MockMailServerTest {
    @Test
    public void sendsWelcomeEmail() {
        // set up mock
        var mailServer = new MockMailServer();
        // wiring up mock to SUT
        var notifications = new UserNotifications(mailServer);

        // cause the SUT to execute the welcomeNewUser()
        // we expect this method to call the sendEmail() on mailServer obj
        notifications.welcomeNewUser();
        assertThat(mailServer.wasCalled).isTrue();

        assertThat(mailServer.actualRecipient).isEqualTo("test@example.com");
        assertThat(mailServer.actualSubject).isEqualTo("Welcome");
        assertThat(mailServer.actualText).isEqualTo("Welcome to your account");
    }

}