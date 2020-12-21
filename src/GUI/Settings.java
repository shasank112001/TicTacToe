package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Settings{
    private JPanel mainPanel;
    private JPanel settingsPanel;
    private JPanel AISettingsPanel;
    private JPanel gridSettingsPanel;
    private TicTacToeMain ticTacToeMain;
    private JButton AIDifficultyLabel;
    private JButton gridDimensionLabel;
    private JButton AIDifficultButton;
    private JButton AIEasyButton;
    private JButton confirmButton;
    private JTextField size,winningNum;

    public Settings(TicTacToeMain ticTacToeMain){
        this.ticTacToeMain = ticTacToeMain;
        this.settingsPanel = new JPanel();
        this.settingsPanel.setBackground(Color.GRAY);
    }

    public JPanel getPanel(){
        return settingsPanel;
    }

    public void setUp(){
        this.settingsPanel.setLayout(new GridBagLayout());
        this.AISettingsPanel = new JPanel();
        this.gridSettingsPanel = new JPanel();
        this.confirmButton = new JButton();
        this.setButtonToProperSettings(confirmButton);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy=gbc.gridx =0;
        this.settingsPanel.add(this.AISettingsPanel,gbc);
        gbc.gridy+=1;
        this.settingsPanel.add(this.gridSettingsPanel,gbc);
        gbc.gridy+=1;
        this.settingsPanel.add(this.confirmButton,gbc);
        this.setUpAISettingsPanel();
        this.setUpGridSettingsPanel();
        this.confirmButton.setIcon(GameButton.scaleImage(this.confirmButton,IconAndImages.getBackButton()));
    }

    public void setButtonToProperSettings(JButton button){
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(new EmptyBorder(4,4,4,4));
    }

    public void setUpAISettingsPanel(){
        this.AISettingsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=0;
        this.AISettingsPanel.setOpaque(false);
        this.AIDifficultyLabel = new JButton();
        this.setButtonToProperSettings(AIDifficultyLabel);
        this.AISettingsPanel.add(AIDifficultyLabel,gbc);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        gbc.gridy+=1;
        this.AISettingsPanel.add(buttonsPanel,gbc);
        buttonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.anchor = GridBagConstraints.WEST;
        gbc1.gridy = gbc.gridx = 0;
        this.AIDifficultButton = new JButton();
        this.setButtonToProperSettings(AIDifficultButton);
        this.AIEasyButton = new JButton();
        this.setButtonToProperSettings(AIEasyButton);
        this.AIDifficultButton.setSize(this.AIDifficultButton.getWidth()/2,this.AIDifficultButton.getHeight()/2);
        this.AIEasyButton.setSize(this.AIEasyButton.getWidth()/2,this.AIEasyButton.getHeight()/2);
        buttonsPanel.add(this.AIDifficultButton,gbc1);
        gbc1.gridx+=1;
        buttonsPanel.add(this.AIEasyButton,gbc1);
        this.AIDifficultyLabel.setIcon(GameButton.scaleImage(this.AIDifficultyLabel,IconAndImages.getAiLabel()));
        this.AIDifficultButton.setIcon(GameButton.scaleImage(this.AIDifficultButton,IconAndImages.getDifficultButton()));
        this.AIEasyButton.setIcon(GameButton.scaleImage(this.AIEasyButton,IconAndImages.getEasyButton()));
    }

    public void setUpGridSettingsPanel(){
        this.gridDimensionLabel = new JButton();
        this.gridSettingsPanel.setOpaque(false);
        this.setButtonToProperSettings(gridDimensionLabel);
        this.gridSettingsPanel.add(this.gridDimensionLabel);
        this.gridDimensionLabel.setIcon(GameButton.scaleImage(this.gridDimensionLabel,IconAndImages.getGridLabel()));
    }

}
