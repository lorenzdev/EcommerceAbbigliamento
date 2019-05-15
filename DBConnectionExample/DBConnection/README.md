# Esempio di connessione a MySql con JDBC (Java DataBase Connectivity)

## PREMESSA
Nel caso in cui si abbia installato sulla propria macchina XAMP oppure MAMP (per MacOs), non è necessario installare alcun database MySQL potete utilizzare quello fornito dal webserver che avete installato per usare PHP.  

Per effettuare la connessione è necessario conoscere la porta su cui il vostro MySQL risponde (lo potete vedere da Control Panel di XAMP in corrispondenza della riga del vostro MySQL).
  
Di seguito il codice necessario ad effettuare la connessione (lo troverete nel .java dell'esempio):  

```
1. static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
2. static final String DB_DRV = "com.mysql.jdbc.Driver";
3. static final String DB_USER = "root";
4. static final String DB_PASSWD = "root";  
```  
La riga 1. indica l'URL del database. Si noti che 3306 è il numero di porta di default su cui MySQL risponde. Se la connessione non funziona è perchè il numero di porta impostato è diverso.
La riga 2. contiene il nome del package del Driver per la connessione.
Le righe 3. e 4. sono l'user e la password per effettuare la connessione al vostro database.

Prima di utilizzare l'esempio all'interno del vostro progetto, ricordatevi di aggiungere la libreria, in Netbeans, necessaria ad un suo corretto funzionamento.
Come fare...
1) Click sul tasto destra del mouse sul nome del progetto all'interno della finestra dei progetti.
2) Cliccare nel menu sulla voce Proprietà.
3) Spostarsi sulla voce Libraries
4) Nel tab "Compile", cliccare su "Add project..." e selezionare la voce "MySQL JDBC Driver"
5) Dare Ok, tornare al progetto e provare a compilare
