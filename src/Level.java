import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;



public class Level extends State {
	  private  int count = 0;
	
	  @Override
	  public void update(Graphics graphics) {
	    // play mainkan suara menu utama dan berhentikan suara lainnya
	    if (count == 0) {
	      Resources.mainMenuTone.loop();
	      Resources.gameOverTone.stop();
	      Resources.welcomeTone.stop();
	      count++;
	    }
	
	    // Text display
	    graphics.drawImage(Resources.Level, 0, 0, 1008, 567, null);
	    graphics.setFont(new Font("Canva Sans", Font.BOLD, 25));
	    graphics.setColor(Color.WHITE);
	    graphics.drawString("Easy", 460, 320);
	    graphics.drawString("Medium", 437, 355);
	    graphics.drawString("Hard", 458, 390);
	    graphics.drawString("Back", 457, 425);
	  }
	
      @Override
	  public void onMousepressed(MouseEvent e) {
	    // Buat objek rectangle untuk masing-masing menu

		Rectangle r1 = new Rectangle(420, 300, 180, 25); // easy
		Rectangle r2 = new Rectangle(420, 340, 180, 25); // medium
        Rectangle r3 = new Rectangle(420, 370, 180, 25); // hard
        Rectangle r4 = new Rectangle(420, 410, 180, 25); // back
        
	    // Cek apakah mouse diklik di salah satu rectangle
	    if(r3.contains(e.getX(), e.getY())) {
	        // tombol hard -> level 3
	        GamePanel.currentState = new WelcomeToLevelThree();
	    } 
        else if (r2.contains(e.getX(), e.getY())) {
	        // tombol medium -> level 2
	        GamePanel.currentState = new WelcomeToLevelTwo();
	    }
		
		else if (r1.contains(e.getX(), e.getY())) {
	        // tombol easy -> level 1
	        GamePanel.currentState = new WelcomeToLevelOne();
		}

        else if (r4.contains(e.getX(), e.getY())) {
	        // back -> menu
	        GamePanel.currentState = new MenuState();
	    } 
	

	  }

    @Override
    public void onKeyPresses(KeyEvent e) {
    }



}
