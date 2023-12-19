import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kontrol extends State{
    private int count=0;

    @Override
    public void update(Graphics graphics) {

        graphics.drawImage(Resources.kontrol, 0, 0, 1008, 567, null);
        graphics.setColor(Color.WHITE);

        Font customFont = Resources.gulfsDisplay.deriveFont(Font.PLAIN, 30);
        graphics.setFont(customFont);

        if (count == 0) {
            Resources.mainMenuTone.stop();
            Resources.welcomeTone.loop();
            count++;
        }

        graphics.drawString("Back", 900, 530);
    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r = new Rectangle(880, 510, 130, 40);
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new MenuState();
        }


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}

