package TicTac;

import Exceptions.InvalidMoveArrayException;

public class RandomStrategy implements Strategy{
    public static final String NAME = "Random Strategy";

    @Override
    public int[] determineMove(Board board,Mark mark) throws InvalidMoveArrayException {
        int i,j;
        while(true){
            i=(int)(Math.random()*board.getSize());
            j=(int)(Math.random()*board.getSize());
            if(board.isValidMove(i,j)){
                return new int[] {i,j};
            }
        }
    }

    @Override
    public String getName() {
        return RandomStrategy.NAME;
    }
}
