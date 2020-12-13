package GUI;

import Exceptions.InvalidMoveArrayException;
import TicTac.Board;
import TicTac.Mark;
import TicTac.Player;
import TicTac.Strategy;

import java.awt.*;

public class AIPlayerGUI extends Player {
    private Strategy strategy;
    private BoardPanel boardPanel;

    public AIPlayerGUI(Mark mark, Strategy strategy) throws AWTException {
        super(strategy.getName(),mark);
        this.strategy = strategy;
        this.boardPanel = null;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public int[] determineMove(Board board) throws InvalidMoveArrayException {
        return this.strategy.determineMove(board, this.getMark());
    }

    public void makeMove(Board board) throws InvalidMoveArrayException {
        int[] move = this.determineMove( board);
//        this.boardPanel.getButton(move[0],move[1]).clickAction(this.boardPanel);
        super.makeMove(move[0],move[1],board);
    }
}
