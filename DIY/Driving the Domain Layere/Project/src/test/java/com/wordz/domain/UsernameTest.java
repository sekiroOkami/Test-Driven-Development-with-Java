package com.wordz.domain;

import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

import static org.assertj.core.api.Assertions.*;
public class UsernameTest {

    @Test
    public void convertsToLowerCase() {
        //arrange
        var username = new UserName("SirijaKington123456");
        //act
        String actual = username.asLowerCase();
        //assert
        assertThat(actual).isEqualTo("sirijakington123456");
    }



}
