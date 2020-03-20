package exo2;

import java.io.*;
import java.net.Socket;
@SuppressWarnings("Duplicates")
public class Client {
    static final int port = 6020;

    public static void main(String[] args) throws Exception {
        System.out.println("START");

        Socket s = new Socket(args[0], port); // création du socket

        //entrée standard
        BufferedReader ins = new BufferedReader(
                new InputStreamReader(System.in) );
        //ecriture dans le socket
        PrintWriter outs = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(s.getOutputStream())), true);
        //lecture dans le socket
        BufferedReader reponse = new BufferedReader(
                new InputStreamReader(s.getInputStream()) );

        String messageAEnvoye;
        while (true) {
            messageAEnvoye = ins.readLine(); //lecture de l'entrée de l'utilisateur
            outs.println(messageAEnvoye); //envoie


            if (messageAEnvoye.equals("END")) {
                System.out.println("Disconnecting");
                outs.println("Disconnecting");
                break;
            }
            System.out.println(reponse.readLine()); //lecture + affichage de la réponse
        }

        ins.close();
        outs.close();
        s.close();
    }
}
