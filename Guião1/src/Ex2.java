public class Ex2 implements Runnable {

    // varaiveis das threads

    public Counter conta;

    public Ex2(Counter c){
        conta = c;
    }


    public void run(){
        for (int i = 0; i < 90; i++){
            //System.out.println(i);
            conta.incrementa();
            //System.out.println(conta.get_conta());
        }

    }

    public static void main(String args[]) throws InterruptedException {

        int k = 90;
        Thread [] t = new Thread[10];
        // criada aqui para só ter um contador para as threads
        Counter c = new Counter();

        // criar as threads
        for(int i=0;i<10;i++)
            t[i]=new Thread(new Ex2(c));

        //iniciar as threads
        for(int i=0;i<10;i++)
            t[i].start();

        // esperar que executem
        for(int i = 0;i<10;i++){
            t[i].join();
        }
        System.out.println(c.get_conta());
    }
}
