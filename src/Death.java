import java.util.Random;

public class Death extends Elements {

  // buat objek random
  Random random = new Random();

  // constructor kelas Death
  public Death(int origin, int vel) {

    //posisi x antara 336 dan 636
    this.setXRandom(336, 636);
    // y sesuai origin
    this.y = origin;
    // kecepatan y
    this.yVel = 5;
    // lebar objek
    this.width = 50;
    // tinggi objek
    this.height = 50;
  }

  // method untuk mengecek batas objek
  public void checkBound() {
    // jika posisi y melebihi batas 567
    if (this.y > 567) {
      
      this.hidden = false;
      // mengatur posisi y menjadi -400
      this.y = -400;
      //  posisi x secara acak antara 336 sampai 636
      this.setXRandom(336, 636);
    }
  }
}
