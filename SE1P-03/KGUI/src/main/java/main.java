
import Component.*;
import Interface.*;
import Services.PersistenceService;
import Services.PersistenceServiceImpl;

/**
 * Created by Louisa on 02.11.2014.
 */
public class main {

    public static void main(String[] args) throws Exception {
        PersistenceService persistenceService = PersistenceServiceImpl.getInstance();
        KBenutzerService benutzer = new KBenutzerServiceImpl(persistenceService);
        KModulService modul = new KModulServiceImpl(persistenceService);
        KFragestellungService fragestellung = new KFragestellungServiceImpl(persistenceService);
        //fragestellung.getRandomQuestion(null);
        KForumService forum = new KForumServiceImpl(persistenceService, benutzer, modul);
        KFragebearbeitungService fragebearbeitung = new KFragebearbeitungServiceImpl(persistenceService, benutzer, fragestellung, modul);

        //persistenceService.readFile();
        //persistenceService.connect();
    }

}
