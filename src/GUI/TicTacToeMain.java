package GUI;

import TicTac.Board;
import TicTac.DifficultStrategy;
import TicTac.Mark;
import TicTac.Player;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class TicTacToeMain {
    private GameComponents components;
    private JFrame frame;
    private BoardPanel boardPanel;

    public TicTacToeMain() throws AWTException {
        this.frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.frame.setLayout(new BorderLayout());
        this.frame.setTitle("TicTacToe");
        this.frame.setIconImage(IconAndImages.getGameIcon());
        this.setSquareSize(dim);
        this.frame.setResizable(false);
        this.frame.setLocation(dim.width/2-this.frame.getWidth()/2,dim.height/2-this.frame.getHeight()/2);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setBackground(Color.BLACK);
        this.boardPanel =new BoardPanel(3);
        this.frame.add(boardPanel, BorderLayout.CENTER);
        this.frame.setVisible(true);
        this.setUpGameComponents();
    }

    public void setSquareSize(Dimension d){
        if(d.height > d.width){
            this.frame.setSize(d.width/2, d.width/2);
        } else {
            this.frame.setSize(d.height/2, d.height/2);
        }
    }

    public void setUpGameComponents() throws AWTException {
        this.components = new GameComponents(new Player("James", Mark.X),new AIPlayerGUI(Mark.O,new DifficultStrategy()),new Board(3));
        components.setPanelForComputerAI(this.boardPanel);
        this.boardPanel.setComponents(this.components);
    }

    public static void main(String args[]) throws AWTException {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel() );
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new TicTacToeMain();
    }
}
