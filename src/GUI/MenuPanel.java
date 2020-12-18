package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class MenuPanel extends JPanel {

    private JButton newGame;
    private JButton newGameWithAI;
    private TicTacToeMain ticTacToeMain;

    public MenuPanel(TicTacToeMain ticTacToeMain){
        super();
        this.ticTacToeMain = ticTacToeMain;
        this.setUpButtons();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        Insets inset = new Insets(5,5,5,5);
        gbc.insets = inset;
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.add(newGame,gbc);
        gbc.gridy+=1;
        this.add(newGameWithAI,gbc);
    }

    public void setUpButtons(){
        newGame = new JButton("New Game");
        newGameWithAI = new JButton("Play with AI");
        newGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ticTacToeMain.setUpGameComponentsHuman();
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
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
        });

        newGameWithAI.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ticTacToeMain.setUpGameComponentsAI();
                } catch (AWTException awtException) {

                    System.out.println("Error detected");
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
        });

    }
    public void paintComponent(Graphics g){
        g.drawImage(IconAndImages.getMainMenuImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
