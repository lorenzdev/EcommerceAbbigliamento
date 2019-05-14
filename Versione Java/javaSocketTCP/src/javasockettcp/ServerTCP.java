/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasockettcp;

import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

/**
 *
 * @author lorenzovitale
 */
public class ServerTCP {

    private static int port = 3333; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ArrayList<ArrayList<String>> treni = new ArrayList<ArrayList<String>>();
            // PARTENZO ARRIVO ORARIOP ORARIOA COSTO
            
            ArrayList<String> treno0 = new ArrayList<String>();
            treno0.add("Sassuolo");
            treno0.add("Modena");
            treno0.add("8:00");
            treno0.add("8:40");
            treno0.add("2,50€");
            ArrayList<String> treno1 = new ArrayList<String>();
            treno1.add("Modena");
            treno1.add("Bologna");
            treno1.add("9:00");
            treno1.add("9:40");
            treno1.add("5,50€");
            ArrayList<String> treno2 = new ArrayList<String>();
            treno2.add("Bologna");
            treno2.add("Rimini");
            treno2.add("9:00");
            treno2.add("11:40");
            treno2.add("10,50€");
            ArrayList<String> treno3 = new ArrayList<String>();
            treno3.add("Sassuolo");
            treno3.add("Modena");
            treno3.add("11:00");
            treno3.add("11:40");
            treno3.add("10,50€");
            //aggiungo le tratte alla matrice
            treni.add(treno0);
            treni.add(treno1);
            treni.add(treno2);
            treni.add(treno3);
            
            String xmlString = "<treni>" +
                        "<treno id='001'>" +
                            "<luogoP>Sassuolo</luogoP>"+
                            "<luogoA>Modena</luogoA>"+
                            "<orarioP>12:00</orarioP>"+
                            "<orarioA>12:30</orarioA>"+
                            "<costo>€2.00</costo>"+
                        "</treno>"+
                        "<treno id='002'>" +
                            "<luogoP>Modena</luogoP>"+
                            "<luogoA>Reggio Emilia</luogoA>"+
                            "<orarioP>15:00</orarioP>"+
                            "<orarioA>16:30</orarioA>"+
                            "<costo>€2.00</costo>"+
                        "</treno>"+
                    "</treni>";
            
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //Definisco un oggetto di tipo DocumentBuilder che fa da API per ottenere l'istanza del DOM
            DocumentBuilder builder = null;
            
            builder = factory.newDocumentBuilder();
            
            // Trasformo l'xml di tipo stringa in un oggetto Document (che possiamo poi manipolare a piacimento)
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            
            Node root = doc.getFirstChild();
            
            // CREO IL SOCKET SUL SERVER
            ServerSocket socket = new ServerSocket(port);
            
            System.out.println("Server pronto!");
            
            // ENTRO IN UN CICLO INFINITO PER SERVIRE PIU' CLIENT
            while(true){
                
                // METODO BLOCCANTE (IN ATTESA DI UNA RICHIESTA DA QUALCHE CLIENT)
                // CREA UN SOCKET CHE GESTISCE LE RICHIESTE DEL CLIENT
                Socket client = socket.accept();
                
                // CREO IL THREAD CHE GESTISCE LA RICHIESTA DEL CLIENT
                ClientThread newConnect = new ClientThread(client, treni, doc);
                newConnect.start();
                System.out.println("un nuovo client ha richiesto un servizio "+client.getInetAddress());
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
