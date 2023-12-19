import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

    public class Resources {
        public static Image playerCar;
        public static Image enemyCar1;
        public static Image enemyCar2;
        public static Image enemyCar3;
        public static Image enemyCar4;
        public static Image death;
        public static Image time;
        public static Image roadImage;
        public static Image crashBoomImage;
        public static Image finishLineImage;
        public static Image playPause;
        public static Image muteUnmute;
        public static Image completeGame;
        public static Image kontrol;
        public static Image Gameplay;
        public static Image welcomeStageImage;
        public static Image welcomeToGameImage;
        public static Image roadbg;
        public static Image Level;

        
        public static AudioClip carCrash;
        public static AudioClip carMoving;
        public static AudioClip mainMenuTone;
        public static AudioClip welcomeTone;
        public static AudioClip gameOverTone;
        public static AudioClip finishTone;
        public static AudioClip juaraSatu;


        public static Font gulfsDisplay;

    private Resources() {
    }

    public static void loadResources() {
        try {
            gulfsDisplay = Font.createFont(Font.TRUETYPE_FONT, Resources.class.getResourceAsStream("Fonts/gulfsDisplay.ttf"));            
            playerCar = ImageIO.read(Resources.class.getResource("Images/playerCar.png"));
            enemyCar1 = ImageIO.read(Resources.class.getResource("Images/lion.png"));
            enemyCar2 = ImageIO.read(Resources.class.getResource("Images/snake.png"));
            enemyCar3 = ImageIO.read(Resources.class.getResource("Images/elephant.png"));
            death = ImageIO.read(Resources.class.getResource("Images/death.png"));
            time = ImageIO.read(Resources.class.getResource("Images/time.png"));
            playPause = ImageIO.read(Resources.class.getResource("Images/playpause.png"));
            muteUnmute = ImageIO.read(Resources.class.getResource("Images/muteUnmute.png"));
            welcomeToGameImage = ImageIO.read(Resources.class.getResource("Images/Menustate.jpg"));
            welcomeStageImage = ImageIO.read(Resources.class.getResource("Images/menubg.jpg"));
            finishLineImage = ImageIO.read(Resources.class.getResource("Images/finishLine.png"));
            crashBoomImage = ImageIO.read(Resources.class.getResource("Images/crash.png"));
            //roadImage = ImageIO.read(Resources.class.getResource("Images/Road.jpg"));
            roadImage = ImageIO.read(Resources.class.getResource("Images/RoadFinal.png"));
            roadbg = ImageIO.read(Resources.class.getResource("Images/roadbg.jpg"));
            completeGame = ImageIO.read(Resources.class.getResource("Images/Completegame.jpg"));
            kontrol = ImageIO.read(Resources.class.getResource("Images/Kontrol.jpg"));
            Gameplay = ImageIO.read(Resources.class.getResource("Images/Gameplay.jpg"));
            Level = ImageIO.read(Resources.class.getResource("Images/level.jpg"));

            carCrash= Applet.newAudioClip(Resources.class.getResource("AudioClips/carcrash.wav"));
            carMoving= Applet.newAudioClip(Resources.class.getResource("AudioClips/thelion.wav"));
            mainMenuTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/menu.wav"));
            welcomeTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/backSongWelcome.wav"));
            gameOverTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/gameover.wav"));
            finishTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/finish.wav"));
            juaraSatu = Applet.newAudioClip(Resources.class.getResource("AudioClips/pregnant.wav"));

        } 
        catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
