package GUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Board;
import TicTac.ComputerPlayer;
import TicTac.Mark;
import TicTac.Player;

public class GameComponents {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;
    private Boolean isAIsChance;
    private Boolean isAgainstAI;
    private TicTacToeMain mainGame;

    public GameComponents(Player player1, Player player2, Board board,TicTacToeMain mainGame){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentPlayer = player1;
        this.mainGame=mainGame;
    }

    public GameComponents(GameComponents gc) throws InvalidMoveArrayException {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.board = new Board(board);
        this.mainGame = mainGame;
    }

    public ComputerPlayer getComputerPlayer(){
        if(player1 instanceof ComputerPlayer){
            return (ComputerPlayer)player1;
        } else if(player2 instanceof ComputerPlayer){
            return (ComputerPlayer)player2;
        } else return null;
    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setNextPlayer(){
        if(currentPlayer.equals(player1)) {
            this.currentPlayer = player2;
        }
        else
            currentPlayer = player1;
    }

    public void gameOver(Mark m){
        this.mainGame.gameOver(m);
    }

    public void setPanelForComputerAI(BoardPanel boardPanel){
        if(this.player1 instanceof AIPlayerGUI){
            ((AIPlayerGUI)this.getPlayer1()).setBoardPanel(boardPanel);
            this.isAgainstAI = true;
            this.isAIsChance = false;
        } else if(this.player2 instanceof AIPlayerGUI){
            ((AIPlayerGUI)this.getPlayer2()).setBoardPanel(boardPanel);
            this.isAgainstAI = true;
            this.isAIsChance = false;
        }
        else
            this.isAgainstAI = false;
    }
    public void reset(){
        this.board = new Board();
        if(isAIsChance!=null && isAIsChance==true)
            isAIsChance = false;
        this.currentPlayer=this.player1;
    }

    public int getSize(){
        return this.board.getSize();
    }

    public void setAgainstAI(boolean againstAI){
        this.isAgainstAI = againstAI;
        this.isAIsChance = false;
    }
    public boolean isAISChance(){
        return isAIsChance;
    }
    public void setAIsChance(){
        if(isAIsChance!=null)
            isAIsChance = !isAIsChance;
    }
    public Boolean isAgainstAI(){
        return isAgainstAI;
    }
}
