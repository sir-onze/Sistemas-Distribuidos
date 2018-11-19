import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ex3 {

    ReentrantLock lock;
    int readers;
    private Condition readersCond;
    private Condition writersCond;
    int writerRequest;
    int readersRequest;
    int MAXPRIORITY=3;
    int readersPriority;
    int writersPriority;
    int writer;

    public ex3(){
        lock = new ReentrantLock();
        // construtores (...)
    }

    public void readLock() {
        lock.lock();

        try{
            readersRequest++;
            while (writer==1 || writerRequest>0 && readersPriority>= MAXPRIORITY)
                readersCond.wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void writeLock(){
        lock.lock();

        try{
            writerRequest++;
            while (readers!=0 || readersRequest >0 && writersPriority>=MAXPRIORITY)
                writersCond.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}
