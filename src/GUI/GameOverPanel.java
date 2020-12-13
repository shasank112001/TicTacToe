package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GameOverPanel extends JPanel {

    public GameOverPanel(){
        super();
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
