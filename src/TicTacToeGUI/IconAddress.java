package TicTacToeGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class IconAddress {
    private static URL frameIcon;

    static {
        try {
            frameIcon = new URL("https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.softicons.com%2Fgame-icons%2Fbrain-games-icons-by-quizanswers%2Ftic-tac-toe-game-grey-icon&psig=AOvVaw0FdaMOFgauw47DA8TJHc9A&ust=1607873703414000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjbnbviyO0CFQAAAAAdAAAAABAD");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static final URL cross = IconAddress.class.getResource("/Images/cross.png");
    private static final URL circle = IconAddress.class.getResource("/Images/circle.png");

    private static Image gameIcon;

    static {
        try {
            gameIcon = ImageIO.read(frameIcon);
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    private static final ImageIcon crossIcon = new ImageIcon(cross);
    private static final ImageIcon circleIcon = new ImageIcon(circle);

    public static Image getGameIcon() {
        return gameIcon;
    }

    public static ImageIcon getCrossIcon() {
        return crossIcon;
    }

    public static ImageIcon getCircleIcon() {
        return circleIcon;
    }
}
