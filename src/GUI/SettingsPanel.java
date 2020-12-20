package GUI;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private JLabel aiDifficulty;
    private JLabel gridSize;
    private JButton high;
    private JButton low;
    private JTextField row;
    private JTextField column;
    private JTextField winningNum;

    public SettingsPanel(){
        super();
        this.setBackground(Color.BLACK);
        aiDifficulty = new JLabel();
        aiDifficulty.setIcon(GameButton.scaleImage(this,IconAndImages.getAiLabel()));
        gridSize = new JLabel();
        gridSize.setIcon(GameButton.scaleImage(this,IconAndImages.getGridLabel()));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(aiDifficulty,gbc);
        gbc.gridy += 2;
        this.add(gridSize, gbc);
    }
}
