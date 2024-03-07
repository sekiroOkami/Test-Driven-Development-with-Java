package com.example;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private int position;

    private final List<Letter> results = new ArrayList<>();


    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter(int position) {
        return results.get(position);
    }

    public void assess(String attempt) {
        for (char current: attempt.toCharArray()) {
            scoreFor(attempt, current);
            position++;
        }

    }

    private void scoreFor(String attempt, char current) {
        if (isCorrectLetter(attempt)){
            results.add(Letter.CORRECT);
        } else
        if(occursInWord(current)) {
            results.add(Letter.PART_CORRECT);
        } else
        results.add(Letter.INCORRECT);
    }

    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    private boolean isCorrectLetter(String attempt) {
        return correct.charAt(position) == attempt.charAt(position);
    }
}
