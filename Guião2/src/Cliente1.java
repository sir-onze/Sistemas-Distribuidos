

public class Cliente1 implements Runnable {

    private Banco b;
    public Cliente1(){ b= new Banco(20);}

    @Override
    public void run() {

        for(int i=0;i<1000;i++) b.depositar(0,5);
    }
}
