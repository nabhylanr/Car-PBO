import java.awt.*;            
import java.awt.event.KeyEvent; // import kelas event untuk keyboard
import java.awt.event.MouseEvent; // import kelas event untuk mouse
import java.util.Random;        

// kelas Elements -> kelas abstrak
abstract public class Elements {
    
    public int x = 0;
    public int y = 0;
    public int xVel = 0;
    public int yVel = 0;
    public int height = 0;
    public int width = 0;
    public boolean hidden = false;
    //  objek random
    private Random random = new Random();

    // method update posisi objek
    public void updatePos() {
        // posisi x diupdate susai pertambahan kecepatan x
        this.x += this.xVel;
        // posisi x diupdate susai pertambahan kecepatan y
        this.y += this.yVel;
        // memanggil method checkBound
        this.checkBound();
    }

    // method abstrak -> cek batas objek
    abstract public void checkBound();

    // method untuk mengecek apakah objek bersinggungan dengan objek lain
    public boolean checkIntersection(Elements e) {
        // membuat objek r1 sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek ini
        Rectangle r1 = new Rectangle(this.x, this.y, this.width, this.height);
        // membuat objek r2 sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek e
        Rectangle r2 = new Rectangle(e.x, e.y, e.width, e.height);

        // jika objek r1 bersinggungan dengan objek r2
        return r1.intersects(r2);
    }

    // method untuk mengatur posisi x secara acak antara low dan high
    public void setXRandom(int low, int high) {
        this.x = random.nextInt(high - low) + low;
    }

    // method untuk mengatur posisi y secara acak antara low dan high
    public void setYRandom(int low, int high) {
        this.y = -random.nextInt(-high - low) - low;
    }

    // Pause game
    public static void pause(MouseEvent e) {
        // membuat objek r sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek
        Rectangle r = new Rectangle(950, 10, 40, 40);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.pause = !GamePanel.pause;
        }
        if (GamePanel.pause) { // pause
            Resources.carMoving.stop();
            Resources.welcomeTone.loop();
        } else { // resume
            Resources.carMoving.loop();
            Resources.welcomeTone.stop();
        }
    }

    // Tombol game

    public static void carHandling(KeyEvent e, Car car) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                car.xVel = 7;
                break;
            case KeyEvent.VK_LEFT:
                car.xVel = -7;
                break;
            case KeyEvent.VK_UP:
                car.yVel = -3;
                break;
            case KeyEvent.VK_DOWN:
                car.yVel = 3;
                break;
            case KeyEvent.VK_SPACE:
                car.xVel = 0;
                break;
            case KeyEvent.VK_SHIFT:
                car.yVel = 0;
                break;
        }
    }

    // Mute

    public static void muteUnmute(MouseEvent e) {
        Rectangle r = new Rectangle(950, 60, 40, 40);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.muteUnmute = !GamePanel.muteUnmute;
        }
        if (GamePanel.muteUnmute) { // mute
            // Stop all audio 
            if (!GamePanel.pause) {
                Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
            else {
            	Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
        } else { // unmute
            // Restart audio only if the game is not paused
            if (!GamePanel.pause) {
                Resources.carMoving.loop();
                Resources.welcomeTone.stop();
            }
        }
    
    }
}