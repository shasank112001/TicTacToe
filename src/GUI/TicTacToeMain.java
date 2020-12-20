package GUI;

import TicTac.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class TicTacToeMain {
    private GameComponents components;
    private JFrame frame;
    private Dimension frameDimension;
    private BoardPanel boardPanel;
    private GameOverPanel gop;
    private boolean isDefault;
    private GameSetUpPanel menu;
    private static GameComponents defaultGameComponentsAgainstAI;
    private static GameComponents defaultGameComponents;

    {
        defaultGameComponents = new GameComponents(new Player("James", Mark.X),new Player("Harry",Mark.O),new Board(3, 3),this);
        defaultGameComponentsAgainstAI = new GameComponents(new Player("James", Mark.X),new AIPlayerGUI(Mark.O,new RandomStrategy()),new Board(3,3),this);
    }
//    private MenuPanel menu;
    public TicTacToeMain() throws AWTException {
        this.setUpFrame();
        this.isDefault = true;
        this.components = null;
        this.menu = new GameSetUpPanel(this);
//        this.menu = new MenuPanel(this);
        this.frame.add(this.menu);
        this.frame.setVisible(true);

    }

    public Dimension getFrameDimension() {
        return frameDimension;
    }

    public void setUpFrame(){
        this.frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        this.frameDimension = tk.getScreenSize();
        this.frame.setTitle("TicTacToe");
        this.frame.setIconImage(IconAndImages.getGameIcon());
        this.setSquareSize(this.frameDimension);
        this.frame.setResizable(false);
        this.frame.setLocation(screenDimension.width/2-this.frame.getWidth()/2,screenDimension.height/2-this.frame.getHeight()/2);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setBackground(Color.BLACK);
        this.frame.setLayout(new CardLayout());
    }

    public void setSquareSize(Dimension d){
        if(d.height > d.width){
            this.frame.setSize(d.width/2, d.width/2);
            d.setSize(d.width/2, d.width/2);
        } else {
            this.frame.setSize(d.height/2, d.height/2);
            d.setSize(d.height/2, d.height/2);
        }
    }

    public void setUpGameComponentsHuman() throws AWTException {
        this.frame.remove(menu);
        if(isDefault) {
            this.components = defaultGameComponents;
            this.boardPanel = new BoardPanel(this.components.getSize());
            this.boardPanel.setComponents(this.components);
            this.components.setPanelForComputerAI(this.boardPanel);
        } else {
            this.boardPanel = new BoardPanel(this.components.getSize());
            this.boardPanel.setComponents(this.components);
            this.components.setPanelForComputerAI(this.boardPanel);
        }
        this.frame.add( this.boardPanel);
        this.frame.revalidate();
    }

    public void setUpGameComponentsAI() throws AWTException{
        this.frame.remove(menu);
        if(isDefault) {
            this.components = defaultGameComponentsAgainstAI;
            this.boardPanel = new BoardPanel(this.components.getSize());
            this.boardPanel.setComponents(this.components);
            components.setPanelForComputerAI(this.boardPanel);
        } else {
            this.boardPanel = new BoardPanel(this.components.getSize());
            this.boardPanel.setComponents(this.components);
            components.setPanelForComputerAI(this.boardPanel);
        }
        this.frame.add(this.boardPanel);
        this.frame.revalidate();
    }

    public void changeGameComponents(GameComponents components){
        this.components = components;
    }

    public void gameOver(Mark winnerMark){
        frame.remove(this.boardPanel);
        gop = new GameOverPanel(this,winnerMark);
        frame.add(gop);
        gop.addButton(frame.getWidth(),frame.getHeight());
        frame.revalidate();
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
