package TicTac;

import Exceptions.InvalidMoveArrayException;

public class Player {
    Mark mark;
    String name;

    public Player(String name, Mark mark){
        this.name = name;
        this.mark = mark;
    }

    public Player(String name) {
        this(name, Mark.X);
    }

    public void makeMove(int i, int j,Board board) throws InvalidMoveArrayException {
        board.setField(new int[]{i,j},this.mark);
    }

    public String toString(){
        return this.name+" has mark-"+this.mark;
    }
}
