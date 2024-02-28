package com.example ;

public class Username {
    final String username;

    public Username(String username) {
        this.username = username;
    }

    public String asLowerCase() {
        return
        this.username.toLowerCase();
    }
}
