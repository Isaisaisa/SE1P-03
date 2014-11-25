/* SE1P 2014*/
DROP TABLE uebung;
DROP TABLE frage;
DROP TABLE benutzer_modul;
DROP TABLE benutzer;
DROP TABLE modul;


CREATE TABLE modul (
    modul_id    INTEGER PRIMARY KEY,
    name        VARCHAR(128) UNIQUE NOT NULL,
    department  VARCHAR(128) NOT NULL
);

-- Primary Key generieren
--CREATE SEQUENCE modul_seq;
CREATE OR REPLACE TRIGGER modul_increment BEFORE INSERT ON modul FOR EACH ROW
BEGIN
  SELECT modul_seq.NEXTVAL
  INTO   :new.modul_id
  FROM   dual;
END;    
/


CREATE TABLE benutzer (
    benutzer_id    INTEGER       PRIMARY KEY,
    vorname        VARCHAR(50)   NOT NULL,
    nachname       VARCHAR(50)   NOT NULL,
    benutzername   VARCHAR(50)   UNIQUE NOT NULL,
    email          VARCHAR(255)  UNIQUE NOT NULL,
    passwort       CHAR(50)      NOT NULL,
    anzeigebild    BLOB,
    berechtigung   INTEGER,
    is_deleted     INTEGER,
    CONSTRAINT check_is_deleted
      CHECK (is_deleted=1 OR is_deleted=0)
);

-- Primary Key generieren
--CREATE SEQUENCE benutzer_seq;
CREATE OR REPLACE TRIGGER benutzer_increment BEFORE INSERT ON benutzer FOR EACH ROW
BEGIN
  SELECT benutzer_seq.NEXTVAL
  INTO   :new.benutzer_id
  FROM   dual;
END;    
/


CREATE TABLE frage (
     frage_id             INTEGER       PRIMARY KEY,
     frage_nr             INTEGER       UNIQUE NOT NULL,
     loesungszeit         INTEGER       NOT NULL,    
     fragestellung        VARCHAR(250)  NOT NULL,
     musterloesung        VARCHAR(1500) NOT NULL, 
     -- Fragenarten:
     -- 0 = Single Choice
     -- 1 = Multiple Choice
     -- 2 = Binäre Ankreuzmöglichkeit
     -- 3 = Freitext
     -- 4 = Graphisch
     fragenart            INTEGER       NOT NULL,      
     -- Y/N as options
     is_valid             CHAR(1)       NOT NULL,  --TODO: Constraint bzgl Einschränkung auf Y/N? + UMBENENNEN auf is_available
     --Fremdschluessel
     modul_id             INTEGER       NOT NULL,
     benutzer_create      INTEGER       NOT NULL,
     benutzer_deactivate  INTEGER,
     CONSTRAINT fk_modul_id
        FOREIGN KEY (modul_id)
        REFERENCES modul(modul_id)
        ON DELETE CASCADE,
     CONSTRAINT fk_benutzer_create 
        FOREIGN KEY (benutzer_create)
        REFERENCES benutzer(benutzer_id)
        ON DELETE CASCADE,
     CONSTRAINT fk_benutzer_deactivate 
        FOREIGN KEY (benutzer_deactivate)        
        REFERENCES benutzer(benutzer_id)
        ON DELETE CASCADE        
);

-- Primary Key generieren
--CREATE SEQUENCE frage_seq;
CREATE OR REPLACE TRIGGER frage_increment BEFORE INSERT ON frage FOR EACH ROW
BEGIN
  SELECT frage_seq.NEXTVAL
  INTO   :new.frage_id
  FROM   dual;
END;    
/

   
CREATE TABLE uebung (
    uebung_id       INTEGER PRIMARY KEY,
    zeitpunkt       DATE    NOT NULL,
    korrektheit     INTEGER,
    benoetigte_zeit INTEGER,
    --Fremdschlüssel
    benutzer_id     INTEGER NOT NULL,
    frage_id        INTEGER NOT NULL,
    CONSTRAINT fk_benutzer_id
        FOREIGN KEY (benutzer_id)
        REFERENCES benutzer(benutzer_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_frage_id 
        FOREIGN KEY (frage_id)
        REFERENCES frage(frage_id)
        ON DELETE CASCADE    
);

-- Primary Key generieren
--CREATE SEQUENCE uebung_seq;
CREATE OR REPLACE TRIGGER uebung_increment BEFORE INSERT ON uebung FOR EACH ROW
BEGIN
  SELECT uebung_seq.NEXTVAL
  INTO   :new.uebung_id
  FROM   dual;
END;    
/


-- lists all moduls a user is interested in
CREATE TABLE benutzer_modul (
    benutzer_id   INTEGER NOT NULL,
    modul_id      INTEGER NOT NULL,
    UNIQUE (benutzer_id, modul_id),
    CONSTRAINT fk_benutzerM_id
        FOREIGN KEY (benutzer_id)
        REFERENCES benutzer(benutzer_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_modulB_id 
        FOREIGN KEY (modul_id)
        REFERENCES modul(modul_id)
        ON DELETE CASCADE    
);