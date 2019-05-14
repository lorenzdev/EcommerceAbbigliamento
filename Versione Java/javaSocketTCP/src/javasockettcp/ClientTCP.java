/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasockettcp;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author lorenzovitale
 */


public class ClientTCP {
    
    private static String partenza;
    private static String arrivo;
    private static String orPartenza;
    private static String orArrivo;
    private static String costo;
    private static String scelta;
    public ClientTCP(String address, int port){
        if (scelta.equals("1")){
            try{
                // CREO IL SOCKET
                Socket client = new Socket(address, port);

                // CREO LO STREAM SUL SOCKET
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

                // SCRIVO SULLO STREAM DEL SOCKET
                out.println(scelta);
                out.println(partenza);
                out.println(arrivo);
                System.out.println("ho inviato i dati "+arrivo+" "+partenza);

                // RICEVO IL MESSAGGIO DALLO STREAM DEL CLIENT
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Il server risponde: \n");
                String risp = in.readLine();
                while (risp != null){
                    System.out.println(risp);
                    risp=in.readLine();
                }

                client.close();

            }
            catch(Exception ex){
            ex.printStackTrace();
        }
       }
        
        
        else{
            try{
                // CREO IL SOCKET
                Socket client = new Socket(address, port);
                int provoadaggiungereunariga=0;
                // CREO LO STREAM SUL SOCKET
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

                // SCRIVO SULLO STREAM DEL SOCKET
                out.println(scelta);
                out.println(partenza);
                out.println(arrivo);
                out.println(orPartenza);
                out.println(orArrivo);
                out.println(costo);
                
                System.out.println("ho inviato i dati "+arrivo+" "+partenza+" "+orPartenza+" "+orArrivo+" "+costo);

                // RICEVO IL MESSAGGIO DALLO STREAM DEL CLIENT
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Il server risponde: \n");
                String risp = in.readLine();
                while (risp != null){
                    System.out.println(risp);
                    risp=in.readLine();
                }

                client.close();

            }
            catch(Exception ex){
            ex.printStackTrace();
        }
        }
        
    }
    
    
    public static void main(String args[]){
        
        
        System.out.println("Qual è l'indirizzo del server?");
        Scanner sc_address = new Scanner(System.in);
        String address = sc_address.nextLine();
        
        System.out.println("Qual è la porta su cui il server offre il servizio?");
        Scanner sc_port = new Scanner(System.in);
        String str_port = sc_port.nextLine();
        
        System.out.println("Vuoi leggere (1) o scrivere (2) ?");
        Scanner sceltaS = new Scanner(System.in);
        scelta = sceltaS.nextLine();
        
        if(scelta.equals("1"))
        {
            System.out.println("Luogo partenza");
            Scanner sc_service = new Scanner(System.in);
            partenza = sc_service.nextLine();

            System.out.println("Luogo Arrivo");
            sc_service = new Scanner(System.in);
            arrivo = sc_service.nextLine();

            int port = Integer.parseInt(str_port);
            new ClientTCP(address, port);
        }
        else{
            System.out.println("Luogo partenza");
            Scanner sc_service = new Scanner(System.in);
            partenza = sc_service.nextLine();

            System.out.println("Luogo Arrivo");
            sc_service = new Scanner(System.in);
            arrivo = sc_service.nextLine();
            
            System.out.println("Orario partenza");
            Scanner bla = new Scanner(System.in);
            orPartenza = bla.nextLine();

            System.out.println("Orario arrivo");
            Scanner blaa = new Scanner(System.in);
            orArrivo = blaa.nextLine();
            
            System.out.println("Costo");
            Scanner blaaa = new Scanner(System.in);
            costo = blaaa.nextLine();
            

            int port = Integer.parseInt(str_port);
            new ClientTCP(address, port);
        }
    }
    
}
