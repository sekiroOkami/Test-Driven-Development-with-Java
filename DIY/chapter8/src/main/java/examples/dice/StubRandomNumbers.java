package examples.dice;

public class StubRandomNumbers implements RandomNumbers {


    @Override
    public int nextInt(int upperBoundExclusive) {
        return 4;
    }
}
