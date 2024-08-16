import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String host = "192.168.8.138"; // IP address of the server
        int port = 5770; // Port to connect to

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Received echo: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
