import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundeBuffer {
    private int[] values; //LIFO Last in First out
    private int poswrite;


    public BoundeBuffer(int n){
        this.values = new int[n];
        poswrite = 0;
    }

    public synchronized void put(int v) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition vazio  = lock.newCondition();
        Condition cheio = lock.newCondition();

        lock.lock();

        try {
            while(this.poswrite==values.length-1){
                vazio.await();
            }
        }
        finally {
            lock.unlock();
        }

    }

    public synchronized int get() throws InterruptedException{

    }
}
