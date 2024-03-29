package com.wordz.domain;

public class Game {
    private String word;
    private int attemptNumber;
    private Player player;

    public Game(String word, int attemptNumber, Player player) {
        this.word = word;
        this.attemptNumber = attemptNumber;
        this.player = player;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
