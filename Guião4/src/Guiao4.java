
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

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time in ms: " + (endTime - startTime));


        /*
        // descobrir o numero otimo de produtores e consumidores

        int N=10;
        Thread t [] = new Thread[N];
        int tc =500;
        int tp=500;
        int total_ops=100;
        int P;
        int C;

        for (P=1;P<=9;P++){

            C=N-P;

        for(int i=0;i<P;i++){
            //criar os produtores
             }

             for(int i=0;i<C;i++){
                //crirar os consumidores
            }
            //iniciar o cronometro
            long startTime = System.currentTimeMillis();

            for(int i=0;i<P;i++){
                //iniciar os produtores
            }

             for(int i=0;i<C;i++){
                //iniciar os consumidores
                 }

            for(int i=0;i<P;i++){
                //esperar pelos produtores
            }
            for(int i=0;i<C;i++){
                //esperar pelos consumidores
            }

            long endTime = System.currentTimeMillis();
        }
    }
    */
    }
}
