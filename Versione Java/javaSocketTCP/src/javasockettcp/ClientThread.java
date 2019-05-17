

package javasockettcp;

import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;




public class ClientThread extends Thread{
    //creo le variabili che utilizzeò per la comunicazione
    Socket client;
    BufferedReader in;
    PrintWriter out;
    static final String DB_URL = "jdbc:mysql://localhost/ecommerce";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    static ResultSet resultSet = null;
    static Connection connection = null;
    
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
            String risp;


            try{
            //TEST PER VEDERE LA CONNESSIONE AL DB E LE QUERY
            Class.forName(DB_DRV);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            System.out.print("Database is connected !");
            //DB CONNESSO
            //SCRIVO LA QUERY
            PreparedStatement sel = connection.prepareStatement("SELECT * FROM utenti");
            //PRENDO I RISULTATI DELLA QUERY
            resultSet=sel.executeQuery();

            int cont = 1;
            //CICLO PER LE SOLUZIONI
            while(resultSet.next()){
                //getString con dentro il nome della colonna
               out.println(resultSet.getString("email"));
               cont++;
               connection.close();
             }
        }
        catch (ClassNotFoundException | SQLException ex){
             System.out.println("errore durante la connessione al DB \n"+ex);
             }
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

            String us="";
            String pw="";
            String email;

            risp=in.readLine();
                try{
            switch (Integer.parseInt(risp))
                    {
                case 1:
                    out.println("Inserisci l'username");
                    out.println("Spezzano");
                    us=in.readLine();
                    out.println("Inserisci la password");
                    out.println("Spezzano");
                    pw=in.readLine();
                    out.println(FunzioniServer.Login(us, pw));
                    break;

                case 2:
                    out.println("Inserisci l'e-mail");
                    out.println("Spezzano");
                    email=in.readLine();
                    out.println("Inserisci l'username");
                    out.println("Spezzano");
                    us=in.readLine();                    
                    out.println("Inserisci la password");
                    out.println("Spezzano");
                    pw=in.readLine();
                    out.println(FunzioniServer.Registrarsi(email,us, pw));
                    break;
                default:
                    out.println("inserisci un valore valido (1) o (2)");
                    break;
            }                    
            }catch(Exception e)
            {
                out.println("inserisci un valore valido");
            }

            
        }catch(IOException e){
            out.println("C'è stato un errore nel server, riprova!");
        }
    }
}