package com.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class WordTest {
    @Test
    void oneIncorrectLetter() { // name of the test gives an overview
        var word = new Word("A");

        // think of a way to pass a guess into the Word class and return a score
        var score = word.guess("Z");

        /**
         *  Think about what to return from the production code.
         *
         *  We want an object of some sort which must represent the score from that guess.
         *  Because our current user story is about the scores for a five-letter word and the details of each letter,
         *  return one of exactly right, right letter, wrong place, letter not present
         */

        int result = score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);
    }


}