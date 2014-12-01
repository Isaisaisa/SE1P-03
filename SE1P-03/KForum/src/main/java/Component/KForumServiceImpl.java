package Component;

import Interface.KBenutzerService;
import Interface.KForumService;
import Interface.KModulService;
import Services.PersistenceService;

import javax.swing.text.Document;

/**
 * Created by Louisa on 03.11.2014.
 */
public class KForumServiceImpl implements KForumService {


    public KForumServiceImpl(PersistenceService persistenceService, KBenutzerService benutzer, KModulService modul) {
    }

    @Override
    public boolean addQuestion(String question) {
        return false;
    }

    @Override
    public boolean deaktivateQuestion(int number) {
        return false;
    }
}
