package exo2;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("Duplicates")
public class Serveur {
    private static ExecutorService unService;

    public static void main(String[] args) throws IOException {
        //pour créer des threads dédié à la comm et laisser le main avec le socket principale continuer à écouter
        unService = Executors.newFixedThreadPool(5);

        ServerSocket s = new ServerSocket(6020); // création du socket d'écoute

        System.out.println("START");
        while (true) {
            unService.execute(new Thread(new Connexion(s.accept()))); //dès qu'un client se connecte, on l'accepte (avec s.accept) dans un nouveau Thread
        }
    }
}