package TicTacToeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TileButton extends JButton {
    int i, j;
    public TileButton(int i, int j, MouseListener lsn){
        super();
        this.i=i;
        this.j=j;
        this.addMouseListener(lsn);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.BLACK);
        this.setActionCommand("Empty");
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    public int[] get2DLocation(){
        return new int[] {i,j};
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
