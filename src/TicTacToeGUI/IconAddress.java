package TicTacToeGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class IconAddress {
    private static BufferedImage gameIcon;

    static {
        try {
            gameIcon = ImageIO.read(IconAddress.class.getResource("/imgs/gameIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final URL cross = IconAddress.class.getResource("/imgs/cross.png");
    private static final URL circle = IconAddress.class.getResource("/imgs/circle.png");
    private static Image crossIcon;
    private static Image circleIcon;

    static {
        try {
            crossIcon = ImageIO.read(cross);
            circleIcon = ImageIO.read(circle);
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    public static Image getGameIcon() {
        return gameIcon;
    }

    public static Image getCrossIcon() {
        return crossIcon;
    }

    public static Image getCircleIcon() {
        return circleIcon;
    }
}
