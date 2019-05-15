

package javasockettcp;

import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    //creo le variabili che utilizzeò per la comunicazione
    Socket client;
    BufferedReader in;
    PrintWriter out;

    
    //costruttore
    public ClientThread(Socket client){
        this.client = client;

    }
    
    @Override
    public void run(){
        
        //TODO comunicazione con il DB per le informazioni.
        //TODO interfaccia per la registrazione
        //TODO interfaccia per il login
        //TODO interfaccia per inserire nuovi articoli
        //TODO implementare servizio multicast
        
        try{
            //creo i canali per la comunicazione
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // RICEVO IL DATO INVIATO DAL CLIENT
            //in.readLine();
            //out.println();
            //comendi per chiudere le comunicazioni
            //in.close();
            //out.close();
            //client.close();
            
            //primo messaggio che riceve il client
            out.println("Benvenuto nel servizio di eCommerce, al momento può solo registrarsi o loggarsi\n");
            out.println("Loggarsi (1) o Registrarsi (2) ?\n");
            
            //stringa che fa uscire dall'ascolto il client e permette di rispondere
            out.println("Spezzano");
        }catch(IOException e){
            out.println("C'è stato un errore nel server, riprova!");
        }
    }
}