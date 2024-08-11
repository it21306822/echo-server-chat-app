import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 65432; // Port to listen on
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message); // Echo the message back to the client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
