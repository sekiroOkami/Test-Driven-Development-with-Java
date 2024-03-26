package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private  final String correct;
    private List<Letter> result = new ArrayList<>();
    private int position;


    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter(int position) {
        return result.get(position);
    }


    public void assess(String attempt) {
        for (char current: attempt.toCharArray()) {
            scoreFor(current);
            position++;
        }
    }

    private void scoreFor(char current) {
        if (isCorrectLetter(current)) {
            result.add(Letter.CORRECT) ;
        } else if (occursInWord(current)) {
            result.add(Letter.PART_CORRECT) ;
        } else {
            result.add(Letter.INCORRECT);
        }
    }

    private boolean occursInWord(char current) {
        return correct.contains(String.valueOf(current));
    }

    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position)
                == currentLetter;
    }
}
