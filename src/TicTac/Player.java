package TicTac;

import Exceptions.InvalidMoveArrayException;

public class Player {
    Mark mark;
    String name;

    public Player(String name, Mark mark){
        this.name = name;
        this.mark = mark;
    }

    public Player(String name){
        this(name,Mark.X);
    }
    public int[] determineMove(){
        return new int[]{0,0};
    }
    public void makeMove(Board board) throws InvalidMoveArrayException {
        while(true){
            int[] move = determineMove();
            if(board.isValidMove(move)){
                board.setField(move,this.mark);
                break;
            } else {

            }
            }
    }
}
