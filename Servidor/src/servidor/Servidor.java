/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelvin
 */
public class Servidor {

    private static ServerSocket serverSocket;
    
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8899);
            
            while (true)
                new ConexaoDoCliente(serverSocket.accept()).start();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
