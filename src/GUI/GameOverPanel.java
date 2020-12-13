package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class GameOverPanel extends JPanel {
    private JButton replayButton;
    private TicTacToeMain mainGame;
    public GameOverPanel(TicTacToeMain mainGame){
        super();
        this.mainGame = mainGame;
        replayButton = new JButton();
        replayButton.setOpaque(false);
        replayButton.setContentAreaFilled(false);
        replayButton.setBorderPainted(false);
        Dimension replayButtonDim = new Dimension(45,45);
        replayButton.setSize(replayButtonDim);
        replayButton.setIcon(new ImageIcon(IconAndImages.getReplayIcon().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
        replayButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainGame.reset();
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
        });
    }

    public Point findLocation(int width,int height){

        int y = height/2 - replayButton.getHeight();
        int x = width/2-2*replayButton.getWidth()/3;
        System.out.println("("+x+","+y+")");
        return new Point(x,y);
    }

    public void addButton(int width,int height){
        this.setLayout(null);
        replayButton.setLocation(this.findLocation(width,height));
        replayButton.setVisible(true);
        this.add(replayButton);
    }
    public void paintComponent(Graphics g){
        g.drawImage(IconAndImages.getGameOverImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

}
