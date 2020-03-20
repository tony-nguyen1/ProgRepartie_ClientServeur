package exo1;

import java.io.*;
import java.net.Socket;

public class Client {
    static final int port = 6020;

    public static void main(String[] args) throws Exception {
        Socket s = new Socket(args[0], port); // création du socket
        System.out.println("START");

        BufferedReader ins = new BufferedReader(
                new InputStreamReader(System.in) );
        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream())), true);
        BufferedReader reponse = new BufferedReader(
                new InputStreamReader(s.getInputStream()) );

        String messageAEnvoye;
        while (true) {
            messageAEnvoye = ins.readLine(); //lecture de l'entrée de l'utilisateur
            outs.println(messageAEnvoye); //envoie

            System.out.println(reponse.readLine());

            if (messageAEnvoye.equals("END")) { break; }
        }

        ins.close();
        outs.close();
        s.close();
    }
}
