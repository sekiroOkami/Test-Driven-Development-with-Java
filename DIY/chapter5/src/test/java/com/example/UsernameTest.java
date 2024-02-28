package com.example;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class UsernameTest {
    @Test
    void convertsToLowerCase() {
        // arrange
        var username = new Username("Godfrey, First Elden Lord");

        // act
        String actual = username.asLowerCase();

        assertThat(actual).isEqualTo("godfrey, first elden lord");

    }


}
