# E-commerce di abbigliamento

## Verifica TePSIT

### Gruppo 1

Nome e cognome  
Nome e cognome  
Nome e cognome  

### Docente

prof. Vitale Lorenzo

### Descrizione
Obiettivo minimo (80punti)  
Realizzare un programma Client-Server che implementi il funzionamento di un sito di e-commerce
di abbigliamento in cui viene gestita la banca dati dei clienti e delle newsletter commerciali.
Ogni utente ha un account composto dalla propria e-mail e da una password in aggiunta ad una serie
di informazioni personali come nome, cognome, numero di telefono, data di nascita, indirizzo e
città di residenza.
L’e-commerce ha memorizzati una serie di articoli con una tipologia (scarpe, abbigliamento
sportivo, abbigliamento casual, accessori, borse, intimo, etc.), un nome, una descrizione, una marca
e un prezzo.
Il Server offre tre servizi ai Client:
1. Permette ad un nuovo utente di iscriversi inviando i propri dati al Server che procede a
memorizzarli nella propria banca dati. All’atto dell’iscrizione, l’utente indica anche una
serie di articoli a cui è interessato: abbigliamento sportivo, scarpe, accessori, etc.
2. Gli utenti iscritti, dopo essersi loggati inviando la propria e-mail e password di accesso,
possono richiedere l’elenco degli articoli fornendo la tipologia;
3. Gli utenti iscritti possono, inoltre, inserire nuovi articoli;
Gli articoli mostrati all’utente, devono essere visualizzati secondo l’ordine di prezzo, dal più
economico al più caro.

Obiettivo avanzato (20 punti)  
Implementare un ulteriore servizio di multicasting che prevede che i Client si mettano in ascolto.
Il Server, quando riceve un nuovo articolo da un Client, prima di salvarlo nel database lo invia a
tutti gli altri Client connessi in ascolto che sono interessati a quella tipologia di articolo.
N.B. Per semplificare la risoluzione di questo punto, prevedere che i Client, una volta in modalità
di ricezione multicasting, non ricevano comandi di input dall’utente ma restano esclusivamente in ascolto.


### Usage

Prima operazione da effettuare è ottenere il progetto dal repository lanciando il seguente comando dalla bash di git
```bash
git clone https://github.com/lorenzdev/EcommerceAbbigliamento.git
```
Successivamente lanciare i seguenti comandi per ottenere le modifiche:

```bash
git pull origin master
```

e per pubblicare le proprie modifiche:

```bash
git add .
git commit -m "descrizione del commit"
git push origin master
```

### Consegna
07/06/2019