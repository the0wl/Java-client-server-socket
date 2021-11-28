package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    private static ServerSocket serverSocket;
    
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8899);
            
            //Espera conexões na porta 8899
            while (true)
                new ConexaoDoCliente(serverSocket.accept()).start();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
