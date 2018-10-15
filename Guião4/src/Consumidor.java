
public class Consumidor implements Runnable {
    //guiao 4
    private BoundedBuffer b;

    public Consumidor(BoundedBuffer b){
        this.b=b;
    }

    public void run() {

        for (int i=0;i<20;i++){
            try {
                b.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
