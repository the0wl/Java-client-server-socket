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
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public ConexaoDoCliente(Socket socket) {
        System.out.println("Conectado: "+socket.getInetAddress() +":"+ socket.getPort() + " na porta local " + socket.getLocalPort());
        this.clientSocket = socket;
    }

    //Recebe os comandos do cliente e envia para as funções específicas
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine = "";
            Funcoes f = new Funcoes();
           
            while ((inputLine = in.readLine()) != null) {
                switch(inputLine) {
                    case "/quem": 
                        out.println(f.barraQuem()); break;
                    case "/data":
                        out.println(f.barraData()); break;
                    case "/ip":
                        out.println(f.barraIP()); break;
                    case "/mac":
                        out.println(f.barraMAC()); break;
                    case "/sys":
                        out.println(f.barraSYS()); break;
                    case "/dev":
                        out.println(f.barraDev()); break;
                    case "/info":
                        out.println(f.barraInfo()); break;
                    case "/dolar":
                        out.println(f.barraDolar()); break;
                    case "/trends": 
                        out.println(f.barraTrends()); break;
                    default:
                        out.println("Comando '"+inputLine+"' não implementado."); break;
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
