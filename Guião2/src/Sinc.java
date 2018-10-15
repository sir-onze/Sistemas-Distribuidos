import java.io.*;
import java.lang.*;

public class Sinc implements Runnable {

    public Counter conta;

    public Sinc (Counter c){conta=c;}

    public void run() {
        // se metermos lock aqui tornamos o programa sequencial, nao faz sentido usar threads
        for (int i = 0; i < 90; i++){
            // synchronized(counter){ (alternativa a por o metodo sinc)
            conta.incrementa();
            //}
        }
    }

    public static void main(String args[]) throws InterruptedException {

        int k = 90;
        Thread [] t = new Thread[20];
        // criada aqui para só ter um contador para as threads
        Counter c = new Counter();

        // criar as threads
        for(int i=0;i<20;i++)
            t[i]=new Thread(new Ex2(c));

        //iniciar as threads
        for(int i=0;i<20;i++)
            t[i].start();

        // esperar que executem
        for(int i = 0;i<20;i++){
            t[i].join();
        }
        System.out.println(c.get_conta());
    }
}
