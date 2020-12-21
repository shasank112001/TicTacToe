package GUI;

import TicTac.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class TicTacToeMain {
    private GameComponents components;
    private Player humanPlayer1;
    private Player humanPlayer2;
    private AIPlayerGUI ai;
    private Strategy strategy;
    private Board board;
    private JFrame frame;
    private Dimension frameDimension;
    private BoardPanel boardPanel;
    private int size;
    private int winningNum;
    private GameOverPanel gop;
    private GameSetUpPanel menu;
    private SettingPanel settings;
    private static final int defaultBoardSize = 3;

    public TicTacToeMain() throws AWTException {
        this.setUpFrame();
        this.components = null;
        this.size = defaultBoardSize;
        this.winningNum = defaultBoardSize;
        this.humanPlayer1 = new Player("humanPlayer1",Mark.X);
        this.humanPlayer2 = new Player( "humanPlayer2", Mark.O);
        this.strategy = new RandomStrategy();
        this.ai = new AIPlayerGUI(Mark.O,this.strategy);
        this.board = new Board(this.size,this.winningNum);
        this.menu = new GameSetUpPanel(this);
        this.settings = new SettingPanel(this);
        this.frame.add(this.menu);
        this.frame.setVisible(true);

    }

    public void changeBoardProperties(int size,int winningNum){
        if(winningNum>size){
            this.size = this.winningNum = size;
        }
        this.size = size;
        this.winningNum = winningNum;
    }

    public void changeBoardProperties(int value, boolean isBoardSize){
        if(isBoardSize){
            this.changeBoardProperties(value,this.winningNum);
        } else {
            this.changeBoardProperties(this.size,value);
        }
    }

    public void changeStrategy(Strategy strategy){
        this.ai.setStrategy(strategy);
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
        System.out.println(d);
    }

    public void setUpGameComponentsHuman() throws AWTException {
        this.frame.remove(menu);
        this.board = new Board(this.size,this.winningNum);
        this.components = new GameComponents(this.humanPlayer1,this.humanPlayer2,this.board,this);
        this.boardPanel = new BoardPanel(this.size);
        this.boardPanel.setComponents(this.components);
        this.components.setPanelForComputerAI(this.boardPanel);
        this.frame.add( this.boardPanel);
        this.frame.revalidate();
    }

    public void setUpGameComponentsAI() throws AWTException{
        this.frame.remove(menu);
        this.board = new Board(this.size,this.winningNum);
        this.components = new GameComponents(this.humanPlayer1,this.ai,this.board,this);
        this.boardPanel = new BoardPanel(this.size);
        this.boardPanel.setComponents(this.components);
        this.components.setPanelForComputerAI(this.boardPanel);
        this.frame.add( this.boardPanel);
        this.frame.revalidate();
    }

    public void gameOver(Mark winnerMark){
        frame.remove(this.boardPanel);
        gop = new GameOverPanel(this,winnerMark);
        frame.add(gop);
        frame.revalidate();
    }

    public void addSettingsPanel(){
        frame.remove(this.menu);
        frame.add(settings);
        frame.revalidate();

    }
    public void reset(){
        this.frame.remove(this.gop);
        this.boardPanel.reset();
        this.components.reset();
        this.frame.add(this.menu);
    }

    public void removeSettingsPanel(){
        frame.remove(settings);
        frame.add(this.menu);
        frame.revalidate();
    }
    public void defaultSettings(){
        this.ai.setStrategy(new RandomStrategy());
        this.size = this.winningNum = defaultBoardSize;
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
