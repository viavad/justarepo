package ua.rm.agilekatas;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int SQUARES_NUMBER = 100;
    private final int STARTING_SQUARE_INDEX = 0;

    private List<Square> squares;

    public Board() {
        squares = new ArrayList<>(SQUARES_NUMBER);

        for (int i = 0; i < SQUARES_NUMBER; i++) {
            squares.add(new Square(i + 1));
        }
    }

    public Square getStartingSquare(){
        return squares.get(STARTING_SQUARE_INDEX);
    }

    public Square getSquare(int index){
        return squares.get(index - 1);
    }

}
