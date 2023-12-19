import java.util.Random;



public class ExtraTime extends Elements {
    Random random = new Random();

    // Konstruktor
    public ExtraTime(int origin, int vel){
        // x antara 336 dan 636
        this.setXRandom(336, 636);
        // y sesuai origin
        this.y = origin;
        //  kecepatan y 
        this.yVel = 5;
        // lebar objek
        this.width = 50;
        // tinggi objek
        this.height = 50;
    }

    //Cek batas layar 
    public void checkBound(){
        
        if (this.y > 567){
            //  posisi x secara acak antara 336 dan 636
            this.setXRandom(336, 636);
            // posisi y sebesar -400.
            this.y = -400;
            // Menampilkan elemen tambahan waktu kembali.
            this.hidden = false;
        }
    }
}
