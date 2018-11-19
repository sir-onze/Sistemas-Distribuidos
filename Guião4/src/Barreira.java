
public class Barreira {
    private int maxElem;
    private int counterElem;
    private int counterEtapa;

    public Barreira (int maxElem){
        this.maxElem=maxElem;
        this.counterElem=0;
        this.counterEtapa=0;
    }

    // necessario etapas, para garantir que o programa sabe que etapa estamos a tratar;

    public synchronized void esperar() throws InterruptedException {
        int myId=++this.counterElem;
        //guardar a etapa em que me encontro
        int myEtaps=this.counterEtapa;

        while (this.counterElem<this.maxElem && myEtaps==counterEtapa){
               this.wait();
        }

        // quando chegarem todas do grupo, vamos acordar as outras para que elas avancem
        if(myId==this.maxElem) {
            this.notifyAll();
            this.counterElem = 0;
            this.counterEtapa++;
        }
    }


}