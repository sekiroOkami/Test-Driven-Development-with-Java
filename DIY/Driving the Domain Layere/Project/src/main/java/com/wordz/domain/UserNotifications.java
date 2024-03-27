package com.wordz.domain;

public class UserNotifications {
    private final MailServer mailServer;

    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }


    public void welcomeNewUser(String mail) {
        throw new NotificationFailureException();
    }
}
