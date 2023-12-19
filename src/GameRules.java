import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameRules extends State {
    // Variabel yang menyimpan hitungan
    private int count = 0;

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Resources.Gameplay, 0, 0, 1008, 567, null);
        graphics.setColor(Color.WHITE);

        Font customFont = Resources.gulfsDisplay.deriveFont(Font.PLAIN, 30);
        graphics.setFont(customFont);

        // Jika hitungan bernilai 0, maka musik main menu dihentikan dan musik welcome dimulai
        if (count == 0) {
            Resources.mainMenuTone.stop();
            Resources.welcomeTone.loop();
            // Menaikkan hitungan menjadi 1
            count++;
        }

        graphics.drawString("Back", 900, 530);
    }

    // Tombol Back
    @Override
    public void onMousepressed(MouseEvent e) {
        // Membuat objek Rectangle sesuai posisi dan ukuran tombol "BACK"
        Rectangle r = new Rectangle(880, 510, 130, 40);
        // tombol "BACK", maka kembali ke menu utama
        if (r.contains(e.getX(),e.getY())){
            GamePanel.currentState = new MenuState();
        }
    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        // Method kosong
    }
}
