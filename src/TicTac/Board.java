package TicTac;
import Exceptions.InvalidMoveArrayException;

public class Board {
    private int size;
    private int winningNum;
    private Mark[][] fields;

    public Board(int size, int winningNum){
        this.size=size;
        this.winningNum = winningNum;
        fields = new Mark[size][size];
        for(int i=0;i<this.size;i++){
            for(int j=0; j<size;j++)
                fields[i][j]=Mark.EMPTY;
        }
    }
    public Board(int size){
        this(size,size);
    }

    public Board(){
        this(3);
    }

    public Board(Board board) throws InvalidMoveArrayException {
        this.size=board.getSize();
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++)
                fields[i][j]=board.getField(i,j);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Board board = null;
        try {
            board = new Board(this);
        } catch (InvalidMoveArrayException e) {
        }
        return board;
    }

    public int getSize(){return this.size;}

    public int getWinningNum(){
        return this.winningNum;
    }

    public boolean isValidMove(int[] move) throws InvalidMoveArrayException {
        if(move.length!=2){
            throw new InvalidMoveArrayException("the length of the array is not equal to two.");
        }
        return fields[move[0]][move[1]].equals(Mark.EMPTY);
    }

    public boolean isValidMove(int i, int j) throws InvalidMoveArrayException {
        return isValidMove(new int[]{i,j});
    }

    public void setField(int[] move,Mark mark){
        fields[move[0]][move[1]]=mark;
    }

    public void setField(int i, int j, Mark mark){
        this.setField(new int[] {i,j},mark);
    }
    public Mark getField(int[] move) throws InvalidMoveArrayException {
        return fields[move[0]][move[1]];
    }
    public Mark getField(int i, int j) throws InvalidMoveArrayException {
        return getField(new int[]{i,j});
    }

    public boolean isFull(){
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++)
                if(fields[i][j].equals(Mark.EMPTY))
                    return false;
        }
        return true;
    }

//    public boolean checkDiagonal(Mark m){
//        boolean check=false;
//        int i,j;
//        for(i=0;i<size;i++){
//            if(!fields[i][i].equals(m)){
//                break;
//            }
//        }
//        if(i==size){ return true;}
//        for(i=0,j=size-1;i<size;i++,j--){
//            if(!fields[i][j].equals(m)){
//                break;
//            }
//        }
//        if(i==size){ return true;}
//        return false;
//    }

//    public boolean checkDiagonal(Mark m){
//        int i, j, counter = 0;
//        for(i = 0 ; i < size; i++){
//            if(fields[i][i].equals(m)){
//                counter++;
//                if( counter == this.winningNum){ return true;}
//
//            } else counter = 0;
//        }
//
//        counter=0;
//
//        for(i = 0, j= this.size-1; i<size ; i++, j--){
//            if(fields[i][j].equals(m)){
//                counter++;
//                if( counter == this.winningNum){ return true;}
//            } else counter = 0;
//        }
//
//        return false;
//
//
//    }

    public boolean checkDiagonal(Mark m){
        int i, j, counter = 0, counter1 = 0;
        for(i = 0; i<= size-winningNum ; i++){
            for( j = 0; j< size - i ; j++){
                if(fields[j][j+i].equals(m)){
                    counter++;
                    if( counter == this.winningNum){ return true;}

                } else counter = 0;

                if(fields[j+i][j].equals(m)){
                    counter1++;
                    if (counter1 == this.winningNum) { return true;}
                } else counter1 = 0;
            }
        }
        return false;

    }
//    public boolean checkRow(Mark m){
//        int i,j;
//        for(i=0;i<size;i++){
//            for(j=0; j<size;j++) {
//                if (!fields[i][j].equals(m)) {
//                    break;
//                }
//            }
//            if(j==size){ return true;}
//        }
//        return false;
//    }

    public boolean checkRow(Mark m){
        int i, j, counter;
        for(i=0;i<size;i++){
            counter = 0;
            for(j=0; j<size;j++) {
                if (fields[i][j].equals(m)) {
                    counter++;
                    if(counter == this.winningNum){ return true;}
                } else counter=0;
            }
        }
        return false;
    }

//    public boolean checkColumn(Mark m){
//        int i,j;
//        for(i=0;i<size;i++){
//            for(j=0;j<size;j++){
//                if (!fields[j][i].equals(m)) {
//                    break;
//                }
//            }
//            if(j==size){ return true;}
//        }
//        return false;
//    }

    public boolean checkColumn(Mark m){
        int i, j, counter;
        System.out.println(this.toString());
        for(i=0;i<size;i++){
            counter = 0;
            for(j=0;j<size;j++){
                if (fields[j][i].equals(m)) {
                    counter ++;
                    if(counter == this.winningNum){ return true;}
                } else counter = 0;
            }
        }
        return false;
    }

    public boolean checkMarkForWin(Mark m){
        return checkColumn(m) || checkDiagonal(m) || checkRow(m);
    }

    public boolean hasWinner(){
        return checkMarkForWin(Mark.O) || checkMarkForWin(Mark.X);
    }

    public void reset(){
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++)
                fields[i][j]=Mark.EMPTY;
        }
    }
    public boolean gameOver(){
        return hasWinner() || isFull();
    }

    public String toString(){
        String str = new String();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                try {
                    str+=(getField(i,j).toString()+" ");
                } catch (InvalidMoveArrayException e) {
                    e.printStackTrace();
                }
            }
            str+="\n";
        }
        return str;
    }
}
