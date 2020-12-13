package GUI;

import Exceptions.InvalidMoveArrayException;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToeMouseListener implements MouseListener {
    private BoardPanel boardPanel;
    public TicTacToeMouseListener(BoardPanel boardPanel){
        this.boardPanel = boardPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameButton gameButton = (GameButton)e.getSource();
        try {
            gameButton.clickAction(this.boardPanel,this.boardPanel.getGame().getCurrentPlayer());
            if(boardPanel.getGame().isAISChance()){
                ((AIPlayerGUI)this.boardPanel.getGame().getCurrentPlayer()).makeMove();
            }
        } catch (InvalidMoveArrayException invalidMoveArrayException) {
            invalidMoveArrayException.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((GameButton)e.getSource()).setBackground(Color.BLACK);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((GameButton)e.getSource()).setBackground(((GameButton)e.getSource()).getDefaultColor());

    }
}
