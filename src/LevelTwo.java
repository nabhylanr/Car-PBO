import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class LevelTwo extends State {
    private int time=120;
    private Road road = new Road(11);
    private Car car = new Car();
    private FinishLine finishLine = new FinishLine(12,-8000);
    private Lion lion1 = new Lion(-650,15);
    private Lion lion2= new Lion(-1150,15);
    private Snake snake1 = new Snake(-400,15);
    private Snake snake2 = new Snake(-900,15);
    private Snake snake3 = new Snake(-1400,15);
    private Death death1 = new Death(-600, 10);
    private Death death2 = new Death(-300, 20);
    private ExtraTime time1 = new ExtraTime(-100, 20);
    private ExtraTime time2 = new ExtraTime(-400, 30);
    private int count=0;

    private List<Elements> list = new ArrayList<>();
    private List<Lion> lionArrayList = new ArrayList<>();
    private List<Snake> snakeArrayList = new ArrayList<>();
    public List<Death> DeathList = new ArrayList<>();
    public List<ExtraTime> TimeList = new ArrayList<>();
    
    private boolean finishStage=false;

    @Override
    public void update(Graphics graphics) {
        if (count == 0){
            Resources.welcomeTone.stop();
            Resources.mainMenuTone.stop();
            Resources.carMoving.loop();
        }

        lionArrayList.clear();
        snakeArrayList.clear();;
        DeathList.clear();
        TimeList.clear();
        list.clear();
        lionArrayList.add(lion1);
        lionArrayList.add(lion2);
        snakeArrayList.add(snake1);
        snakeArrayList.add(snake2);
        snakeArrayList.add(snake3);
        DeathList.add(death1);
        DeathList.add(death2);
        TimeList.add(time1);
        TimeList.add(time2);
        list.addAll(lionArrayList);
        list.addAll(snakeArrayList);
        list.addAll(DeathList);
        list.addAll(TimeList);
        list.addAll(DeathList);
        count++;

        //Reduce time
        if (count % 10 == 0 && !finishStage)
            time--;

        
        //CODE TO CHECK WHEATHER CAR REACHES FINISH LINE OR NOT
        if (finishLine.checkIntersection(car)){
            finishStage=true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finishLine.yVel=0;
            
            for (int i = 0 ; i <list.size();i++){
                list.get(i).hidden = true;
                list.get(i).yVel = 0;

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
            car.yVel = -25;
            road.yVel = 0;
            

        }

         //Check intersection of car with death
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
        
        //Check intersection of car with extratime
        for (int i = 0; i < TimeList.size(); i++) {
            if ((TimeList.get(i).hidden == false && car.checkIntersection(TimeList.get(i)) && !finishStage)) {
                TimeList.get(i).hidden = true;

                time += 7;
            }

        }

        //Draw images
        graphics.drawImage(Resources.roadbg, 0, 0, 1008, 567, null);
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);
        graphics.drawImage(Resources.finishLineImage,finishLine.x,finishLine.y, null);
        graphics.drawImage(Resources.playerCar, car.x, car.y, car.width, car.height, null);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("LEVEL - 2", 240, 30);

        //Time, PlayPause, Mute
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 755, 30);
            graphics.drawImage(Resources.playPause, 950, 10, 40, 40, null);
            graphics.drawImage(Resources.muteUnmute, 950, 60, 40, 40, null);
        }

        //Display lion
        for (int i = 0 ; i<lionArrayList.size();i++)
            if (!lionArrayList.get(i).hidden)
            graphics.drawImage(Resources.enemyCar1, lionArrayList.get(i).x, lionArrayList.get(i).y, lionArrayList.get(i).height, lionArrayList.get(i).width, null);

        //Display snake
        for (int i = 0 ;i<snakeArrayList.size();i++)
            if (!snakeArrayList.get(i).hidden)
            graphics.drawImage(Resources.enemyCar2, snakeArrayList.get(i).x, snakeArrayList.get(i).y, snakeArrayList.get(i).height, snakeArrayList.get(i).width, null);

        //Display death
        for (int i = 0; i < DeathList.size(); i++) {
            DeathList.get(i).updatePos();
            if (DeathList.get(i).hidden == false)
                graphics.drawImage(Resources.death, DeathList.get(i).x, DeathList.get(i).y, DeathList.get(i).height, DeathList.get(i).width, null);
        }
        
        //Display extratime
        for (int i = 0; i < TimeList.size(); i++) {
            TimeList.get(i).updatePos();
            if (TimeList.get(i).hidden == false)
                graphics.drawImage(Resources.time, TimeList.get(i).x, TimeList.get(i).y, TimeList.get(i).height, TimeList.get(i).width, null);
        }

        ////Check intersection of car with other elements
        for (int i = 0; i < list.size(); i++){
            if (car.checkIntersection(list.get(i))&&!list.get(i).hidden){
                time -= 7;
                
                if (!finishStage&&list.get(i) instanceof Death) // interesects with death (game over)
                    GamePanel.currentState=new GameOverState();
                else {
                    Resources.carCrash.play();
                    if (GamePanel.muteUnmute) {
                    	Resources.carCrash.stop();
                    }
                    list.get(i).hidden = true;
                }
                
                for (int j=0;j < 1000;j++){
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
                }
            }
            
        }

        // Win -> level 3
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToLevelThree();

        //Update Position
        road.updatePos();
        car.updatePos();
        finishLine.updatePos();
       for (int i = 0 ; i <list.size();i++)
       {
           list.get(i).updatePos();
       }

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);
        Elements.muteUnmute(e);

    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e,car);

}
}

