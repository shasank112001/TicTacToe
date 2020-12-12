package TicTacToeGUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Board;
import TicTac.Mark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel {
    private TileButton[][] grid;
    private Board board;
    private TicTacToe game;
    public GamePanel(int size, TicTacToe game){
        super();
        this.game = game;
        this.board = new Board(size);
        this.setLayout(new GridLayout(size,size));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.grid= new TileButton[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] = new TileButton(i,j,new TacMouseListener(this.board,this.game)) ;
                this.add(grid[i][j]);
            }
        }
    }
}
