package GUI;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private GameButton[][] grid;
    private GameComponents game;
    public BoardPanel(int size){
        super();
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

    public void setComponents(GameComponents components){
        this.game = components;
    }
    public GameButton getButton(int i, int j){
        return grid[i][j];
    }
    public GameComponents getGame(){ return this.game;}
}
