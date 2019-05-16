
package javasockettcp;

import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class ServerTCP {
    //porta su cui viene offerto il servizio di eCommerce
    private static final int port = 3333; 
    static final String DB_URL = "jdbc:mysql://localhost/ecommerce";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    static Connection connection = null;
    public static void main(String[] args) {

        try{
            
            try{
            //TEST PER VEDERE LA CONNESSIONE AL DB
                Class.forName(DB_DRV);
                connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
                System.out.print("Database is connected !");
                connection.close();

                 }
            catch (ClassNotFoundException | SQLException ex){
                 System.out.println("errore durante la connessione al DB \n"+ex);
                 }
            //TEST PER VEDERE LA CONNESSIONE AL DB
            
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
