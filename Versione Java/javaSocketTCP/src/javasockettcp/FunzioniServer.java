/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javasockettcp;

import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class FunzioniServer {
    //variabili utilizzate per la connessione al database
    static final String DB_URL = "jdbc:mysql://localhost/ecommerce";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    static ResultSet resultSet = null;
    static Connection connection = null;
    
    
    //metodo per effettuare il login, con invio di messaggio di errore se la mail e la password sono incorrette.
    public static String Login(String email, String password){
        Connection conn = ConnessioneDB();
        try {
            if(conn.isValid(10)){
                PreparedStatement sel = connection.prepareStatement("SELECT email,password FROM utenti WHERE email='"+email+"';");
                resultSet=sel.executeQuery();
                resultSet.next();
                if (resultSet.getString("password").equals(password)){
                    DisconnessioneDB(conn);
                    return "Loggato correttamente!\n";
                }
                else{
                    DisconnessioneDB(conn);
                    return "Email o Password incorrette!\n";
                }
            }

        } catch (SQLException ex) {
            //probabilmente se entra qua, la query non ha trovato email quindi ha sollevato un eccezione
            DisconnessioneDB(conn);
            return "Email non registrata!\n"+ex;
        }
        
        
        //non dovrebbe mai raggiungere questa riga
        DisconnessioneDB(conn);
        return "Qualcosa è andato sicuramente storto\n";
    }
    
    //metodo per effettuare la registrazione
    public static String Registrarsi(String email,String nome,String cognome,String pw,String numeroTelefono,String indirizzo,String dataNascita,String citta)
    { 
        Connection conn = ConnessioneDB();
        try {
            //controlla che sia valida la connessione, dopo 10 secondi
            //restituisce il valore false
            if(conn.isValid(10)){

                //creo la query per vedere se la mail è già stata utilizzata
                PreparedStatement sel = connection.prepareStatement("SELECT email FROM utenti");
                //PRENDO I RISULTATI DELLA QUERY
                resultSet=sel.executeQuery();
                //creo un flag per vedere se trova email già registrate
                boolean flag=false;
                //CICLO PER LE SOLUZIONI
                while(resultSet.next() && !flag){ 
                   if(resultSet.getString("email").equals(email))
                       flag=true;
                 }
                if (flag){
                    return "La mail è già presente nel DB\n";
                }
                else{
                    //inserisco i dati di registrazione nel DB
                    //TODO controllo integrità dei dati
                    PreparedStatement ins = connection.prepareStatement("INSERT INTO utenti VALUES('"+email+"','"+pw+"','"+nome+"','"+cognome+"','"+numeroTelefono+"','"+dataNascita+"','"+indirizzo+"','"+citta+"');");
                    ins.executeUpdate();
                }
            }
            else{
                return "Errore lato server durante la registrazione: connessione fallita al DB\n";
            }
            
        } catch (SQLException ex) {
            DisconnessioneDB(conn);
            return "Errore lato server durante la registrazione: eccezione sollevata\n";
        }
        
        DisconnessioneDB(conn);
        return "Ti sei registrato\n";
    }   
    
    
    //metodo che restituisce la connessione al DB
    public static Connection ConnessioneDB(){
        try{
            Class.forName(DB_DRV);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            }catch (ClassNotFoundException | SQLException ex){
            //questo non ha senso perchè non viene printato da nessuna parte
            System.out.println("errore durante la connessione al DB \n"+ex);
            }
        return connection;
    }
    
    //metodo che richiede la connessione al DB in ingresso per chiuderla
    private static void DisconnessioneDB(Connection c){
        try{
            c.close();
        }
        catch (SQLException ex){
            //questo non ha senso perchè non viene printato da nessuna parte
            System.out.println("errore durante la connessione al DB \n"+ex);
        }
    }
    
                        String tipologia;
                    String nome;
                    String descrizione;
                    String marca;
                    float prezzo;
    //metodo per inserire nel database le informazioni del prodotto
    public static String inserimentoDB(String tipologia, String nome, String descrizione, String marca, Float prezzo,String nomeClient){
        Connection conn = ConnessioneDB();
        
        try {
            //controlla che sia valida la connessione, dopo 10 secondi
            //restituisce il valore false
            if(conn.isValid(10)){
                PreparedStatement ins = connection.prepareStatement("INSERT INTO prodotti(tipologia,nome,descrizione,marca,prezzo,aggiuntoDa) VALUES('"+tipologia+"','"+nome+"','"+descrizione+"','"+marca+"','"+prezzo+"','"+nomeClient+"');");
                ins.executeUpdate();
            }
            else{
                return "Errore lato server durante la registrazione: connessione fallita al DB\n";
            }
            
        } catch (SQLException ex) {
            DisconnessioneDB(conn);
            return "Errore lato server durante la registrazione: eccezione sollevata\n"+ex;
        }
        
        DisconnessioneDB(conn);
        return "Prodotto aggiunto\n";

    }
    
   public static ArrayList<String> visualizzazioneDB(String cat){
       Connection conn = ConnessioneDB();
       //String[] vet = new String[10];
       ArrayList<String> risp= new ArrayList<String>();
       
       try{
            if(conn.isValid(10)){
                //creo la query per vedere se la mail è già stata utilizzata
                PreparedStatement sel = connection.prepareStatement("SELECT * FROM prodotti WHERE tipologia='"+cat+"';");
                //PRENDO I RISULTATI DELLA QUERY
                resultSet=sel.executeQuery();
                //CICLO PER LE SOLUZIONI
                while(resultSet.next()){ 
                   risp.add(resultSet.getString("tipologia"));
                 }
                if (risp.isEmpty())
                    risp.add("nessun prodotto con quella categoria trovato!");
            }
            else{
                risp.add("Connessione fallita al DB!");
                DisconnessioneDB(conn);
                return risp;
            }       
       }catch(SQLException e){
           risp.add("Connessione fallita al DB!");
           DisconnessioneDB(conn);
           return risp;
       }
       DisconnessioneDB(conn);
       return risp;
   }
}
  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
