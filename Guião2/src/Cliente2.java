
public class Cliente2 implements Runnable {
    private Banco b;
    public Cliente2(){ b= new Banco(20);}

    @Override
    public void run() {

        for(int i=0;i<1000;i++) b.levantar(0,5);
    }

}
