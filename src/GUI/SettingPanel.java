/*
 * Created by JFormDesigner on Mon Dec 21 17:51:34 CET 2020
 */

package GUI;

import TicTac.DifficultStrategy;
import TicTac.RandomStrategy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Shasank Sekhar Pandey
 */
public class SettingPanel extends JPanel {
    TicTacToeMain ticTacToeMain;
    public SettingPanel(TicTacToeMain ticTacToeMain)
    {
        initComponents();
        this.ticTacToeMain = ticTacToeMain;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Shasank Sekhar Pandey
        title = new JLabel();
        aiDifficultyLabel = new JLabel();
        difficultButton = new JButton();
        easyButton = new JButton();
        gridSettingsLabel = new JLabel();
        boardSizeLabel = new JLabel();
        winningStrikesLabel = new JLabel();
        winningStrikesTextField = new JTextField();
        defaultButton = new JButton();
        backButton = new JButton();
        boardSizeTextField = new JTextField();
        changesMessage = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(384, 384));
        setMaximumSize(new Dimension(384, 384));
        setPreferredSize(new Dimension(384, 384));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- title ----
        title.setIcon(new ImageIcon(getClass().getResource("/imgs/settingsTitle.png")));
        add(title);
        title.setBounds(115, 10, 170, 45);

        //---- aiDifficultyLabel ----
        aiDifficultyLabel.setIcon(new ImageIcon(getClass().getResource("/imgs/AILabel.png")));
        add(aiDifficultyLabel);
        aiDifficultyLabel.setBounds(75, 55, 290, 35);

        //---- difficultButton ----
        difficultButton.setIcon(new ImageIcon(getClass().getResource("/imgs/button_difficult.png")));
        difficultButton.setFocusPainted(false);
        difficultButton.setOpaque(false);
        difficultButton.setContentAreaFilled(false);
        difficultButton.setBorderPainted(false);
        add(difficultButton);
        difficultButton.setBounds(95, 100, 100, 45);

        //---- easyButton ----
        easyButton.setIcon(new ImageIcon(getClass().getResource("/imgs/button_easy.png")));
        easyButton.setFocusPainted(false);
        easyButton.setOpaque(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setBorderPainted(false);
        add(easyButton);
        easyButton.setBounds(180, 100, 100, 45);

        //---- gridSettingsLabel ----
        gridSettingsLabel.setIcon(new ImageIcon(getClass().getResource("/imgs/gridLabel.png")));
        add(gridSettingsLabel);
        gridSettingsLabel.setBounds(105, 150, 290, 35);

        //---- boardSizeLabel ----
        boardSizeLabel.setText("Board Size");
        boardSizeLabel.setForeground(Color.white);
        add(boardSizeLabel);
        boardSizeLabel.setBounds(55, 190, 70, 25);

        //---- winningStrikesLabel ----
        winningStrikesLabel.setText("Winning strikes");
        winningStrikesLabel.setForeground(Color.white);
        add(winningStrikesLabel);
        winningStrikesLabel.setBounds(201, 190, 100, 25);

        //---- winningStrikesTextField ----
        winningStrikesTextField.setText("3");
        winningStrikesTextField.setOpaque(false);
        winningStrikesTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        winningStrikesTextField.setCaretColor(Color.white);
        winningStrikesTextField.setForeground(Color.white);
        add(winningStrikesTextField);
        winningStrikesTextField.setBounds(299, 190, 25, 25);

        //---- defaultButton ----
        defaultButton.setIcon(new ImageIcon(getClass().getResource("/imgs/button_confirm.png")));
        defaultButton.setFocusPainted(false);
        defaultButton.setOpaque(false);
        defaultButton.setContentAreaFilled(false);
        defaultButton.setBorderPainted(false);
        add(defaultButton);
        defaultButton.setBounds(95, 235, 95, 40);

        //---- backButton ----
        backButton.setIcon(new ImageIcon(getClass().getResource("/imgs/button_confirm.png")));
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        add(backButton);
        backButton.setBounds(175, 235, 100, 40);

        //---- boardSizeTextField ----
        boardSizeTextField.setText("3");
        boardSizeTextField.setOpaque(false);
        boardSizeTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        boardSizeTextField.setForeground(Color.white);
        add(boardSizeTextField);
        boardSizeTextField.setBounds(134, 190, 25, 25);

        //---- changesMessage ----
        changesMessage.setText("Your Changes were saved.");
        changesMessage.setForeground(Color.white);
        changesMessage.setVisible(false);
        add(changesMessage);
        changesMessage.setBounds(95, 275, 180, 20);

        addIcons();
        addListeners();

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void addIcons(){
        this.setBackground(Color.DARK_GRAY);
        title.setIcon(GameButton.scaleImage(title,IconAndImages.getSettingsTitle()));
        backButton.setIcon(GameButton.scaleImage(backButton,IconAndImages.getBackButton()));
        defaultButton.setIcon(GameButton.scaleImage(defaultButton,IconAndImages.getDefaultButton()));
        gridSettingsLabel.setIcon(GameButton.scaleImage(gridSettingsLabel,IconAndImages.getGridLabel()));
        difficultButton.setIcon(GameButton.scaleImage(difficultButton,IconAndImages.getDifficultButton()));
        easyButton.setIcon(GameButton.scaleImage(easyButton,IconAndImages.getEasyButton()));
        aiDifficultyLabel.setIcon(GameButton.scaleImage(aiDifficultyLabel,IconAndImages.getAiLabel()));
    }

    public void displayChangesMessagePanel(){
        changesMessage.setVisible(true);
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changesMessage.setVisible(false);
            }
        });
        timer.start();
    }
    public void addListeners(){
        difficultButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticTacToeMain.changeStrategy(new DifficultStrategy());
                displayChangesMessagePanel();
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

        easyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticTacToeMain.changeStrategy(new RandomStrategy());
                displayChangesMessagePanel();
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
        boardSizeTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = ((JTextField)e.getSource()).getText();
                ticTacToeMain.changeBoardProperties(Integer.parseInt(input),true);
                displayChangesMessagePanel();
            }
        });
        winningStrikesTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = ((JTextField)e.getSource()).getText();
                ticTacToeMain.changeBoardProperties(Integer.parseInt(input),false);
                displayChangesMessagePanel();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticTacToeMain.removeSettingsPanel();
            }
        });
        defaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticTacToeMain.defaultSettings();
                ticTacToeMain.removeSettingsPanel();
            }
        });
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Shasank Sekhar Pandey
    private JLabel title;
    private JLabel aiDifficultyLabel;
    private JButton difficultButton;
    private JButton easyButton;
    private JLabel gridSettingsLabel;
    private JLabel boardSizeLabel;
    private JLabel winningStrikesLabel;
    private JTextField winningStrikesTextField;
    private JButton defaultButton;
    private JButton backButton;
    private JTextField boardSizeTextField;
    private JLabel changesMessage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
