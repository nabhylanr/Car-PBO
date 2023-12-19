import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class WelcomeToLevelThree extends State {
    private int count = 0;

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Resources.welcomeStageImage, 0, 0, 1008, 567, null);
        graphics.setColor(Color.WHITE);
        
        Font customFont = Resources.gulfsDisplay.deriveFont(Font.PLAIN, 90);
        graphics.setFont(customFont);

        if (count == 0) {
            Resources.mainMenuTone.stop();
            Resources.welcomeTone.loop();
        }

        if (count > 3)
            graphics.drawString("L", 320, 300);

        if (count > 6)
            graphics.drawString("E", 375, 300);

        if (count > 9)
            graphics.drawString("V", 435, 300);

        if (count > 12)
            graphics.drawString("E", 504, 300);

        if (count > 15)
            graphics.drawString("L", 563, 300);

        if (count > 18)
            graphics.drawString("3", 640, 300);

        if (count > 21 && count % 6 == 0) {
            customFont = Resources.gulfsDisplay.deriveFont(Font.PLAIN, 40);
            graphics.setFont(customFont);
            graphics.drawString("PLAY?", 430, 350);
        }
        count++;
    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r = new Rectangle(420, 330, 170, 40);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.currentState = new LevelThree();
        }
    }

    @Override
    public void onKeyPresses(KeyEvent e) {
    }
}

