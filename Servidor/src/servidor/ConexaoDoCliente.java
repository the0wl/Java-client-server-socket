package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoDoCliente extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ConexaoDoCliente(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (".".equals(inputLine)) {
                    out.println("bye");
                }
                
                if ("/quem".equals(inputLine)) {
                    InetAddress ip = InetAddress.getLocalHost();
                    String hostname = ip.getHostName();
                    out.println(hostname);
                }
                
                if ("/data".equals(inputLine)) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    out.println(dateFormat.format(date));
                }
                
                if ("/ip".equals(inputLine)) {
                    InetAddress ip = InetAddress.getLocalHost();
                    out.println(ip);
                }
                
                if ("/mac".equals(inputLine)) {
                    InetAddress ip = InetAddress.getLocalHost();
                    NetworkInterface ni = NetworkInterface.getByInetAddress(ip);
                    byte[] hardwareAddress = ni.getHardwareAddress();
                    
                    String[] hexadecimal = new String[hardwareAddress.length];
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
                    }
                    String macAddress = String.join("-", hexadecimal);
                    
                    out.println(macAddress);
                }
                
                if ("/sys".equals(inputLine)) {
                    System.getProperties().list(System.out);
                    out.println("Name: " + System.getProperty("os.name") +
                                ", Version: " +System.getProperty("os.version") +
                                ", Arch: " + System.getProperty("os.arch"));
                }
                
                if ("/dev".equals(inputLine)) {
                    out.println("Grupo 2");
                }
                
                if ("/info".equals(inputLine)) {
                    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                    OperatingSystemMXBean.class);

                    float memoria = osBean.getTotalMemorySize() / 1024 / 1024 / 1024;
                    
                    out.println("CPU: " + String.format("%.2f", osBean.getCpuLoad()) + 
                                ", Memoria: " + memoria);
                }
                
                if ("/dolar".equals(inputLine)) {
                    URL url = new URL("https://economia.awesomeapi.com.br/json/last/USD-BRL");
                    
                    Gson gson = new Gson();
                    
                    HttpURLConnection conector = (HttpURLConnection) url.openConnection();
                    conector.setDoOutput(true);
                    conector.setRequestMethod("GET");

                    if (conector.getResponseCode() != 200) { //Tratando um possível erro de conexão;
                            System.out.print("ERROR... HTTP error code : " + conector.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader((conector.getInputStream())));

                    String output, retorno=""; 

                    while ((output = br.readLine()) != null) {
                            retorno+=output; // Neste While é adicionado todo o retorno da API dentro da variável 'retorno'
                    }
                    
                    retorno = retorno.substring(10, retorno.length() - 1);
                    
                    Moeda dados_retorno = gson.fromJson(retorno, Moeda.class); //Pega o JSON que veio da API e coloca dentro da Classe que criei no começo;

                    System.out.println(dados_retorno.toString());

                    conector.disconnect();
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
