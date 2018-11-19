
public class Guiao4 {

    public static void main(String args[]) throws InterruptedException {


        // primeiro exercicio
        final long startTime = System.currentTimeMillis();

        BoundedBuffer b = new BoundedBuffer(10);

        Thread c = new Thread(new Consumidor(b));
        Thread p = new Thread(new Produtor(b));

        c.start();
        p.start();

        c.join();
        p.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time in ms: " + (endTime - startTime));


/*
        // descobrir o numero otimo de produtores e consumidores

        int N=10;
        int tc =500;
        int tp=500;
        int total_ops=100;
        int P;
        int C;

        for (P=1;P<=9;P++){

            C=N-P;
            Thread ps[]= new Thread[P];
            Thread cs[]= new Thread[C];
            BoundedBuffer b = new BoundedBuffer(N);

        for(int i=0;i<P;i++){
            ps[i] = new Thread(new Produtor(b));
             }

             for(int i=0;i<C;i++){
                 cs[i] = new Thread(new Produtor(b));
            }
            //iniciar o cronometro
            long startTime2 = System.currentTimeMillis();

            for(int i=0;i<P;i++){
                ps[i].start();
            }

             for(int i=0;i<C;i++){
                cs[i].start();
                 }

            for(int i=0;i<P;i++){
               ps[i].wait();
            }
            for(int i=0;i<C;i++){
                cs[i].wait();
            }

            endTime = System.currentTimeMillis()/1000;
        }
    }
*/
    }

}
