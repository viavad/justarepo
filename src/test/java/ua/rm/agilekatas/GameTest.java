package ua.rm.agilekatas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    @DisplayName("Given the game is started " +
            "When the token is placed on the board " +
            "Then the token is on square 1")
    public void start_return_first_square(){
        Game game = new Game();
        assertEquals(1, game.start().getCurrentSquare().getIndex());
    }

    @Test
    @DisplayName("Given the player rolls a 4 " +
            "When they move their token " +
            "Then the token should move 4 spaces")
    public void play_move_4_spaces_after_rolls_4() throws WinningException {
        final int rollResult = 4;

        Game game = new Game();
        int currentSquareIndex = game.start().getCurrentSquare().getIndex();

        Die dieMock = mock(Die.class);
        when(dieMock.roll()).thenReturn(rollResult);
        game.setDie(dieMock);

        assertEquals(currentSquareIndex + rollResult, game.play());
    }

}
