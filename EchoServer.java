import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        // Set the port number
        int port = 5770;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            // Continuously listen for client connections
            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams for the socket
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine;
                // Echo messages back to the client
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println(inputLine);  // Echo back to the client
                }

                // Close client connection
                clientSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
    }
}
