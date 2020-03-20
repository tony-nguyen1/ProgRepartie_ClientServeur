package exo2;

import java.io.*;
import java.net.Socket;

public class Connexion implements Runnable {
    private Socket socket;
    private String messageRecu;
    private BufferedReader ins;
    private PrintWriter outs;

    public Connexion(Socket socket) {
        this.socket = socket;

        try {
            ins = new BufferedReader(new InputStreamReader(socket.getInputStream()) ); //lecture dans le socket
            outs = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);//écriture dans le socket
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connection");
    }

    @Override
    public void run() {
        while (true) {
            try {
                messageRecu = ins.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(messageRecu);

            outs.println(" Reçu :" + messageRecu);
            if (messageRecu.equals("END")) break;
        }

        // fermeture des comms + socket
        try {
            ins.close();
            outs.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
