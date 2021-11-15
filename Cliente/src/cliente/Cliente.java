package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    
    public static void main(String[] args) {
        String wComando;
        Boolean wConectado = true;
        
        try {
            clientSocket = new Socket("192.168.0.104", 8899);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            System.out.println("Conectado");
                
            while (wConectado) {
                Scanner console = new Scanner(System.in);
                wComando = console.nextLine();

                if (wComando.equals("/exit")) {
                    return;
                };

                System.out.println(sendMessage(wComando));
            }
            
            stopConnection();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String sendMessage(String msg) {
        try {
            out.println(msg);
            String resp = in.readLine();
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "erro";
        }
    }

    public static void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
