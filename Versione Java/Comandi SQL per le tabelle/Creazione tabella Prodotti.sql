CREATE TABLE Prodotti (
	idProdotto INT(4) NOT NULL,
	tipologia CHAR(20) NOT NULL,
	nome CHAR(30) NOT NULL,
	descrizione CHAR(100) NOT NULL,
	marca CHAR(30) NOT NULL,
	prezzo FLOAT(8) NOT NULL,
	aggiuntoDa CHAR(100) DEFAULT "prodotto base",
	PRIMARY KEY (`idProdotto`)
);