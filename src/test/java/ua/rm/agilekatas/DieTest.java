package ua.rm.agilekatas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;

public class DieTest {

    @Test
    @DisplayName("Given the game is started " +
            "When the player rolls a die " +
            "Then the result should be between 1-6 inclusive")
    public void roll_return_between_1_and_6_inclusive(){
        Die die = new Die();
        for (int i = 0; i < 10000; i++) {
            int rNum = die.roll();
            if(rNum < 1 || rNum > 6){
                fail();
            }
        }
    }

}
