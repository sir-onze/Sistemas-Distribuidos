import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String args[]) throws IOException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        int port = 12345;
        Socket socket = new Socket(addr,port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer  = new PrintWriter(socket.getOutputStream());
        String s="a";
        String input="a";
        BufferedReader outline = new BufferedReader(new InputStreamReader(System.in));

        // leitura do teclado e depois leitura do socket


        while((input = outline.readLine())!=null && !input.equals("exit")) {
            writer.println(input);
            writer.flush();
            System.out.println("Cliente");
        }

        socket.shutdownOutput();
        socket.shutdownInput();
        socket.close();
    }
}
