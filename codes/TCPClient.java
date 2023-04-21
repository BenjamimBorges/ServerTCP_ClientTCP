import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int serverPort = 7896;
        try {
            Socket clientSocket = new Socket(serverName, serverPort);
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while (!line.equals("exit")) {
                System.out.print("Cliente: ");
                line = br.readLine();
                out.writeUTF(line);
                String response = in.readUTF();
                System.out.println("Server: " + response);
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
