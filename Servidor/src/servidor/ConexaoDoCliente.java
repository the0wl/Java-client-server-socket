package servidor;

import model.Funcoes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDoCliente extends Thread {
    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public ConexaoDoCliente(Socket socket) {
        //Mostra no console o cliente que se conectou
        System.out.println("Conectado: "+socket.getInetAddress() +":"+ socket.getPort() + " na porta local " + socket.getLocalPort());
        this.clientSocket = socket;
    }

    //Recebe os comandos do cliente e envia para as funções específicas
    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine = "";
            Funcoes f = new Funcoes();
           
            while ((inputLine = in.readLine()) != null) {
                switch(inputLine) {
                    case "/quem" -> out.println(f.barraQuem());
                    case "/data" -> out.println(f.barraData());
                    case "/ip" -> out.println(f.barraIP());
                    case "/mac" -> out.println(f.barraMAC());
                    case "/sys" -> out.println(f.barraSYS());
                    case "/dev" -> out.println(f.barraDev());
                    case "/info" -> out.println(f.barraInfo());
                    case "/dolar" -> out.println(f.barraDolar());
                    case "/trends" -> out.println(f.barraTrends());
                    default -> out.println("Comando '"+inputLine+"' não implementado.");
                }                
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ConexaoDoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
