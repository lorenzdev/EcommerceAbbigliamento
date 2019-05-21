
package javasockettcp;

import java.net.*;
import java.io.*;
import java.util.*;



public class ClientTCP {
    private static final int port = 3333; 

    public ClientTCP(String address, int port){
        //creo lo scanner per le future operazioni di Input
        Scanner lettura = new Scanner(System.in);
        String cmd="";
        

        
        
            
            try{
                //creo il socket per la comunicazione con il server
                Socket client = new Socket(address, port);

                //creo i canali di comunicazione con il server
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Avviata comunicazione con il server, digitare EXIT quando possibile per chiudere il programma \n");
                while(!cmd.equals("EXIT")){

                    //ciclo per le risposte del server
                    String risp = in.readLine();
                    while (risp != null && !risp.equals("Spezzano")){
                        System.out.println(risp);
                        risp=in.readLine();
                    }
                    //leggo la risposta dell'utente
                    cmd=lettura.nextLine();
                    //la invio al server
                    out.println(cmd);


                }
            //comando per chiudere il client
            client.close(); 
            }
            catch(IOException ex){
            System.out.println("C'è stato un errore nella comunicazione con il Server!");

            }
        }

    
    
    
    public static void main(String args[]){
        
      
        System.out.println("Qual è l'indirizzo del server?");
        Scanner sc_address = new Scanner(System.in);
        String address = sc_address.nextLine(); 
        System.out.println("Qual è la porta su cui il server offre il servizio?");
        Scanner sc_port = new Scanner(System.in);
        String str_port = sc_port.nextLine();
        System.out.println(ClientGUI.ip);
        int port = Integer.parseInt(str_port);
        new ClientTCP(address, port); 
    }
    
}