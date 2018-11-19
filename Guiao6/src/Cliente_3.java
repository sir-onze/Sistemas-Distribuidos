import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente_3 {

    public static void main(String args[]) throws IOException {
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        int port = 12345;
        Socket socket = new Socket(addr,port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

        String user;
        String response;

        while((user = systemIn.readLine())!=null){
                out.println(user);
                out.flush();
                response = in.readLine();
                System.out.println("Servidor :" +response);
        }
        System.out.println(systemIn.readLine());
        socket.shutdownOutput();
        socket.shutdownInput();
        socket.close();

    }

}
