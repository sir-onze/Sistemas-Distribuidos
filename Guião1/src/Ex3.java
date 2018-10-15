public class Ex3 implements Runnable {

    public static Counter c;
    public int t;

    public Ex3(){
        c = new Counter();
    }

    public static void main(String[] args){

        int k=90;

        Thread [] t = new Thread[10];

        //criar as threads
        for(int i=0;i<10;i++)
            t[i] = new Thread(new Ex3());

        // iniciar as threads
        for(int i=0;i<10;i++)
            t[i].start();

        // esperar pelas malucas
        for (int i=0;i<10;i++)
            try{
                t[i].join();
            }
            catch (InterruptedException e){

            }
        System.out.println("Sou a main e incrementei:");
        System.out.println(c.get_conta());

    }


    public void run() {
        for (int i = 0; i < 90; i++){
            //System.out.println(i);
            c.incrementa();
            //System.out.println("Nao sou a main");
            //System.out.println(conta.get_conta());
        }
    }


}

