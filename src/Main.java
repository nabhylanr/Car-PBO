import javax.swing.*; // import kelas swing


public class Main {
  // deklarasi frame sebagai objek JFrame
  public static JFrame frame;

  public static void main(String[] args) {
    // judul game 
    frame = new JFrame("Car: The Adventure Begins");
    // program berhenti jika ditutup
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // membuat objek panel sebagai GamePanel
    GamePanel panel = new GamePanel();
    // mengatur panel sebagai content pane dari frame
    frame.setContentPane(panel);
    // mengatur agar frame tidak bisa diubah ukurannya
    frame.setResizable(false);
    // menyesuaikan ukuran frame sesuai dengan komponen di dalamnya
    frame.pack();
    // menampilkan frame
    frame.setVisible(true);
  }
}
