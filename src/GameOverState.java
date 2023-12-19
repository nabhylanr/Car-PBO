import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class GameOverState extends State {
    // Array yang berisi pilihan yang ditampilkan saat game over
    private Object[] options = {"Play Again", "Exit",};
    // Variabel yang menyimpan pilihan yang dipilih oleh user
    private int n;
    @Override
    public void update(Graphics graphics){
        // Stop music saat gameover
        Resources.carMoving.stop();
        // Memulai pemutaran musik game over
        Resources.gameOverTone.loop();

        // Dialog box
        n = JOptionPane.showOptionDialog(Main.frame,
                "You Lose!",
                "Game Over",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,
                options,
                options[1]);

        // Jika user memilih "play again", maka kembali ke menu utama
        if (n == 0)
            GamePanel.currentState = new MenuState();
        // Jika user memilih "exit", maka program akan keluar
        else
            System.exit(0);
    }

    @Override
    public void onMousepressed(MouseEvent e) {
        // Method kosong
    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        // Method kosong
    }
}

