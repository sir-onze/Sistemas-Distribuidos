
public class Produtor implements Runnable{
    // guiao 4
    private BoundedBuffer b;

    public Produtor(BoundedBuffer b){
        this.b=b;
    }

    public void run() {
        int i=0;
        while (i<20) {
            try {
                b.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
