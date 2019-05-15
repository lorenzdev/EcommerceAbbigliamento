
package javasockettcp;

import java.net.*;
import java.io.*;


public class ServerTCP {
    //porta su cui viene offerto il servizio di eCommerce
    private static int port = 3333; 
    
    public static void main(String[] args) {

        try{
            //creo il socket su cui viene offerto il servizio
            ServerSocket socket = new ServerSocket(port);
            System.out.println("Server pronto!");
            
            //entro in un loop in modo tale da gestire le richieste di più client contemporaneamente
            while(true){
                //il programma si blocca in attesa di un client
                Socket client = socket.accept();

                //viene creato il thread che gestirà tutte le richieste del client
                ClientThread newConnect = new ClientThread(client);
                newConnect.start();
                //notifico in console la creazione del thread
                System.out.println("un nuovo client ha richiesto un servizio "+client.getInetAddress());
            }
        //in caso di problemi il server si interrompe    
        }catch(IOException ex){
            System.out.println("C'è stato un problema nel server!\n");
        }
    }
    
}
