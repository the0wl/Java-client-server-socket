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
    private static Boolean wConectado = false;
        
    public static String Execute(String wComando){  
        if (!wConectado){
            return "É necessário criar a conexão antes de executar comandos.";
        }
        
        if (wComando.equals("/exit")) {
            stopConnection();
            return "";
        }    
                
        if (!wComando.substring(0, 1).equals("/")){
            return "Comando '"+wComando+"' não é válido.";
        }    
                
        return sendMessage(wComando);
    }
    
    public static String sendMessage(String msg) {
        try {
            out.println(msg);
            String resp = in.readLine();
            resp = resp.replace("¬", "\n");
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao processar comando '"+msg+"' :"+ ex;
        }
    }
    
    public static String createConnection(String host)  {
        try{
            if (wConectado) return "O aplicativo já está conectado ao servidor";
            
            try{
                clientSocket = new Socket(host, 8899);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return "O servidor não pode ser encontrado";
            }
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Conectado");
            wConectado = true;
            return "Conexão criada com sucesso";
        } catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocorreu um erro ao criar a conexão: "+ ex;
        }
    }  
    
    public static String createConnection() throws IOException{
        return createConnection("localhost");
    }  

    public static String stopConnection() {
        if (!wConectado){
            return "Conexão não está ativa.";
        }
        try {
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Desconectado");
            wConectado = false;
            return "Conexão encerrada";
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocorreu um erro ao encerrar a conexão: "+ex;
        }
    }
}
