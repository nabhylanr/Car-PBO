public class FinishLine extends Elements {
   
    public FinishLine(int vel,int origin)
    {
       
        this.x = 336;
        this.y = origin;
        this.width = 400;
        this.height = 30;
       this.yVel = vel;
    }

    /**
     * Method yang tidak melakukan apa-apa, hanya digunakan untuk mengimplementasikan
     * method abstrak yang ada di kelas Elements.
     */
    @Override
    public void checkBound() {
        // kosong
    }
}

