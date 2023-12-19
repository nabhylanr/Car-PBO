import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;


public class MenuState extends State {
	  private  int count=0;
	
	  @Override
	  public void update(Graphics graphics) {
	    // Jika pertama kali update dipanggil, play suara menu utama dan berhentikan suara lainnya
	    if (count == 0) { 
	      	Resources.mainMenuTone.loop();
			Resources.juaraSatu.stop();
	      	Resources.gameOverTone.stop();
	      	Resources.welcomeTone.stop();
	      	count++;
	    }
	
	    // Menampilkan  gambar latar belakang dan teks
	    graphics.drawImage(Resources.welcomeToGameImage, 0, 0, 1008, 567, null);
	    graphics.setFont(new Font("Canva Sans", Font.BOLD, 25));
	    graphics.setColor(Color.WHITE);
	    graphics.drawString("Rules", 460, 320);
	    graphics.drawString("Start Game", 425, 355);
	    graphics.drawString("Exit", 465, 390);
	    graphics.drawString("Control", 440, 425);
	  }
	
      @Override
	  public void onMousepressed(MouseEvent e) {
	    // Buat objek rectangle untuk masing-masing menu
	    Rectangle r1 = new Rectangle(420, 300, 170, 25); // rules
        Rectangle r2 = new Rectangle(420, 340, 170, 25); // start
        Rectangle r3 = new Rectangle(420, 370, 170, 25); // exit
        Rectangle r4 = new Rectangle(420, 410, 170, 25); // settings
	
	    // Cek apakah mouse diklik di salah satu rectangle
	    if(r3.contains(e.getX(), e.getY())) {
	        // Tutup aplikasi jika tombol exit diklik
	        Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
	    } 
        else if (r2.contains(e.getX(), e.getY())) {
	        // Pindah ke WelcomeToStage1 jika tombol start diklik
	        GamePanel.currentState = new Level();
	    }
        else if (r1.contains(e.getX(), e.getY())) {
	        // Pindah ke Rules jika tombol start diklik
	        GamePanel.currentState = new GameRules();
	    }
        else if (r4.contains(e.getX(), e.getY())) {
	        // Pindah ke Rules jika tombol start diklik
	        GamePanel.currentState = new Kontrol();
	    } 
	  }

    @Override
    public void onKeyPresses(KeyEvent e) {
    }



}

