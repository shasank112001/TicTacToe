package GUI;

import Exceptions.InvalidMoveArrayException;


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
            gameButton.clickAction(this.boardPanel);
            if(this.boardPanel.getGame().getCurrentPlayer() instanceof AIPlayerGUI){
                ((AIPlayerGUI) this.boardPanel.getGame().getCurrentPlayer()).makeMove(this.boardPanel.getGame().getBoard());
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
