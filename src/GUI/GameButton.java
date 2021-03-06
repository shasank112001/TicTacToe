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
//        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setBorder(BorderFactory.createLineBorder(new Color(2,19,28)));
        this.clicked = false;
        this.defaultColor = this.getBackground();
        int tempSmallerWidth = (this.getWidth()>this.getHeight())?this.getHeight():this.getWidth();
        this.setPreferredSize(new Dimension(tempSmallerWidth,tempSmallerWidth));
        this.setFocusPainted(false);
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
            if(boardPanel.getGame().getBoard().gameOver()){
                if(boardPanel.getGame().getBoard().checkMarkForWin(Mark.X)){
                    boardPanel.getGame().gameOver(Mark.X);
                } else if(boardPanel.getGame().getBoard().checkMarkForWin(Mark.O)){
                    boardPanel.getGame().gameOver(Mark.O);
                } else boardPanel.getGame().gameOver(Mark.EMPTY);
            }
            this.setClicked(true);
        }
    }

    public static ImageIcon scaleImage(JComponent tbtn, Image img){
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

    public void reset(){
        this.setActionCommand("Empty");
        this.setBackground(Color.DARK_GRAY);
        this.clicked = false;
        this.setIcon(null);
    }
}
