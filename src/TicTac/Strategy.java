package TicTac;

import Exceptions.InvalidMoveArrayException;

public interface Strategy {
    public int[] determineMove(Board board,Mark mark) throws InvalidMoveArrayException;
    public String getName();
}
