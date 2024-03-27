package com.wordz.domain.model;

import java.util.random.RandomGenerator;

public class DiceRoll {
    private final int NUMBER_OF_SIDES = 6;
    private final RandomNumbers rnd;

    public DiceRoll(RandomNumbers rnd) {
        this.rnd = rnd;
    }

    public String asText() {
        int rolled = rnd.nextInt(NUMBER_OF_SIDES) + 1;
        return String.format("You rolled a %d", rolled);
    }


}
