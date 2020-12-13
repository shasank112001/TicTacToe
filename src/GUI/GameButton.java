package GUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Mark;
import TicTac.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class GameButton extends JButton {
    int i, j;
    private Color defaultColor;
    private Color highLightColor;
    public Color getDefaultColor() {
        return defaultColor;
    }

    boolean clicked;
    public GameButton(int i, int j, MouseListener lsn){
        super();
        this.i=i;
        this.j=j;
        this.highLightColor = Color.LIGHT_GRAY;
        this.addMouseListener(lsn);
        this.setActionCommand("Empty");
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.clicked = false;
        this.defaultColor = this.getBackground();
        int tempSmallerWidth = (this.getWidth()>this.getHeight())?this.getHeight():this.getWidth();
        this.setPreferredSize(new Dimension(tempSmallerWidth,tempSmallerWidth));
    }
    public boolean isClicked(){
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public int[] get2DLocation(){
        return new int[] {i,j};
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Color getHighLightColor() {
        return highLightColor;
    }

    public void clickAction(BoardPanel boardPanel, Player player) throws InvalidMoveArrayException {
        if((boardPanel.getGame().getBoard().isValidMove(this.getI(),this.getJ()))){
            player.makeMove(this.getI(),this.getJ(),boardPanel.getGame().getBoard());
            if(player.getMark().equals(Mark.X)){
                this.setIcon(scaleImage(this, IconAndImages.getCrossIcon()));
            } else {
                this.setIcon(scaleImage(this, IconAndImages.getCircleIcon()));
            }
            if(boardPanel.getGame().isAgainstAI())
                boardPanel.getGame().setAIsChance();
            this.setActionCommand(player.getMark().toString());
            boardPanel.getGame().setNextPlayer();
            if(boardPanel.getGame().getBoard().gameOver())
                boardPanel.getGame().gameOver();
            this.setClicked(true);
            System.out.println(boardPanel.getGame().getBoard());
        }
    }

    public ImageIcon scaleImage(GameButton tbtn, Image img){
        Dimension size = tbtn.getSize();
        Insets insets = tbtn.getInsets();
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height) {
            size.width = -1;
        } else {
            size.height = -1;
        }
        size.width -= size.width/10;
        size.height -= size.height/10;
        Image scaled = img.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
