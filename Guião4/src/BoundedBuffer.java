public class BoundedBuffer {

    //Guião 4

    private int[] values; //LIFO Last in First out
    private int poswrite;

    public BoundedBuffer(int n){
        this.values = new int[n];
        poswrite = 0;

    }

    public synchronized void put(int v) throws InterruptedException {
        while(this.poswrite==values.length-1){
            wait();
        }
        this.values[poswrite]=v;
        System.out.println(this.values[poswrite]);
        poswrite++;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {

        while (this.poswrite==0){
            wait();
        }
        int r = values[poswrite];
        poswrite--;
        notifyAll();
        return r;
    }

}
