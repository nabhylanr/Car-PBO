import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

abstract public class State {
    abstract public void update(Graphics graphics); // update elemen grafis
    abstract public void onMousepressed(MouseEvent e); // keadaan saat mouse ditekan
    abstract public void onKeyPresses(KeyEvent e); // keadaan saat keyboard ditekan
}
