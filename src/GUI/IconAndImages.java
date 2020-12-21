package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    private static BufferedImage aiLabel;
    private static BufferedImage gridLabel;

    static {
        try {
            gameIcon = ImageIO.read(IconAndImages.class.getResource("/imgs/gameIcon.png"));
            gameOverImage = ImageIO.read(IconAndImages.class.getResource("/imgs/gameOver.jpg"));
            mainMenuImage = ImageIO.read(IconAndImages.class.getResource("/imgs/gradient.jpg"));
            crossWinsImage = ImageIO.read(IconAndImages.class.getResource("/imgs/crossWins.png"));
            circleWinsImage = ImageIO.read(IconAndImages.class.getResource("/imgs/circleWins.png"));
            aiLabel = ImageIO.read(IconAndImages.class.getResource("/imgs/aiLabel.png"));
            gridLabel = ImageIO.read(IconAndImages.class.getResource("/imgs/gridLabel.png"));
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
    private static final URL replayTextAddress = IconAndImages.class.getResource("/imgs/replayText.png");
    private static final URL backButtonAddress = IconAndImages.class.getResource("/imgs/button_go-back.png");
    private static final URL difficultButtonAddress = IconAndImages.class.getResource("/imgs/button_difficult.png");
    private static final URL easyButtonAddress = IconAndImages.class.getResource("/imgs/button_easy.png");
    private static final URL settingsTitleAddress = IconAndImages.class.getResource("/imgs/settingsTitle.png");
    private static final URL defaultButtonAddress = IconAndImages.class.getResource("/imgs/button_default.png");
    private static Image playButton;
    private static Image title;
    private static Image playAgainstFriend;
    private static Image playAgainstAI;
    private static Image settings;
    private static Image crossIcon;
    private static Image circleIcon;
    private static Image replayIcon;
    private static Image replayTextIcon;
    private static Image backButton;
    private static Image easyButton;
    private static Image difficultButton;
    private static Image settingsTitle;
    private static Image defaultButton;

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
            replayTextIcon = ImageIO.read(replayTextAddress);
            easyButton = ImageIO.read(easyButtonAddress);
            difficultButton = ImageIO.read(difficultButtonAddress);
            backButton = ImageIO.read(backButtonAddress);
            settingsTitle = ImageIO.read(settingsTitleAddress);
            defaultButton = ImageIO.read(defaultButtonAddress);
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    public static Image getSettingsTitle(){ return settingsTitle; }

    public static Image getDefaultButton() {
        return defaultButton;
    }

    public static Image getBackButton() {
        return backButton;
    }

    public static Image getEasyButton() {
        return easyButton;
    }

    public static Image getDifficultButton() {
        return difficultButton;
    }

    public static Image getReplayTextIcon() {
        return replayTextIcon;
    }

    public static BufferedImage getAiLabel() {
        return aiLabel;
    }

    public static BufferedImage getGridLabel() {
        return gridLabel;
    }

    public static Image getTitle() {
        return title;
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
