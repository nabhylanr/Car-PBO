import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

/**
 * Kelas ini merepresentasikan sebuah game yang telah selesai dimainkan.
 */
public class CompleteGame extends State{
	// Variabel untuk menghitung jumlah kali method update dipanggil.
	private int count = 0;

	/**
     * Method ini digunakan untuk memperbarui tampilan game setelah selesai dimainkan.
     * graphics objek Graphics yang digunakan untuk menggambar tampilan game
     */
    @Override
    public void update(Graphics graphics) {
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 40));
     // Jika method ini baru pertama kali dipanggil, stop suara selesai game dan putar suara menu utama.
        if (count == 0) {
            Resources.finishTone.stop();
            Resources.carMoving.stop();
            Resources.juaraSatu.loop();
            //Resources.juaraSatu.play();
            count++; 
        }

     // Gambar latar belakang putih.
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1008, 567);
        // Gambar gambar selesai game.
        graphics.drawImage(Resources.completeGame, 0, 0, 1008, 567, null);
        // Atur warna font menjadi hitam.
        graphics.setColor(Color.WHITE);
        // Atur font menjadi SansSerif, gaya plain, dan ukuran 30.
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 25));
        // Tulis "YAY" dan "NAY" di layar.
        graphics.drawString("Yay", 480, 330);
	    graphics.drawString("Nay", 480, 365);
    }
    /**
     * Method ini dipanggil ketika tombol mouse ditekan.
     * e objek MouseEvent yang menyimpan informasi tentang event mouse yang terjadi
     */
    @Override
    public void onMousepressed(MouseEvent e) {
    	Rectangle r1 = new Rectangle(500, 310, 170, 40); // yay
        Rectangle r2 = new Rectangle(500, 345, 170, 40); // nay

        if (r1.contains(e.getX(), e.getY())) {
	        // Tutup aplikasi jika tombol exit diklik
            GamePanel.currentState = new MenuState();

	    } 
        else if (r2.contains(e.getX(), e.getY())) {
	        // Pindah ke WelcomeToLevel1 jika tombol start diklik
	        Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
	    }

    }
    
    /**
     * Method ini dipanggil ketika tombol keyboard ditekan.
     * e objek KeyEvent yang menyimpan informasi tentang event keyboard yang terjadi
     */

    @Override
    public void onKeyPresses(KeyEvent e) {
    }
}
