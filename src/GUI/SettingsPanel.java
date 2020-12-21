package GUI;

import TicTac.DifficultStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SettingsPanel extends JPanel {
    private JLabel aiDifficulty;
    private TicTacToeMain ticTacToeMain;
    private JLabel gridSize;
    private JButton high;
    private JButton low;
    private JButton confirm;
    private JTextField row;
    private JTextField column;
    private JTextField winningNum;

    public SettingsPanel(TicTacToeMain ticTacToeMain){
        super();
        this.ticTacToeMain = ticTacToeMain;
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        aiDifficulty = new JLabel("AI Difficulty");
//        high = new JButton(GameButton.scaleImage(high,IconAndImages.getDifficultButton()));/
        System.out.println(aiDifficulty.getSize());
        aiDifficulty.setIcon(new ImageIcon(IconAndImages.getAiLabel().getScaledInstance(aiDifficulty.getWidth(),aiDifficulty.getHeight(),Image.SCALE_SMOOTH)));        this.add(aiDifficulty);
//        this.setSize(ticTacToeMain.getFrameDimension());
//        this.setUp();
    }

    public void setUp(){
        aiDifficulty = new JLabel(new ImageIcon(IconAndImages.getAiLabel().getScaledInstance(aiDifficulty.getWidth(),aiDifficulty.getHeight(),Image.SCALE_SMOOTH)));
        gridSize = new JLabel(new ImageIcon(IconAndImages.getGridLabel().getScaledInstance(gridSize.getWidth(),gridSize.getHeight(),Image.SCALE_SMOOTH)));
        high = new JButton(GameButton.scaleImage(high,IconAndImages.getDifficultButton()));
        System.out.println("high "+high.getSize());
        high.setIcon(GameButton.scaleImage(high,IconAndImages.getDifficultButton()));
        low = new JButton();
        low.setIcon(GameButton.scaleImage(low,IconAndImages.getEasyButton()));
        confirm = new JButton();
        confirm.setIcon(GameButton.scaleImage(confirm,IconAndImages.getConfirmButton()));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(aiDifficulty,gbc);
        gbc.gridx-=1;
        gbc.gridy+=1;
        this.add(high);
        gbc.gridx+=1;
        this.add(low);
        gbc.gridy += 2;
        this.add(gridSize, gbc);
    }

    public void setListenersForButtons(){
        this.high.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticTacToeMain.changeStrategy(new DifficultStrategy());
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

}
