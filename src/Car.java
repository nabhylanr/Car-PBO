public class Car extends Elements {
   
    public Car() {
        //  koordinat y mobil.
        this.y = 530;
        //  koordinat x mobil.
        this.x = 700;
        //  kecepatan x mobil.
        this.xVel = 0;
        // kecepatan y mobil.
        this.yVel = 0;
        // Lebar mobil.
        this.width = 100;
        // Tinggi mobil.
        this.height = 151;
    }

   // Check bound mobil - road 
   // mobil di antara 336 dan 636 sesuai size layar

    public void checkBound() {
        
        if (this.x <= 336) {
            this.x = 336;
        }
        
        else if (this.x >= 636) {
            this.x = 636;
        }

       
    }
}
