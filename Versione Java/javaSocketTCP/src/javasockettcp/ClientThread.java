

package javasockettcp;

import java.net.*;
import java.io.*;




public class ClientThread extends Thread{
    //creo le variabili che utilizzeò per la comunicazione
    Socket client;
    BufferedReader in;
    PrintWriter out;
    public static String nomeClient = ">>>>----<<<<";
    
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
            
            
            do{
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
                        String risposta=FunzioniServer.Login(email, pw);
                        out.println(risposta);
                        //si potrebbe ricavare il nome, ma al momento va bene così
                        if (risposta.equals("Loggato correttamente!\n"))
                            nomeClient=email;

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

                        //out.println("Spezzano");
                        break;
                    default:
                        out.println("inserisci un valore valido (1) o (2)");
                        break;
                }                    
                }catch(Exception e)
                {
                    out.println("inserisci un valore valido");

                }

                //se non si è loggato

            } while(nomeClient.equals(">>>>----<<<<"));
                    
            
            

            Home();
                
                
        }catch(IOException e){
            out.println("C'è stato un errore nel server, riprova!");
            out.println("Spezzano");
        }
    }
    
    public void Home(){
        try{
        out.println("Benvenuto "+nomeClient+", ora che è loggato può vedere la lista dei prodotti(1) oppure aggiungerne uno lei(2)");
        out.println("Spezzano");
        String risp=in.readLine();
                try{
            switch (Integer.parseInt(risp))
                    {
                case 1:
                    //vedere lista prodotti
                    break;

                case 2:
                    String tipologia;
                    String nome;
                    String descrizione;
                    String marca;
                    float prezzo;
                    out.println("Inserisci tipologia del prodotto");
                    out.println("Spezzano");
                    tipologia=in.readLine();
                    out.println("Inserisci il nome del prodotto");
                    out.println("Spezzano");
                    nome=in.readLine(); 
                    out.println("Inserisci la descrizione del prodotto");
                    out.println("Spezzano");
                    descrizione=in.readLine();
                    out.println("Inserisci la marca del prodotto");
                    out.println("Spezzano");
                    marca=in.readLine();
                    out.println("Inserisci il prezzo del prodotto");
                    out.println("Spezzano");
                    prezzo=Float.parseFloat(in.readLine());
                    out.println(FunzioniServer.inserimentoDB(tipologia,nome,descrizione,marca,prezzo,nomeClient));
                    this.Home();
                    break;
                    
                default:
                    out.println("inserisci un valore valido (1) o (2)");
                    this.Home();
                    break;
            }                    
            }catch(IOException | NumberFormatException e)
            {
                out.println("inserisci un valore valido");
                this.Home();
            }
        }
        
        catch(IOException ex){
            this.Home();
        }
    }
}