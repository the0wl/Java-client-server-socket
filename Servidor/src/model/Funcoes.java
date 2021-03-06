package model;

import com.google.gson.Gson;
import com.sun.management.OperatingSystemMXBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcoes {

    public Funcoes() {
    }
    
    /** Retorna o nome da máquina em que o servidor está sendo executado */
    public String barraQuem() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    /** Retorna a data da máquina em que o servidor está sendo executado. */
    public String barraData(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    /** Retorna o IP da máquina em que o servidor está sendo executado
     * Caso houver mais de uma interface, serão listadas todas.
     */
    public String barraIP() throws SocketException {
        Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
        String interfaces = "";
        
        for (NetworkInterface netint : Collections.list(ni)) {
            byte[] hardwareAddress = netint.getHardwareAddress();
            if (hardwareAddress == null) continue;
            
            String nome = netint.getDisplayName();
            String nomeeth = netint.getName();
            
            java.util.List<InterfaceAddress> ls = netint.getInterfaceAddresses();
            String IPs = "";
            for (InterfaceAddress l: ls){
                String aux = l.getAddress().toString().substring(1);
                
                if (aux.contains("%"))
                    aux = aux.substring(0,aux.indexOf("%"));
                
                IPs += " - "+aux+"¬";
            }
            
            interfaces += nome + "¬Interface: " + nomeeth + "¬IP:¬" + IPs + "¬¬";
        }
        return interfaces;
    }
    
    /** Retorna o endereço MAC da máquina em que o servidor está sendo executado
     * Caso houver mais de uma interface, serão listadas todas.
     */
    public String barraMAC() {
        try {
            Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
            
            String interfaces = "";
            
            for (NetworkInterface netint : Collections.list(ni)) {
                byte[] hardwareAddress = netint.getHardwareAddress();
                if (hardwareAddress == null) continue;
                
                String nome = netint.getDisplayName();
                String nomeeth = netint.getName();
                                
                String[] hexadecimal = new String[hardwareAddress.length];
                
                for (int i = 0; i < hardwareAddress.length; i++) {
                    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
                }
                String macAddress = String.join("-", hexadecimal);
                
                interfaces += nome + "¬Interface: " + nomeeth + "¬MAC: " + macAddress + "¬¬¬";
            }
            
            return interfaces;
        } catch (SocketException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    /** Retorna as informações de nome, versão e arquitetura do sistema operacional
     * instalado na máquina em que o servidor está sendo executado.
     */
    public String barraSYS() {
        return "Name: " + System.getProperty("os.name") + 
              "¬Version: " +System.getProperty("os.version") + 
              "¬Arch: " + System.getProperty("os.arch");
    }
    
    public String barraInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        float memoria = (float) osBean.getTotalMemorySize() / 1024 / 1024 / 1024;
        float memorialivre = (float) osBean.getFreeMemorySize() / 1024 / 1024 / 1024;
        
        return "CPU: " + String.format("%.2f", osBean.getCpuLoad()*100)+"%" + 
               "¬Memoria total: " + String.format("%.2f", memoria)+" GB" + 
               "¬Memoria livre: " + String.format("%.2f", memorialivre)+" GB";
    }
    
    /** Retorna as informações de preço de compra e venda da moeda Dolar.
     * API: https://economia.awesomeapi.com.br/json/last/USD-BRL
     */
    public String barraDolar() {
        try {
            URL url = new URL("https://economia.awesomeapi.com.br/json/last/USD-BRL");
            Gson gson = new Gson();
            String output, retorno="";
            
            HttpURLConnection conector = (HttpURLConnection) url.openConnection();
            conector.setDoOutput(true);
            conector.setRequestMethod("GET");
            
            if (conector.getResponseCode() != 200) {
                return "ERROR... HTTP error code : " + conector.getResponseCode();
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conector.getInputStream())));
            
            while ((output = br.readLine()) != null) {
                retorno += output;
            }
            
            retorno = retorno.substring(10, retorno.length() - 1);
            Moeda dados_retorno = gson.fromJson(retorno, Moeda.class);
            conector.disconnect();
            
            return dados_retorno.getDolarDia();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao buscar dólar: " + ex;
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao buscar dólar: " + ex;            
        }
    }
    
    /** Retorna as informações de trend topics do motor de busca Google.
     * Utiliza a api pytrends (google_tops.py) para a consulta de dados.
     */
    public String barraTrends() {
        try {
            //Verificar se o python está instalado
            ProcessBuilder processBuilder = new ProcessBuilder("python", "--version");
            processBuilder.redirectErrorStream(true);
            
            Process process = processBuilder.start();
            
            try (BufferedReader input = 
                    new BufferedReader(new 
                              InputStreamReader(process.getInputStream()))) { 
                String line; 
                String resultado = "";
                while ((line = input.readLine()) != null) { 
                    resultado += line;
                } 
                if (!resultado.contains("Python 3")){
                    return "Para executar trends o servidor precisa possuir Python 3. instalado.";
                }
            } 
            
            // Verificar se o pytrends está instalado
            processBuilder = new ProcessBuilder("pip", "freeze");
            processBuilder.redirectErrorStream(true);
            
            process = processBuilder.start();
            
            try (BufferedReader input = 
                    new BufferedReader(new 
                              InputStreamReader(process.getInputStream()))) { 
                String line; 
                String resultado = "";
                while ((line = input.readLine()) != null) { 
                    resultado += line;
                } 
                if (!resultado.contains("pytrends==")){
                    return "Para executar trends o servidor precisa possuir Pytrends instalado.¬"+
                           "Pode ser usado o comando 'pip install pytrends' no cmd.";
                }
            } 
            
            // Execução e envio dos resultados
            processBuilder = new ProcessBuilder("python", "../servidor/google_tops.py");
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            
            try (BufferedReader input = 
                    new BufferedReader(new 
                              InputStreamReader(process.getInputStream()))) { 
                String line; 
                String resultado = "";
                while ((line = input.readLine()) != null) { 
                    resultado += line;
                } 
                return resultado;
            } 
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao buscar trends: "+ex;
        }
    }
    
    public String barraDev() {
        return "Grupo 2";
    }
    
}
