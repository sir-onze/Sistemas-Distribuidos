import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/*Guiao 3 */

public class Banco_locks {
    private HashMap<Integer,Conta_locks> contas;
    private ReentrantLock lockBanco;

    public Banco_locks(){
        this.contas = new HashMap<Integer, Conta_locks>();
        this.lockBanco = new ReentrantLock();
    }

    public int CriarConta(double saldoInicial){

    lock();
    int x =this.contas.size()+1;
    Conta_locks c = new Conta_locks(saldoInicial,x);
    contas.put(x,c);
    unlock();

    return x;

    }

    public double fecharConta(int id) throws ContaInvalida{
        Conta_locks c;
        double saldo=0;

        lock();

        if (!contas.containsKey(id)){
            unlock();
            throw new ContaInvalida();
        }

        else{
            c = this.contas.get(id);
            c.lock();
            saldo = c.consultar();
            this.contas.remove(id);
            c.unlock();
            unlock();
            return saldo;
        }
    }

    public void transferir(int c_origem,int c_destino,double valor) throws ContaInvalida,SaldoInsuficiente{

        Conta_locks co = this.contas.get(c_origem);
        Conta_locks cd = this.contas.get(c_destino);
        this.contas.get(c_origem).lock();
        this.contas.get(c_destino).lock();

        if(co.consultar()<valor) throw new SaldoInsuficiente();

        else{
            if(this.contas.containsKey(co) && this.contas.containsKey(cd)){
                this.contas.get(c_origem).levantar(valor);
                this.contas.get(c_destino).depositar(valor);
            }
            else throw  new ContaInvalida();

        }
        this.contas.get(c_origem).unlock();
        this.contas.get(c_destino).unlock();
    }

    public double total(int accounts[]){
        this.lock();
        double r=0;
        for(int i=0;i<accounts.length;i++){
            contas.get(accounts[i]).lock();
        }
        this.unlock();

        for (int i=0;i<accounts.length;i++){
            r+=this.contas.get(accounts[i]).consultar();
            this.contas.get(accounts[i]).unlock();
        }
        return r;
    }


    //lock do banco -> lock das contas que queremos usar -> unlock do bamco

    public void lock(){this.lockBanco.lock();}

    public void unlock(){this.lockBanco.unlock();}
}

// aulas tp https://www.dropbox.com/sh/axlp4deosshb70t/AADcpQxX__49o70XVNuZ79mWa?dl=0