

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
        
        
        
        //TODO interfaccia per inserire nuovi articoli
        //TODO implementare servizio multicast
        
        
        
        

        
        try{
            //creo i canali per la comunicazione
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String risp;
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

 
            //TODO una specie di chiave di sessione, che una volta loggato ti identifichi
            
            String pw;
            String email;

            risp=in.readLine();
                try{
            switch (Integer.parseInt(risp))
                    {
                case 1:
                    out.println("Inserisci l'email");
                    out.println("Spezzano");
                    email=in.readLine();
                    out.println("Inserisci la password");
                    out.println("Spezzano");
                    pw=in.readLine();
                    out.println(FunzioniServer.Login(email, pw));
                    break;

                    
                //probabilmente sarebbe più carino farlo con un vettore e un loop
                case 2:
                    String nome;
                    String cognome;
                    String numeroTelefono;
                    String indirizzo;
                    String dataNascita;
                    String citta;
                    out.println("Inserisci l'e-mail");
                    out.println("Spezzano");
                    email=in.readLine();
                    out.println("Inserisci il nome");
                    out.println("Spezzano");
                    nome=in.readLine(); 
                    out.println("Inserisci il cognome");
                    out.println("Spezzano");
                    cognome=in.readLine();
                    out.println("Inserisci la password");
                    out.println("Spezzano");
                    pw=in.readLine();
                    out.println("Inserisci il numero di telefono");
                    out.println("Spezzano");
                    numeroTelefono=in.readLine();
                    out.println("Inserisci indirizzo");
                    out.println("Spezzano");
                    indirizzo=in.readLine();
                    out.println("Inserisci la data di nascita");
                    out.println("Spezzano");
                    dataNascita=in.readLine();
                    out.println("Inserisci la citta");
                    out.println("Spezzano");
                    citta=in.readLine();
                    out.println(FunzioniServer.Registrarsi(email,nome, cognome,pw,numeroTelefono,indirizzo,dataNascita,citta));
                    out.println("Spezzano");
                    break;
                default:
                    
                    out.println("inserisci un valore valido (1) o (2)");
                    //fa ripartire il thread da capo, ma è una soluzione valida?
                    this.run(); 
                    break;
            }                    
            }catch(Exception e)
            {
                
                out.println("inserisci un valore valido");
                //fa ripartire il thread da capo, ma è una soluzione valida?
                this.run();
            }

            
                
                
        }catch(IOException e){
            out.println("C'è stato un errore nel server, riprova!");
            out.println("Spezzano");
        }
    }
}