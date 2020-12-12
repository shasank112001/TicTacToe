package TicTacToeGUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Board;
import TicTac.Mark;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TacMouseListener implements MouseListener {
    private Board board;
    private TicTacToe game;

    public TacMouseListener(Board board, TicTacToe game){
        this.board= board;
        this.game = game;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        TileButton tbtn = (TileButton)e.getSource();
        try {
            if((board.isValidMove(tbtn.getI(),tbtn.getJ()))){
                game.getCurrentPlayer().makeMove(tbtn.getI(),tbtn.getJ(),game.getBoard());
                if(game.getBoard().gameOver())
                    game.gameOver();
                if(game.getCurrentPlayer().getMark().equals(Mark.X)){
                    tbtn.setIcon(IconAddress.getCrossIcon());
                } else { tbtn.setIcon(IconAddress.getCircleIcon());}
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
        ((TileButton)e.getSource()).setBackground(Color.CYAN);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((TileButton)e.getSource()).setBackground(Color.BLACK);
    }
}
