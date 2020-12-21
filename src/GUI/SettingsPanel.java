package GUI;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel {
    JPanel mainPanel;
    public SettingsPanel() {
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(new JLabel("Settings"));
        mainPanel.add(p);

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(new JLabel("AI Difficulty"));
        mainPanel.add(p);

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(new JLabel("Grid Size"));
        mainPanel.add(p);

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(new JTextField("3"));
        p.add(new JLabel("X"));
        p.add(new JTextField("3"));
        mainPanel.add(p);

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(new JButton("Confirm"));
        mainPanel.add(p);
    }

    public JPanel getPanel(){
        return mainPanel;
    }
}
