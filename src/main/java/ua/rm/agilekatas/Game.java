package ua.rm.agilekatas;

public class Game {

    public static final int WINNING_SQUARE_INDEX = 100;
    public static final int WINNING_CODE = 777;

    private Board board;
    private Token token;
    private Die die;

    private boolean isWinning;

    public Game(){
        this.board = new Board();
        this.token = new Token(board);
        this.die = new Die();
        this.isWinning = false;
    }

    public void setDie(Die die) {
        this.die = die;
    }

    public Token start() {
        return token;
    }

    public void setWinning(){
        this.isWinning = true;
    }

    public int play() throws WinningException{
        if(isWinning){
            throw new WinningException();
        }

        int rollNumber = die.roll();

        try {
            return token.move(rollNumber).getIndex();
        } catch (WinningException e) {
            setWinning();
            throw new WinningException();
        }
    }

}
