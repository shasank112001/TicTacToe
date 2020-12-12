package TicTacToeGUI;

import TicTac.Board;
import TicTac.Player;

import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;
    private JFrame frame;
    private GamePanel gamePanel;

    public TicTacToe(){
        frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        frame.setLayout(new BorderLayout());
        frame.setSize(dim.width/2, dim.height/2);
        frame.setLocation(dim.width/2-frame.getWidth()/2,dim.height/2-frame.getHeight()/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        this.gamePanel=new GamePanel(3,this);
        frame.add(gamePanel, BorderLayout.CENTER);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void gameOver(){

    }

    public static void main(String args[]){
        new TicTacToe();
    }
}
