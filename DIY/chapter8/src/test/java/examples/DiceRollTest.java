package examples;

import examples.dice.DiceRoll;
import examples.dice.StubRandomNumbers;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class DiceRollTest {

    @Test
    void producesMessage() {

        // replacing the real RandomNumbers with a stub that delivers a known value, we have made out test assertion easy to write
        // sub eliminates the problem of unrepeatable values from the random generator

        var stub = new StubRandomNumbers();
        var roll = new DiceRoll(stub);

        var actual = roll.asText();

        assertThat(actual).isEqualTo("You rolled a 5");
    }
}