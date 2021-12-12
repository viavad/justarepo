package ua.rm.agilekatas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GameRestController {

    private Game game;

    @PostMapping("/start-game")
    public Token startGame() {
        game = new Game();
        return game.start();
    }

    @GetMapping("/play")
    public int play(){
        if(game == null){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Start New game at first.");
        }

        try {
            return game.play();
        } catch (WinningException e) {
            return Game.WINNING_CODE;
        }
    }

}
