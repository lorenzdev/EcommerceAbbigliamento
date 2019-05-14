/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasockettcp;

import java.net.*;
import java.io.*;
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
public class ClientThread extends Thread{
    ArrayList<ArrayList<String>> treni;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    Document doc;
    
    // COSTRUTTORE
    public ClientThread(Socket client, ArrayList<ArrayList<String>> treni, Document doc){
        this.client = client;
        this.treni = treni;
        this.doc = doc;
    }
    
    
    public void run(){
       
        try{
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            

           
            // RICEVO IL DATO INVIATO DAL CLIENT
            String partenza;
            String arrivo;
            String scelta;
            String orPartenza;
            String orArrivo;
            String costo;
            scelta = in.readLine();
            if (scelta.equals("1"))
            {
                partenza = in.readLine();
                arrivo = in.readLine();
                String response = "";
                ArrayList<ArrayList<String>> risposta = new ArrayList<ArrayList<String>>();
                for (int i=0; i<treni.size(); i++){

                    ArrayList<String> treno = treni.get(i);

                    Boolean flag1 = false;
                    Boolean flag2 = false;

                    if (treno.get(0).equals(partenza))
                        flag1=true;

                    if (treno.get(1).equals(arrivo))
                        flag2=true;

                    if (flag1 && flag2)
                        risposta.add(treno);

                }

                String stringa;
                if (risposta.size()<= 0)
                    out.println("nessun treno trovato");
                else{
                    for (int i=0;i<risposta.size();i++)
                    {
                        stringa = "***Treno numero "+i+"***\nPartenza="+risposta.get(i).get(0)+"\nArrivo="+risposta.get(i).get(1)+"\nOrario Partenza="+risposta.get(i).get(2)+"\nOrario Arrivo="+risposta.get(i).get(3)+"\nCosto="+risposta.get(i).get(4)+"\n\n";
                        out.println(stringa);
                    }

                }
            }
            else{
                partenza = in.readLine();
                arrivo = in.readLine();
                orPartenza = in.readLine();
                orArrivo = in.readLine();
                costo = in.readLine();
                
                ArrayList<String> treno0 = new ArrayList<String>();
                treno0.add(partenza);
                treno0.add(arrivo);
                treno0.add(orPartenza);
                treno0.add(orArrivo);
                treno0.add(costo);
                treni.add(treno0);
                
                String stringa;
                
                stringa = "***Treno aggiunto ***\nPartenza="+treno0.get(0)+"\nArrivo="+treno0.get(1)+"\nOrario Partenza="+treno0.get(2)+"\nOrario Arrivo="+treno0.get(3)+"\nCosto="+treno0.get(4)+"\n\n";
                out.println(stringa);
            }
            
            
            NodeList tmpEmployees = ((Element)doc.getFirstChild()).getElementsByTagName("treno");
            for(int i = 0;i < tmpEmployees.getLength();i++){
            Node treno = tmpEmployees.item(i);
                if(treno.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element)treno;
                    Boolean flag3 = false;
                    Boolean flag4 = false;
                    if (el.getElementsByTagName("luogoP").item(0).getTextContent().equals(partenza))
                        flag3=true;
                    
                    if(el.getElementsByTagName("luogoA").item(0).getTextContent().equals(arrivo))
                        flag4=true;
                    out.println("+++ TRENO TROVATO +++\nPartenza="+el.getElementsByTagName("luogoP").item(0).getTextContent()+"\nArrivo="+el.getElementsByTagName("luogoA").item(0).getTextContent()+"\nOrario Partenza="+el.getElementsByTagName("orarioP").item(0).getTextContent()+"\nOrario Arrivo="+el.getElementsByTagName("orarioA").item(0).getTextContent()+"\nCosto="+el.getElementsByTagName("costo").item(0).getTextContent());

                
                }
            }
            
            
            
            // CHIUDO I BUFFER E IL SOCKET
            in.close();
            out.close();
            client.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
}
