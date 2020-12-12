package TicTacToeGUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Board;
import TicTac.Mark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TacMouseListener implements MouseListener {
    private TicTacToe game;

    public TacMouseListener(Board board, TicTacToe game){
        this.game = game;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        TileButton tbtn = (TileButton)e.getSource();
        try {
//            !tbtn.isClicked() &&
            if((game.getBoard().isValidMove(tbtn.getI(),tbtn.getJ()))){
                game.getCurrentPlayer().makeMove(tbtn.getI(),tbtn.getJ(),game.getBoard());
                if(game.getCurrentPlayer().getMark().equals(Mark.X)){
                    tbtn.setIcon(scaleImage(tbtn,IconAddress.getCrossIcon()));
                } else {
                    tbtn.setIcon(scaleImage(tbtn,IconAddress.getCircleIcon()));
                }
                game.nextPlayer();
                if(game.getBoard().gameOver())
                    game.gameOver();
                tbtn.setClicked(true);
            }
        } catch (InvalidMoveArrayException invalidMoveArrayException) {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!((TileButton)e.getSource()).isClicked())
            ((TileButton)e.getSource()).setBackground(Color.CYAN);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!((TileButton)e.getSource()).isClicked())
            ((TileButton)e.getSource()).setBackground(Color.BLACK);
    }

    public ImageIcon scaleImage(TileButton tbtn, Image img){
        Dimension size = tbtn.getSize();
        Insets insets = tbtn.getInsets();
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height) {
            size.width = -1;
        } else {
            size.height = -1;
        }
        Image scaled = img.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
