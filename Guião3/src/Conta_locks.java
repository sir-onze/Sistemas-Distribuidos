import java.util.concurrent.locks.ReentrantLock;

/* Classe conta a usar locks, alternativa aos metodos syncronized */
public class Conta_locks {

    private ReentrantLock locks;
    private double saldo;
    private int id;

    public Conta_locks(double saldo,int id){
        this.saldo = saldo;
        this.id=id;
        locks = new ReentrantLock();
    }

    public void depositar(double valor){
        lock();
        this.saldo+=valor;
        unlock();
    }

    public void levantar(double valor){
        if(this.saldo>valor){
            lock();
            this.saldo-=valor;
            unlock();
        }
    }

    public double consultar(){
        lock();
        double r = this.saldo;
        unlock();
        return r;
    }

    public void lock(){ locks.lock();}

    public void unlock(){ locks.unlock();}

}
