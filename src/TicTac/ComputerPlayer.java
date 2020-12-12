package TicTac;

import Exceptions.InvalidMoveArrayException;

public class ComputerPlayer extends Player{
    private Strategy strategy;

    public ComputerPlayer(Mark mark,Strategy strategy) {
        super(strategy.getName(), mark);
        this.strategy = strategy;
    }
    public void makeMove(Board board) throws InvalidMoveArrayException {
        int[] move = strategy.determineMove(board,this.mark);
        this.makeMove(move[0],move[1],board);
    }
}
