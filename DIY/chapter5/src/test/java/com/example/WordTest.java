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

        var result = score.letter(0);
        assertScoreForLetter(score, 0, Letter.INCORRECT);
    }

    @Test
    void oneCorrectLetter() {
        var word = new Word("A");

        Score score = word.guess("A");

        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }

    @Test
    void secondLetterWrongPosition() {
        var word = new Word("AR");
        var score = word.guess("ZA");
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
    }

    @Test
    void allScoreCombinations() {
        var word = new Word("ARI");
        var score = word.guess("ZAI");
        assertScoreForGuess(score, Letter.INCORRECT,Letter.PART_CORRECT,Letter.CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores) {
        for (int position = 0;
             position < expectedScores.length;
             position++) {
            Letter expected = expectedScores[position];
            assertThat(score.letter(position)).isEqualTo(expected);
        }
    }


}