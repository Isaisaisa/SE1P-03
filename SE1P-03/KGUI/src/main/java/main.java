
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
        KModulService modul = new KModulServiceImpl(persistenceService);
        KFragestellungService fragestellung = new KFragestellungServiceImpl(persistenceService, modul);
        fragestellung.getRandomQuestion(null);
        KForumService forum = new KForumServiceImpl(persistenceService, modul);
        KFragebearbeitungService fragebearbeitung = new KFragebearbeitungServiceImpl(persistenceService, fragestellung, modul);
        KBenutzerService benutzer = new KBenutzerServiceImpl(persistenceService, modul, fragestellung, forum, fragebearbeitung);

        //persistenceService.readFile();
        //persistenceService.connect();
    }

}
