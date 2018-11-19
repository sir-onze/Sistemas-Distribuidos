import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ex_3 {

    public static void main(String args[]) throws IOException {
        ServerSocket svs = new ServerSocket(12345);
        String s;
        int soma=0;
        int temp;
        int count=0;

        while (true){
            Socket sv = svs.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(sv.getInputStream()));
            PrintWriter out = new PrintWriter(sv.getOutputStream());

            while ((s=in.readLine())!=null && !s.equals("quit")){
                temp = Integer.parseInt(s);
                soma+=temp;
                count++;

                out.println("Soma intermedia"+soma);
                out.flush();
            }
            out.println(soma/count);
            out.flush();
            sv.shutdownInput();
            sv.shutdownOutput();
            sv.close();
        }
    }
}
