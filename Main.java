import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inviare (i) o ricevere (r)? ");
        String choice = scanner.nextLine();
        if(choice.equals("i")){
            inviare();
        } else ricevere();
    }

    static void inviare() throws IOException {
        Socket s = new Socket("10.0.23.84", 557);
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        File file = new File("C:\\Users\\anton\\Desktop\\reteTrasporti.xml");
        output.write(Files.readAllBytes(file.toPath()));
        System.out.println("File inviato.");
    }

    static void ricevere() throws IOException {
        ServerSocket ss = new ServerSocket(557);
        Socket s = ss.accept();
        DataInputStream input = new DataInputStream(s.getInputStream());
        try(FileOutputStream stream = new FileOutputStream("ricevuto.xml")){
            stream.write(input.readAllBytes());
        }
        System.out.println("File ricevuto.");
    }
}
