package ua.rm.agilekatas;


public class Die {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;

    public int roll(){
        return (int)Math.floor(Math.random()*(MAX_VALUE-MIN_VALUE+1)+MIN_VALUE);
    }

}
