DROP TABLE frage_uebung;
DROP TABLE uebung;
DROP TABLE frage;
DROP TABLE benutzer_modul;
DROP TABLE benutzer;
DROP TABLE modul;


-- a little edit meanwhile...
ALTER TABLE FRAGE MODIFY (MUSTERLOESUNG VARCHAR(1500));
DELETE FROM FRAGE WHERE FRAGE_ID = 2;