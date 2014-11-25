--Bsp.Daten Module
INSERT INTO MODUL (NAME, DEPARTMENT) VALUES ('SE1', 'T+I');
INSERT INTO MODUL (NAME, DEPARTMENT) VALUES ('AD', 'T+I');
INSERT INTO MODUL (NAME, DEPARTMENT) VALUES ('GKA', 'T+I');
INSERT INTO MODUL (NAME, DEPARTMENT) VALUES ('BS', 'T+I');
INSERT INTO MODUL (NAME, DEPARTMENT) VALUES ('BW2', 'T+I');


--Bsp.Daten Benutzer
--TODO: PASSWORT VERSCHLUESSELN
INSERT INTO BENUTZER (VORNAME, NACHNAME, BENUTZERNAME, EMAIL, PASSWORT) 
  VALUES ('Louisa', 'Spahl', 'loulouham', 'louisa.spahl@haw-hamburg.de', 'Test1');

INSERT INTO BENUTZER (VORNAME, NACHNAME, BENUTZERNAME, EMAIL, PASSWORT)
  VALUES ('Marjan', 'Bachtiari', 'Shivon', 'marjan.bachtiari@haw-hamburg.de', 'Test2');
  
INSERT INTO BENUTZER (VORNAME, NACHNAME, BENUTZERNAME, EMAIL, PASSWORT)
  VALUES ('Maria', 'Musterfrau', 'MariaM', 'm.muster@gmail.com', '879Test8432/()');
  

--Bsp.Daten Module, f�r die sich Benutzer interessiert  
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (24, 46);
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (24, 48);
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (24, 50);

INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (25, 46);
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (25, 47);
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (25, 48);
INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (25, 50);

INSERT INTO BENUTZER_MODUL (BENUTZER_ID, MODUL_ID) VALUES (26, 49);


--Bsp.Daten Fragen
INSERT INTO FRAGE (FRAGE_NR, LOESUNGSZEIT, FRAGESTELLUNG, MUSTERLOESUNG, FRAGENART, IS_VALID, MODUL_ID, BENUTZER_CREATE)
  VALUES (1, 15, 'Geben Sie ein Beispiel f�r eine User Story in einem Lernprogramm.', 
    'Ich, als Student, logge mich ein.', 3, 'Y', 46, 25);
    
INSERT INTO FRAGE (FRAGE_NR, LOESUNGSZEIT, FRAGESTELLUNG, MUSTERLOESUNG, FRAGENART, IS_VALID, MODUL_ID, BENUTZER_CREATE)
  VALUES (2, 30, 'Schreiben Sie in Pseudo-Code den Dijkstra-Algorithmus auf.', 
    'Funktion Dijkstra(Graph, Startknoten):
    initialisiere(Graph,Startknoten,abstand[],vorg�nger[],Q)
    solange Q nicht leer:                       // Der eigentliche Algorithmus
        u := Knoten in Q mit kleinstem Wert in abstand[]
        entferne u aus Q                                // f�r u ist der k�rzeste Weg nun bestimmt
        f�r jeden Nachbarn v von u:
            falls v in Q:
               distanz_update(u,v,abstand[],vorg�nger[])   // pr�fe Abstand vom Startknoten zu v
    return vorg�nger[]

Methode initialisiere(Graph,Startknoten,abstand[],vorg�nger[],Q):
    f�r jeden Knoten v in Graph:
        abstand[v] := unendlich
        vorg�nger[v] := null
    abstand[Startknoten] := 0
    Q := Die Menge aller Knoten in Graph

Methode distanz_update(u,v,abstand[],vorg�nger[]):
    alternativ := abstand[u] + abstand_zwischen(u, v)   // Wegl�nge vom Startknoten nach v �ber u
    falls alternativ < abstand[v]:
        abstand[v] := alternativ
        vorg�nger[v] := u

Funktion erstelleK�rzestenPfad(Zielknoten,vorg�nger[])
	Weg[] := [Zielknoten]
   	u := Zielknoten
   	solange vorg�nger[u] nicht null:   // Der Vorg�nger des Startknotens ist null
       u := vorg�nger[u]
       f�ge u am Anfang von Weg[] ein
	return Weg[]', 3, 'Y', 48, 25);
  
INSERT INTO FRAGE (FRAGE_NR, LOESUNGSZEIT, FRAGESTELLUNG, MUSTERLOESUNG, FRAGENART, IS_VALID, MODUL_ID, BENUTZER_CREATE)
  VALUES (3, 30, 'Nennen Sie 5 Schritte der Software-Entwicklung.', 
    'Analyse, Spezifikation, Entwurf, Implementierung, Test', 3, 'Y', 46, 24);
    
INSERT INTO FRAGE (FRAGE_NR, LOESUNGSZEIT, FRAGESTELLUNG, MUSTERLOESUNG, FRAGENART, IS_VALID, MODUL_ID, BENUTZER_CREATE)
  VALUES (4, 15, 'Nennen Sie ein Basis-Merkmal und ein Leistungs-Merkmal f�r ein Smartphone.', 
    'Beispiele Basis-Merkmal: Man kann damit telefonieren, es hat einen Touch-Screen, es ist Internet-f�hig.
    Beispiele Leistungs-Merkmal: LTE-f�hig, besonders lange Akkulaufzeit, Verarbeitung von Aluminium statt Plastik.', 3, 'Y', 46, 25);