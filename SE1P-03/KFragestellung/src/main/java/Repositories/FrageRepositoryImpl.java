package Repositories;

import Datatypes.Minutes;
import Entities.Frage;
import Entities.Fragenart;
import Entities.Modul;
import Services.PersistenceService;
import Services.PersistenceServiceImpl;

import javax.print.attribute.standard.DocumentName;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Louisa on 24.11.2014.
 */
public class FrageRepositoryImpl implements FrageRepository{

    public List<Frage> getRandomQuestion(Modul modul){

        List<Frage> result = new ArrayList<Frage>();
        try {
            PersistenceService database = PersistenceServiceImpl.getInstance();
            ResultSet rSet = database.sendQuery("Select * from kunde LIMIT 10");
            Vector<Vector<String>> vec = database.getResultVector(rSet);

            if (database.hasResults(vec)) {
                    for(int j = 0; j<=vec.size(); j++){
                        int i = 1;

                        int     fragenummer  = Integer.parseInt(vec.get(0).get(i++));
                        Minutes loesungszeit = Minutes.valueOf(Integer.parseInt(vec.get(0).get(i++)));
                        String fragestellung = vec.get(0).get(i++);
                        String musterloesung = vec.get(0).get(i++);
                        int fragenart = Integer.parseInt(vec.get(0).get(i++));
//TODO fragenart muss vom integer zu den Typ Fragenart umgewanderlt werden
//                        Frage frage = Frage.valueOf(fragenummer, loesungszeit, fragestellung, musterloesung, fragenart);
//                        result.add(frage);
                    }
            }

//
            System.out.println(vec.toString());
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
/*public List<String> getListOfQuery(String query) throws Exception
*
*
*
* DbWrapper database = Application.getInstance().database();
  List<String> resultList = database.getListOfQuery("SELECT DISTINCT Level_1 FROM Beobachtunsgebiet");

			*/