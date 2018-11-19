public class main_3 {


    public static void main(String args[]){
        int N=10;

        Thread t [] = new Thread[N];
        Barreira b = new Barreira(N);



        for(int i=0;i<N;i++){
            t[i] = new Thread(new MyThread(b));
        }


    }

}
