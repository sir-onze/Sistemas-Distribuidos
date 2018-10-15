public class NovoBanco  {

    private Conta contas [];

    public NovoBanco(int n){ this.contas= new Conta[n]; }

    public synchronized void depositar(int conta, double valor){ this.contas[conta].depositar(valor); }

    public synchronized void levantar(int conta, double valor){ this.contas[conta].levantar(valor); }

    public synchronized void consultar(int conta){ this.contas[conta].consultar(); }

    public synchronized void tranferir (int origem,int destino, double valor){

        if(contas[origem].consultar()>valor){
            contas[origem].levantar(valor);
            contas[destino].depositar(valor);
        }
        else System.out.println("No dollar no party");
    }

}
