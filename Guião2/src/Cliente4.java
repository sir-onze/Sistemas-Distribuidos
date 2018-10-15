public class Cliente4 implements Runnable{

    private Banco b;

    public Cliente4(Banco b){
        this.b =  b;
    }

    @Override
    public void run() {
        this.b.depositar(1,1000);
    }
}
