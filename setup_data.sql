
/* SE1P 2014*/

CREATE TABLE Benutzer
    (Benutzer_ID    INTEGER PRIMARY KEY,
     Vorname        VARCHAR(50) NOT NULL,
     Nachname       VARCHAR(50) NOT NULL,
     Benutzername   VARCHAR(50) UNIQUE NOT NULL,
     Email          VARCHAR(255) UNIQUE NOT NULL,
     Passwort       VARCHAR(150) NOT NULL,
     Berechtigung   INTEGER,
     IsDeleted      INTEGER, 
      CONSTRAINT Check_IsDeleted
        CHECK (IsDeleted=1 OR IsDeleted=0)
    );
    
CREATE TABLE Uebung
    (Zeitpunkt       DATE NOT NULL,
     Korrektheit     INTEGER NOT NULL,
     Benoetigte_Zeit INTEGER NOT NULL,
     Benutzer_ID     INTEGER REFERENCES Benutzer
    );
    
CREATE TABLE Modul
    (Name            VARCHAR(128) NOT NULL,
     Department      VARCHAR(128) NOT NULL
    );

CREATE TABLE Frage
    (Frage_Nr       INTEGER NOT NULL,
     Fragestellung  VARCHAR(250) NOT NULL,
     Musterloesung  VARCHAR(250) NOT NULL,
     Loesungszeit   INTEGER NOT NULL
    );

/*

        
*/