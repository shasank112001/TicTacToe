package TicTac;

import Exceptions.InvalidMoveArrayException;

public class ComputerPlayer extends Player{
    private Strategy strategy;

    public ComputerPlayer(Mark mark,Strategy strategy) {
        super(strategy.getName(), mark);
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public int[] determineMove(Board board) throws InvalidMoveArrayException {
        return strategy.determineMove(board,this.mark);
    }
    public void makeMove(Board board) throws InvalidMoveArrayException {
        int[] move = this.determineMove(board);
        super.makeMove(move[0],move[1],board);
    }
    public void makeMove(int i, int j,Board board) throws InvalidMoveArrayException {
        super.makeMove(i,j,board);
    }
}
