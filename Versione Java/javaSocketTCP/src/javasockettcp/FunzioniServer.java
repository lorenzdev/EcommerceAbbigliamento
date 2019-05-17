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

/**
 *
 * @author utente
 */
public class FunzioniServer {
    
    static final String DB_URL = "jdbc:mysql://localhost/ecommerce";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    static ResultSet resultSet = null;
    static Connection connection = null;
    
    
    
    public static String Login(String email, String password){
        return "Hai fatto il login";
    }

    public static String Registrarsi(String email,String nome,String cognome,String pw,String numeroTelefono,String indirizzo,String dataNascita,String citta)
    { 
        Connection conn = ConnessioneDB();
        return "Ti sei registrato";
    }   

    public static Connection ConnessioneDB(){
        try{
            Class.forName(DB_DRV);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            }catch (ClassNotFoundException | SQLException ex){
            System.out.println("errore durante la connessione al DB \n"+ex);
            }
        return connection;
    }
    
    public static void DisconnessioneDB(Connection c){
        try{c.close();
        }catch (SQLException ex){
            System.out.println("errore durante la connessione al DB \n"+ex);
            }
    }
}

