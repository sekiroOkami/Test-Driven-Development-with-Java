package com.wordz.domain.model;

public class StubRandomNumbers implements RandomNumbers{
    @Override
    public int nextInt(int upperBoundExclusive) {
        return 3;
    }
}
