/**
 * Kelas yang menangani jalan yang akan ditampilkan dalam permainan.
 */
public class Road extends Elements {
	  public Road(int vel) {
		this.width = 1008;  // Lebar road harusnya
        this.height = 567;  // Tinggi road harusnya
	    this.x = 336;
	    this.y = -9000;
	    this.yVel = vel;
	  }
	
	  /**
	   * Metode untuk memeriksa apakah jalan sudah melewati batas layar.
	   * Jika sudah melewati batas, maka jalan akan dipindah kembali ke atas layar.
	   */
	  public void checkBound() {
	    if (this.y > -10) {
	      this.y = -9000;
	    }
	  } 
}