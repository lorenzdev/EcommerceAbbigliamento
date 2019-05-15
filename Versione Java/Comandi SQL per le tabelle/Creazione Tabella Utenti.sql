CREATE TABLE `Utenti` (
	`email` CHAR(50) NOT NULL,
	`password` CHAR(20) NOT NULL,
	`nome` CHAR(50) NOT NULL,
	`cognome` CHAR(50) NOT NULL,
	`numeroTelefono` INT(10) NOT NULL,
	`dataNascita` CHAR(10) NOT NULL,
	`indirizzo` CHAR(60) NOT NULL,
	`citta` CHAR(57) NOT NULL,
	PRIMARY KEY (`email`)
);