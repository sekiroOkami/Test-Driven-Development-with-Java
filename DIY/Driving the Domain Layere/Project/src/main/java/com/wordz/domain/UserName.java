package com.wordz.domain;

import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserName {
    @Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters")
    private final String name;


    public UserName(String message) {
        this.name = message;
    }

    public String asLowerCase() {
        String result = this.name.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> String.valueOf(ch).toLowerCase())
                .collect(Collectors.joining());

        return result;
    }
}
