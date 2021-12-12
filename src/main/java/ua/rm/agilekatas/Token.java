package ua.rm.agilekatas;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Token {

    @JsonIgnore
    private Board board;
    private Square currentSquare;

    public Token(Board board) {
        this.board = board;
        this.currentSquare = board.getStartingSquare();
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public Square move(int stepNumber) throws WinningException{
        int currentSquareIndex = currentSquare.getIndex();
        if(currentSquareIndex == Game.WINNING_SQUARE_INDEX){
            throw new WinningException("WINNING");
        }

        int targetSquareIndex = currentSquareIndex + stepNumber;
        if(targetSquareIndex <= Game.WINNING_SQUARE_INDEX){
            setCurrentSquare(board.getSquare(targetSquareIndex));

            if(targetSquareIndex == Game.WINNING_SQUARE_INDEX){
                throw new WinningException("WINNING");
            }
        }

        return currentSquare;
    }

}
