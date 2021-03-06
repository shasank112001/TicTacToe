package GUI;

import Exceptions.InvalidMoveArrayException;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private GameButton[][] grid;
    private GameComponents game;
    private int size;
    public BoardPanel(int size){
        super();
        this.size = size;
        int tempWidth = (this.getWidth()>this.getHeight())?this.getHeight():this.getWidth();
        this.setPreferredSize(new Dimension(tempWidth,tempWidth));
        this.setLayout(new GridLayout(size,size));
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.grid= new GameButton[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] = new GameButton(i,j,new TicTacToeMouseListener(this)) ;
                this.add(grid[i][j]);
            }
        }
    }

    public BoardPanel(BoardPanel bp) throws InvalidMoveArrayException {
        this(bp.size);
        this.game = new GameComponents(bp.game);
    }

    public void setComponents(GameComponents components){
        this.game = components;
    }

    public GameButton getButton(int i, int j){
        return grid[i][j];
    }
    public GameComponents getGame(){ return this.game;}
    public void reset(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j].reset();
            }
        }
    }
}
