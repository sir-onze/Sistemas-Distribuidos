
public class Banco {
    private double conta[];

    public Banco(int n){
        conta = new double[n];
        for(int i=0;i<n;i++){
            conta[i]=0;
        }
    }

    public synchronized void depositar(int contas,double x){ conta[contas]+=x;}

    public synchronized void levantar(int contas,double x){ conta[contas]-=x;}

    public synchronized void consultar(int contas){ System.out.println(conta[contas]);}

    public synchronized void transferir ( int recebe, int deposita, double valor){

        if(conta[deposita]>valor){
            levantar(deposita,valor);
            depositar(recebe,valor);
        }
        else consultar(deposita);
    }

}
