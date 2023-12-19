import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LevelOne extends State {
    private int time = 100;
    private Car car = new Car();
    private Lion lion1 = new Lion(-300, 14); // origin dan kecepatan
    private Lion lion2 = new Lion(-615, 14);
    private Lion lion3 = new Lion(-930, 14);
    private Death death1 = new Death(-800, 10);
    private Death death2 = new Death(-300, 10);
    private ExtraTime time1 = new ExtraTime(-100, 20);
    private ExtraTime time2 = new ExtraTime(-400, 30);
    private FinishLine finishLine = new FinishLine(10, -6000);
    private Road road = new Road(10);
    private boolean finishStage = false;
    
    public List<Lion> lionList = new ArrayList<>();
    public List<Death> DeathList = new ArrayList<>();
    public List<ExtraTime> TimeList = new ArrayList<>();

    private int count = 0;

    @Override
    public void update(Graphics graphics) {

        if (count == 0) {
            lionList.add(lion1);
            lionList.add(lion2);
            lionList.add(lion3);
            DeathList.add(death1);
            DeathList.add(death2);
            TimeList.add(time1);
            TimeList.add(time2);
            Resources.welcomeTone.stop();
            Resources.carMoving.loop();
        }
        count++;

        //Reduce time
        if (count % 10 == 0 && !finishStage)
            time--;

        //Draw picture
        graphics.drawImage(Resources.roadbg, 0, 0, 1008, 567, null);
              
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);

        graphics.drawImage(Resources.finishLineImage, finishLine.x, finishLine.y, null);

        graphics.drawImage(Resources.playerCar, car.x, car.y, car.width, car.height, null);

        //Draw Lion 
        for (int i = 0; i < lionList.size(); i++) {
            lionList.get(i).updatePos();
            if (lionList.get(i).hidden == false)
                graphics.drawImage(Resources.enemyCar1, lionList.get(i).x, lionList.get(i).y, lionList.get(i).height, lionList.get(i).width, null);
        }
        
        //Draw Death
        for (int i = 0; i < DeathList.size(); i++) {
            DeathList.get(i).updatePos();
            if (DeathList.get(i).hidden == false)
                graphics.drawImage(Resources.death, DeathList.get(i).x, DeathList.get(i).y, DeathList.get(i).height, DeathList.get(i).width, null);
        }
        
        //Draw Extra time
        for (int i = 0; i < TimeList.size(); i++) {
            TimeList.get(i).updatePos();
            if (TimeList.get(i).hidden == false)
                graphics.drawImage(Resources.time, TimeList.get(i).x, TimeList.get(i).y, TimeList.get(i).height, TimeList.get(i).width, null);
        }

        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("LEVEL - 1", 240, 30);

        //Time, Play Pause, Mute button
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 755, 30);
            graphics.drawImage(Resources.playPause, 950, 10, 40, 40, null);
            graphics.drawImage(Resources.muteUnmute, 950, 60, 40, 40, null);
        }

        //CODE TO CHECK WHEATHER CAR REACHED FINISH LINE OR NOT
        if (finishLine.checkIntersection(car)) {
            finishStage = true;
            Resources.carMoving.stop();
            Resources.finishTone.play(); // lagu finish
            finishLine.yVel = 0;
            for (int i = 0; i < lionList.size(); i++) {
                lionList.get(i).hidden = true;
                lionList.get(i).yVel = 0;
                          }
            for (int i = 0; i < DeathList.size(); i++) {
            	DeathList.get(i).yVel = 0;
                DeathList.get(i).hidden = true;
            }
            for (int i = 0; i < TimeList.size(); i++) {
            	TimeList.get(i).yVel = 0;
                TimeList.get(i).hidden = true;
            }
            car.xVel = 0;
            car.yVel = -25; // mobil maju diperlambat
            road.yVel = 0;
        }

        //Move to Level Two
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToLevelTwo();

        //Update position
        road.updatePos();
        finishLine.updatePos();
        car.updatePos();

        //Check intersection car and lion
        for (int i = 0; i < lionList.size(); i++) {
            // intersects
            if ((lionList.get(i).hidden == false && car.checkIntersection(lionList.get(i)) && !finishStage)) {
                lionList.get(i).hidden = true; // lion di hide
                Resources.carCrash.play(); // sound crash
                if (GamePanel.muteUnmute) { 
                	Resources.carCrash.stop();
                }

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);

                time -= 5;
            }

        }
        
      //Cek intersection car and death
        for (int i = 0; i < DeathList.size(); i++) {
            if ((DeathList.get(i).hidden == false && car.checkIntersection(DeathList.get(i)) && !finishStage )) {
                DeathList.get(i).hidden = true;
                Resources.carCrash.play();
                if (GamePanel.muteUnmute) {
                	Resources.carCrash.stop();
                }

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
              
                GamePanel.currentState = new GameOverState();
            }
            else if (time < 0) {
            	GamePanel.currentState = new GameOverState();
            }

        }
        
        //Check intersection car and time
        for (int i = 0; i < TimeList.size(); i++) {
            if ((TimeList.get(i).hidden == false && car.checkIntersection(TimeList.get(i)) && !finishStage)) {
                TimeList.get(i).hidden = true;

                time += 5; // time nambah
            }
        }
    }
   
    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);
        Elements.muteUnmute(e);

    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e, car);
    }
}