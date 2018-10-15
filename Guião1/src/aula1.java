public class aula1 implements Runnable {
    public int j;

    public aula1(int x) {
        j = x;
    }

    public void run() {
        for (int i = 0; i < j; i++)
            System.out.println(i);
    }


    public static void main(String[] args){
        int n = 10;
        int k = 90;
        Thread arrete [] = new Thread[n];

        //criar threads
        for(int i=0;i<n;i++)
            arrete[i] = new Thread(new aula1(k));

        //startar as threads
        for(int i=0;i<n;i++)
            arrete[i].start();

        //esperar pelas threads

        for (int i = 0; i < n; i++) {
            try {
                arrete[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //start -> join <- new Thread
    }
}
