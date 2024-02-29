package com.example;

public class Score {
    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correct) {
        this.correct = correct;
    }

    public Letter letter(int position) {
        return result;
    }

    public void assess(int position, String attempt) {
        if (correct.charAt(position) == attempt.charAt(position)){
            result = Letter.CORRECT;
        }
    }
}
