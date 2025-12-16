import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true
            );

            Scanner sc = new Scanner(System.in);

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println("Message: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            while (true) {
                String message = sc.nextLine();
                writer.println(message);
            }

        } catch (IOException e) {
            System.out.println("Unable to connect to server.");
        }
    }
}
