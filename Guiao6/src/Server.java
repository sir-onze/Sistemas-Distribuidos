import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args []) throws IOException {
        ServerSocket sSock = new ServerSocket(12345);
        String s = "";

        while(true){
            Socket clSock = sSock.accept(); //
            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            PrintWriter out = new PrintWriter(clSock.getOutputStream());

            while (!s.equals("exit")){
                    s=in.readLine();
                    out.println(s);
                    out.flush();
            }
            s="";
            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        }

    }

}
