package TicTac;

import Exceptions.InvalidMoveArrayException;

import java.util.ArrayList;

public class DifficultStrategy implements Strategy {
    private static final String NAME = "Difficult Strategy";
    @Override
    public int[] determineMove(Board board,Mark mark) throws InvalidMoveArrayException {

        if(board.isValidMove(board.getSize()/2,board.getSize()/2))
            return new int[]{board.getSize()/2, board.getSize()/2};

        ArrayList<int[]> fields= new ArrayList<>();
        for( int i=0; i< board.getSize();i++) {
            for(int j=0;j<board.getSize();j++)
            if(board.isValidMove(i,j)){
                fields.add(new int[]{i,j});
            }
        }
        //if there is only one empty field
        if(fields.size()==1){
            return fields.get(0);
        }
        if(fields.size()==0){
            return null;
        }
        // if computer could win
        for(int i=0;i<fields.size();i++) {
            board.setField(fields.get(i), mark);
            if(board.checkMarkForWin(mark)) {
                board.setField(fields.get(i), Mark.EMPTY);
                return fields.get(i);
            } else {
                board.setField(fields.get(i), Mark.EMPTY);
            }
        }

        //if opponent can win
        for(int i=0;i<fields.size();i++) {
            board.setField(fields.get(i), mark.getOther());
            if(board.checkMarkForWin(mark.getOther())) {
                board.setField(fields.get(i), Mark.EMPTY);
                return fields.get(i);
            } else {
                board.setField(fields.get(i), Mark.EMPTY);
            }
        }

        //random move is necessary
        return fields.get((int) ((fields.size()-1)*Math.random()));
    }
    @Override
    public String getName() {
        return NAME;
    }
}
