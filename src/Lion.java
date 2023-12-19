import java.util.Random;
	
public class Lion extends Elements{
	// Atribut untuk menggenerate angka random
    Random random = new Random();
   
    //konstruktor
    public Lion(int origin,int vel){
        this.setXRandom(336, 636);
        this.y = origin;
        this.yVel = vel;
        this.width = 80;
        this.height = 80;
    }

   // batas layar
    public void checkBound(){
        if(this.y > 567) {
            this.hidden = false;
            this.y = -400;
            this.setXRandom(336, 636);
        }


    }
}