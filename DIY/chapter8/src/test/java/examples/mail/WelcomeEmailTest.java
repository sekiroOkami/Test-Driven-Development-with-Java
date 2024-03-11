package examples.mail;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WelcomeEmailTest {
   @Mock
    private MailServer mailServer;

   @Test
    public void sendsWelcomeEmail() {
       //SUT
       var notifications = new UserNotifications(mailServer);

       notifications.welcomeNewUser("test@Example.com");

       // check that the sendEmail() method was called correctly by our SUT, the correct parameter values
       verify(mailServer).sendEmail("test@example.com", "Welcome!", "Welcome to your account");

   }

   @Test
    public void rejectsInvalidEmailRecipient() {
       // configure out mock object
       doThrow(new IllegalArgumentException())
               .when(mailServer).sendEmail(any(),any(),any());

       // SUT
       var notifications
               = new UserNotifications(mailServer);

       // this performs the Act and Assert steps together.
       assertThatExceptionOfType(IllegalArgumentException.class)
               .isThrownBy(() -> notifications.welcomeNewUser("not-an-email-address"));
   }

}
