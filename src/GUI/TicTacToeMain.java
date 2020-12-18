package GUI;

import TicTac.Board;
import TicTac.DifficultStrategy;
import TicTac.Mark;
import TicTac.Player;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.util.TimerTask;

public class TicTacToeMain {
    private GameComponents components;
    private JFrame frame;
    private BoardPanel boardPanel;
    private GameOverPanel gop;
    private MenuPanel menu;

    public TicTacToeMain() throws AWTException {
        this.setUpFrame();
        this.menu = new MenuPanel(this);
        this.frame.add(this.menu);
        this.frame.setVisible(true);

    }

    public void setUpFrame(){
        this.frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.frame.setTitle("TicTacToe");
        this.frame.setIconImage(IconAndImages.getGameIcon());
        this.setSquareSize(dim);
        this.frame.setResizable(false);
        this.frame.setLocation(dim.width/2-this.frame.getWidth()/2,dim.height/2-this.frame.getHeight()/2);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setBackground(Color.BLACK);
        this.frame.setLayout(new CardLayout());
    }

    public void setSquareSize(Dimension d){
        if(d.height > d.width){
            this.frame.setSize(d.width/2, d.width/2);
        } else {
            this.frame.setSize(d.height/2, d.height/2);
        }
    }

    public void setUpGameComponentsHuman() throws AWTException {
        this.frame.remove(menu);
        this.components = new GameComponents(new Player("James", Mark.X),new Player("Harry",Mark.O),new Board(5, 2),this);
        this.boardPanel = new BoardPanel(this.components.getSize());
        this.boardPanel.setComponents(this.components);
        this.components.setPanelForComputerAI(this.boardPanel);
        this.frame.add( this.boardPanel);
        this.frame.revalidate();
    }

    public void setUpGameComponentsAI() throws AWTException{
        this.frame.remove(menu);
        this.components = new GameComponents(new Player("James", Mark.X),new AIPlayerGUI(Mark.O,new DifficultStrategy()),new Board(5,2),this);
        this.boardPanel = new BoardPanel(this.components.getSize());
        this.boardPanel.setComponents(this.components);
        components.setPanelForComputerAI(this.boardPanel);
        this.frame.add(this.boardPanel);
        this.frame.revalidate();
    }

    public void gameOver(){
        frame.remove(boardPanel);
        gop = new GameOverPanel(this);
        frame.add(gop);
        frame.revalidate();
        gop.addButton(frame.getWidth(),frame.getHeight());
    }

    public void reset(){
        this.frame.remove(this.gop);
        this.boardPanel.reset();
        this.components.reset();
        this.frame.add(this.menu);
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
