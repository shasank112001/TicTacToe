package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class IconAndImages {
    private static BufferedImage gameIcon;
    private static BufferedImage gameOverImage;

    static {
        try {
            gameIcon = ImageIO.read(IconAndImages.class.getResource("/imgs/gameIcon.png"));
            gameOverImage = ImageIO.read(IconAndImages.class.getResource("/imgs/gameOver.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final URL cross = IconAndImages.class.getResource("/imgs/cross.png");
    private static final URL circle = IconAndImages.class.getResource("/imgs/ring.png");
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

    public static Image getGameOverImage() {
        return gameOverImage;
    }
}
