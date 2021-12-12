package ua.rm.agilekatas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TokenTest {

    @Test
    @DisplayName("Given the token is on square 1 " +
            "When the token is moved 3 spaces " +
            "Then the token is on square 4")
    public void play_return_forth_square() throws WinningException {
        Token token = new Token(new Board());
        token.setCurrentSquare(new Square(1));
        assertEquals(4, token.move(3).getIndex());
    }

    @Test
    @DisplayName("Given the token is on square 1 " +
            "When the token is moved 3 spaces " +
            "And then it is moved 4 spaces " +
            "Then the token is on square 8")
    public void play_return_eighth_square() throws WinningException {
        Token token = new Token(new Board());
        token.setCurrentSquare(new Square(1));
        token.move(3);
        assertEquals(8, token.move(4).getIndex());
    }

    @Test
    @DisplayName("Given the token is on square 97 " +
            "When the token is moved 3 spaces " +
            "Then the token is on square 100 " +
            "And the player has won the game")
    public void play_return_player_won_game_and_on_100_square(){
        Token token = new Token(new Board());
        token.setCurrentSquare(new Square(97));

        Exception exception = assertThrows(WinningException.class, () -> {
            token.move(3);
        });

        assertTrue(exception.getMessage().contains("WINNING"));
        assertEquals(100, token.getCurrentSquare().getIndex());
    }

    @Test
    @DisplayName("Given the token is on square 97 " +
            "When the token is moved 4 spaces " +
            "Then the token is on square 97 " +
            "And the player has not won the game")
    public void play_return_player_does_nothing() throws WinningException {
        Token token = new Token(new Board());
        token.setCurrentSquare(new Square(97));

        assertEquals(97, token.move(4).getIndex());
    }

}
