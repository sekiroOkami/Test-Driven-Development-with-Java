package com.wordz.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DiceRollTest {

    @Test
    void producesMessage() {
        //arrange
        var stub = new StubRandomNumbers();
        var roll = new DiceRoll(stub);

        //act
        var actual = roll.asText();

        //assert
        assertThat(actual).isEqualTo("You rolled a 4");

    }

}