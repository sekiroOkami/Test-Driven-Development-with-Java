package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //mark this test as using Mockito, when run this JUnit5 test , the annotation ensure that the mockito code is run
public class UserGreetingTest {
    //DIP
    private static final UserId USER_ID = new UserId("1234");

    //UserGreeting depend on a UserProfiles interface, inject dependency in SUT
    @Mock
    private UserProfiles profiles;

    @Test
    void formatsGreetingWithName() {
        //configure @Mock to return the correct stub data for test with any() argument matcher
        when(profiles.fetchNicknameFor(any())).thenReturn("Alan");

        var greeting = new UserGreeting(profiles);

        String actual = greeting.formatGreeting(USER_ID);
        assertThat(actual).isEqualTo("Hello and Welcome, Alan");
    }
}
