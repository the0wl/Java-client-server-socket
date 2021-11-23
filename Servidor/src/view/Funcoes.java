package view;

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcoes {

    public Funcoes() {
    }
    
    public String barraQuem() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    public String barraData(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
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
    
    public String barraSYS() {
        return "Name: " + System.getProperty("os.name") + "¬Version: " +System.getProperty("os.version") + "¬Arch: " + System.getProperty("os.arch");
    }
    
    public String barraInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        float memoria = (float) osBean.getTotalMemorySize() / 1024 / 1024 / 1024;
        float memorialivre = (float) osBean.getFreeMemorySize() / 1024 / 1024 / 1024;
        
        return "CPU: " + String.format("%.2f", osBean.getCpuLoad()*100)+"%" + 
               "¬Memoria total: " + String.format("%.2f", memoria)+" GB" + 
               "¬Memoria livre: " + String.format("%.2f", memorialivre)+" GB";
    }
    
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
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    public String barraTrends() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "../servidor/google_tops.py");
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
                return resultado;
            } 
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    public String barraDev() {
        return "Grupo 2";
    }
    
}
