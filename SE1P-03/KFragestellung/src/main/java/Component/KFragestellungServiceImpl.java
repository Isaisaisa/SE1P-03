package Component;

import Datatypes.Minutes;
import Entities.*;
import Interface.Frage;
import Interface.KFragestellungService;
import Interface.KModulService;
import Interface.Modul;
import Repositories.FrageRepository;
import Repositories.FrageRepositoryImpl;
import Services.PersistenceService;
import Services.PersistenceServiceImpl;

import javax.swing.text.Document;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Louisa on 01.12.2014.
 */
public class KFragestellungServiceImpl implements KFragestellungService {

    public KFragestellungServiceImpl(PersistenceService persistenceService) {
    }

    @Override
    public String getRichtigeAntwort(int frageNummer) {
        String musterloesung = "";

        try {
            PersistenceService database = PersistenceServiceImpl.getInstance();
            //hole die Musterlösung aus der Datebbank, die zu der übergebenen Fragennummer gehört
            musterloesung = database.getSingleValue("Select musterloesung from frage where frage_nr=" + frageNummer);
            database.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return musterloesung;
    }


    @Override
    public List<Frage> getZufallsFragen(Modul modul) {
        List<Frage> result = new ArrayList<Frage>();
        try {
            PersistenceService database = PersistenceServiceImpl.getInstance();
            ResultSet rSet = database.sendQuery("Select * from frage LIMIT 10");
            Vector<Vector<String>> vec = database.getResultVector(rSet);

            if (database.hasResults(vec)) {
                for(int j = 0; j<=vec.size(); j++){
                    int i = 1;

                    //Werte aus der Datenbank holen
                    int     fragenummer  = Integer.parseInt(vec.get(0).get(i++));
                    Minutes loesungszeit = Minutes.valueOf(Integer.parseInt(vec.get(0).get(i++)));
                    String fragestellung = vec.get(0).get(i++);
                    String musterloesung = vec.get(0).get(i++);
                    int fragenartInt = Integer.parseInt(vec.get(0).get(i++));

                    // fragenartInt der Klasse FreitextFrage zuweisen
                    FreitextFrage fragenart = null;

                    switch (fragenartInt) {
                        case 3:  FreitextFrage.valueOf();
                            break;
                        default: ;
                            break;
                    }

                        //Objekt frage erzeugen und dem Rückgabeliste hinzufügen
                        Frage frage = FrageImpl.valueOf(fragenummer, loesungszeit, fragestellung, musterloesung, fragenart);
                        result.add(frage);
                }
            }

            System.out.println(vec.toString());
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
