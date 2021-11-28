package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static Boolean wConectado = false;
        
    //Função que recebe as mensagens da interface
    public static String Execute(String wComando){  
        if (!wConectado){
            return "É necessário criar a conexão antes de executar comandos.";
        }
        
        if (wComando.equals("/exit")) {
            stopConnection();
            return "";
        }    
        
        //Se não possuir "/" na frente não envia para o servidor
        if (!wComando.substring(0, 1).equals("/")){
            return "Comando '"+wComando+"' não é válido.";
        }    
                
        return sendMessage(wComando);
    }
    
    //Envia mensagem para o servidor e espera o retorno
    public static String sendMessage(String msg) {
        try {
            out.println(msg);
            String resp = in.readLine();
            //Utilizado caractere especial "¬" como quebra de linha
            resp = resp.replace("¬", "\n");
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao processar comando '"+msg+"' :"+ ex+".";
        }
    }
    
    //Cria a conexão com servidor
    public static String createConnection(String host)  {
        try{
            if (wConectado) 
                return "O aplicativo já está conectado ao servidor.";
            
            try{
                int port = 8899;
                //Pode ser especificado uma porta de conexão
                if (host.contains(":")){
                    port = Integer.parseInt(host.split(":")[1]);
                    host = host.split(":")[0];
                }
                
                clientSocket = new Socket(host, port);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return "O servidor não pode ser encontrado: "+ex;
            }
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            wConectado = true;
            return "Conexão criada com sucesso.";
        } catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocorreu um erro ao criar a conexão: "+ ex+".";
        }
    }  
    
    //Sobrecarga caso seja criado uma conexão sem host, é utilizado o localhost
    public static String createConnection() throws IOException{
        return createConnection("localhost");
    }  

    //Fecha a conexão
    public static String stopConnection() {
        if (!wConectado){
            return "Conexão não está ativa.";
        }
        try {
            in.close();
            out.close();
            clientSocket.close();
            wConectado = false;
            return "Conexão encerrada.";
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocorreu um erro ao encerrar a conexão: "+ex;
        }
    }
}
