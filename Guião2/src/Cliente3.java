public class Cliente3 implements Runnable {
    private Banco b;

    public Cliente3(Banco b){
        this.b =  b;
    }

    @Override
    public void run() {
        this.b.levantar(1,1000);
        //this.b.depositar(0,1000);
    }
}
