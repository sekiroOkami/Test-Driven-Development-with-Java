package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class WelcomeEmailTest {

    //expect SUT that can send an email
    @Mock
    private MailServer mailServer;

    @Test
    public void sendsWelcomeEmail() {
        var notifications =
                new UserNotifications(mailServer);

        notifications.welcomeNewUser("test@example.com");

        // verify that the sendEmail() was called correctly by our SUT(MailServer)
//        verify(mailServer).sendEmail("test@example.cocm", "Welcome!","Welcome to your account");


    }

    @Test
    public void rejectsInvalidEmailRecipient() {
//        doThrow(new IllegalArgumentException()).when(mailServer).sendEmail(any(),any(),any());
        var notifications = new UserNotifications(mailServer);
        //performs the act and assert step together
        assertThatExceptionOfType(NotificationFailureException.class).isThrownBy(
                () -> notifications.welcomeNewUser("not an email address")
        );
    }


}
