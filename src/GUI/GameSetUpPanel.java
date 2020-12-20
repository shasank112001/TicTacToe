package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class GameSetUpPanel extends JPanel {
    TicTacToeMain ticTacToeMain;
    JLabel titleLabel;
    JButton playFriendButton;
    JButton playAIButton;
    JButton settingsButton;
    SettingsPanel settingsPanel;

    public GameSetUpPanel(TicTacToeMain ticTacToeMain){
        super();
        this.ticTacToeMain = ticTacToeMain;
        this.titleLabel = new JLabel();
        this.setSize(ticTacToeMain.getFrameDimension());
        this.titleLabel.setSize(this.getWidth()/3,this.getHeight()/3);
        this.titleLabel.setIcon(GameButton.scaleImage(this.titleLabel,IconAndImages.getTitle()));
        this.setBackground(Color.BLACK);
        this.playFriendButton = new JButton();
        this.playFriendButton.setFocusPainted(false);
        this.playAIButton = new JButton();
        this.playAIButton.setFocusPainted(false);
        this.settingsButton = new JButton();
        this.settingsButton.setFocusPainted(false);
        Dimension playDim = new Dimension(150,50);
        GameSetUpPanel.setUPButtonWithImage(playFriendButton, IconAndImages.getPlayAgainstFriend(),playDim);
        GameSetUpPanel.setUPButtonWithImage(playAIButton, IconAndImages.getPlayAgainstAI(),new Dimension(playFriendButton.getWidth(),50));
        GameSetUpPanel.setUPButtonWithImage(settingsButton, IconAndImages.getSettings(),new Dimension(150,50));

        this.playAIButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ticTacToeMain.setUpGameComponentsAI();
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

        this.playFriendButton.addMouseListener(new MouseListener() {
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
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(titleLabel,gbc);
        gbc.gridy += 5;
        this.add(this.playFriendButton,gbc);
        gbc.gridy += 5;
        this.add(this.playAIButton,gbc);
        gbc.gridy += 5;
        this.add(this.settingsButton,gbc);

    }

    public static void setUPButtonWithImage(JButton button, Image image, Dimension d){
        button.setSize(d);
        button.setIcon(GameButton.scaleImage(button,image));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(IconAndImages.getMainMenuImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }



}
