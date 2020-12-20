package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

public class IconAndImages {
    private static BufferedImage gameIcon;
    private static BufferedImage gameOverImage;
    private static BufferedImage mainMenuImage;
    private static BufferedImage crossWinsImage;
    private static BufferedImage circleWinsImage;

    static {
        try {
            gameIcon = ImageIO.read(IconAndImages.class.getResource("/imgs/gameIcon.png"));
            gameOverImage = ImageIO.read(IconAndImages.class.getResource("/imgs/gameOver.jpg"));
            mainMenuImage = ImageIO.read(IconAndImages.class.getResource("/imgs/gradient.jpg"));
            crossWinsImage = ImageIO.read(IconAndImages.class.getResource("/imgs/crossWins.png"));
            circleWinsImage = ImageIO.read(IconAndImages.class.getResource("/imgs/circleWins.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final URL cross = IconAndImages.class.getResource("/imgs/cross.png");
    private static final URL circle = IconAndImages.class.getResource("/imgs/ring.png");
    private static final URL replay = IconAndImages.class.getResource("/imgs/replay.png");
    private static final URL playButtonAddress = IconAndImages.class.getResource("/imgs/play-button.gif");
    private static final URL playAddress = IconAndImages.class.getResource("/imgs/button_play-against-friend.png");
    private static final URL playAgainstAIAddress = IconAndImages.class.getResource("/imgs/button_play-against-ai.png");
    private static final URL settingButtonAddress = IconAndImages.class.getResource("/imgs/settings.png");
    private static final URL titleAddress = IconAndImages.class.getResource("/imgs/title.png");
    private static Image playButton;
    private static Image title;
    private static Image playAgainstFriend;
    private static Image playAgainstAI;
    private static Image settings;
    private static Image crossIcon;
    private static Image circleIcon;
    private static Image replayIcon;

    public static Image getTitle() {
        return title;
    }

    static {
        try {
            crossIcon = ImageIO.read(cross);
            circleIcon = ImageIO.read(circle);
            replayIcon = ImageIO.read(replay);
            playButton = ImageIO.read(playButtonAddress);
            settings = ImageIO.read(settingButtonAddress);
            playAgainstAI = ImageIO.read(playAgainstAIAddress);
            playAgainstFriend = ImageIO.read(playAddress);
            title = ImageIO.read(titleAddress);
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

    public static Image getReplayIcon() { return replayIcon; }

    public static Image getGameOverImage() {
        return gameOverImage;
    }

    public static BufferedImage getCrossWinsImage() {
        return crossWinsImage;
    }

    public static BufferedImage getCircleWinsImage() {
        return circleWinsImage;
    }

    public static BufferedImage getMainMenuImage() {
        return mainMenuImage;
    }

    public static Image getPlayAgainstFriend() {
        return playAgainstFriend;
    }

    public static Image getPlayAgainstAI() {
        return playAgainstAI;
    }

    public static Image getSettings() {
        return settings;
    }

    public static Image getPlayButton() {
        return playButton;
    }
}
