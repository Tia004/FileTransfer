import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        JFrame window = new JFrame("Finestra Java Swing");

        // Impostazione delle dimensioni della finestra
        window.setSize(600, 500);

        // Impostazione del layout della finestra
        window.setLayout(new BorderLayout());

        // Campo di testo per visualizzare l'IP del proprio computer
        JTextField mioIPTextField = new JTextField("Il mio IP: " + getMyIP());
        mioIPTextField.setEditable(false);
        window.add(mioIPTextField, BorderLayout.NORTH);

        // Campo di testo per inserire l'IP della persona con cui connettersi
        JTextField ipDestinatarioTextField = new JTextField();
        window.add(ipDestinatarioTextField, BorderLayout.CENTER);

        // Impostazione del comportamento di chiusura della finestra
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendere la finestra visibile
        window.setVisible(true);
    }

    // Metodo per ottenere l'indirizzo IP del proprio computer (esempio, potrebbe non funzionare su tutte le reti)
    private static String getMyIP() {
        try {
            return java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
            return "Errore nell'ottenere l'IP";
        }
    }
}