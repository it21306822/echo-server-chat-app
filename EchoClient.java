import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        // Server address and port
        //String serverAddress = "3.95.162.106";
         String serverAddress = "localhost"; 
        int port = 5770;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to echo server on " + serverAddress + ":" + port);
            String userInputLine;

            // Continuously read input from the user and send to the server
            while ((userInputLine = userInput.readLine()) != null) {
                // Send input to the server
                out.println(userInputLine);

                // Read the echoed response from the server
                String serverResponse = in.readLine();
                System.out.println("Echo from server: " + serverResponse);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverAddress);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverAddress);
            e.printStackTrace();
        }
    }
}
