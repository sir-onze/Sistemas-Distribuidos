public class Counter {

    public int contador;

    public Counter(){
        this.contador=0;
    }

    public synchronized void  incrementa(){
        contador++;
    }

    public int get_conta(){ return contador;}
}
