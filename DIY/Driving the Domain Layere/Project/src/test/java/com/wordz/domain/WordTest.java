package com.wordz.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
public class WordTest {
    @Test
    public void OneIncorrectLetter() {
        var word = new Word("A");

        var score = word.guess("Z");
        var result = score.letter(0);
        Assertions.assertThat(result).isEqualTo(Letter.INCORRECT);
    }

    @Test
    public void OneCorrectLetter() {
        var word = new Word("A");

        var score = word.guess("A");

        assertScoreForLetter(score, 0, Letter.CORRECT);
    }

    @Test
    public void secondLetterWringPosition() {
        var word = new Word("AR");

        var score = word.guess("ZA");

        assertScoreForLetter(score, 1, Letter.PART_CORRECT);

    }

    @Test
    void allScoreCombinations() {
        var word = new Word("ARI");
        var score = word.guess("ZAI");
        assertScoreForGuess(score, Letter.INCORRECT, Letter.PART_CORRECT, Letter.CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores) {
//        for (int position=0; position < expectedScores.length; position++) {
//            Letter expected = expectedScores[position];
//            assertThat(score.letter(position)).isEqualTo(expected);
//        }
        IntStream.range(0, expectedScores.length)
                .forEach(position -> {
                    Letter expected = expectedScores[position];
                    assertThat(score.letter(position)).isEqualTo(expected);
                });
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }





}
