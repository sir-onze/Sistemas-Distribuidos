public class Main {

    public static void main(String args[]) throws InterruptedException {

        /*int n=2;
        Thread [] t = new Thread[n];
        Banco b = new Banco(2);

        t[0] = new Thread(new Cliente1(b));
        t[1] = new Thread(new Cliente2(b));

        t[0].start();
        t[1].start();

        t[0].join();
        t[1].join();*/

        // ex2

        int n=2;
        Thread [] t = new Thread[2];
        Banco b = new Banco(2);
        b.depositar(0,1000);

        t[0]= new Thread(new Cliente4(b));
        t[1]=new Thread(new Cliente3(b));

        t[0].start();
        t[1].start();
        t[0].join();
        t[1].join();

        b.consultar(0);
        b.consultar(1);

    }

}
