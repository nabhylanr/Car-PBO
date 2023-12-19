import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


/**
 * Kelas untuk tampilan game.
 */
public class GamePanel extends JPanel implements KeyListener, Runnable, MouseListener {
    //  menyimpan gambar sementara
    private static Image tempImage;
    //  menyimpan state saat ini
    public static  State currentState;
    // menyimpan informasi apakah game sedang pause atau tidak
    public static boolean pause=false;
    //  menyimpan informasi apakah suara sedang mute atau tidak
    public static boolean muteUnmute=false;

    public GamePanel()
    {
        super();
        // Menetapkan ukuran panel sebesar 1008 x 567 piksel
        this.setPreferredSize(new Dimension(1008,567));
        // Menambahkan listener untuk event keyboard
        this.addKeyListener(this);
        // Menambahkan listener untuk event mouse
        this.addMouseListener(this);
        // Menetapkan panel sebagai focusable
        this.setFocusable(true);
        // Meminta panel untuk fokus
        this.requestFocus(true);
    }

    public void addNotify()
    {
        super.addNotify();
        // Memuat semua resource yang dibutuhkan
        Resources.loadResources();
        // Menetapkan state saat ini sebagai MenuState
        GamePanel.currentState= new MenuState();
        // Membuat gambar sementara sebesar 1008 x 567 piksel dengan tipe RGB
        tempImage= new BufferedImage(1008,567,BufferedImage.TYPE_INT_RGB);
        // Membuat thread baru yang menjalankan game loop
        Thread thread = new Thread(this,"gameLoopThread");
        // Memulai thread
        thread.start();
    }

    @Override // interfaces
    public void keyTyped(KeyEvent e) {
        // Method kosong
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Memanggil method onKeyPresses dari state saat ini
        GamePanel.currentState.onKeyPresses(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Method kosong
    }

    @Override
    public void run() {
        // Game loop
        while (true) {
            try {
                // Menunggu selama 50 milidetik
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            if (pause) // kalau lagi di pause 
            	continue;


            Graphics imageGraphics=tempImage.getGraphics();
            Graphics panelGraphics=this.getGraphics();

           imageGraphics.clearRect(0,0,1008,567);

            GamePanel.currentState.update(imageGraphics);
            imageGraphics.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            imageGraphics.setColor(Color.WHITE);
            imageGraphics.drawString("Developed by NabHel", 30, 30);
            imageGraphics.dispose();

            panelGraphics.drawImage(tempImage, 0, 0, null);
            panelGraphics.dispose();


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        GamePanel.currentState.onMousepressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
