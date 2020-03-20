package exo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(6020); // création du socket
        System.out.println("START");
        Socket soc = s.accept(); // lancement écoute du socket
        BufferedReader ins = new BufferedReader(
                new InputStreamReader(soc.getInputStream()) );
        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(soc.getOutputStream())), true);

        boolean stop = false;
        String messageRecu;
        while (!stop) {
            messageRecu = ins.readLine();

            if (messageRecu.equals("END")) break;
            System.out.println(messageRecu);

            outs.println(" Reçu :" + messageRecu);
        }

        ins.close();
        outs.close();
        soc.close();
    }
}