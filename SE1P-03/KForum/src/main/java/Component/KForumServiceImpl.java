package Component;

import Interface.KForumService;
import Interface.KModulService;
import Services.PersistenceService;

import javax.swing.text.Document;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class KForumServiceImpl implements KForumService {


    public KForumServiceImpl(PersistenceService persistenceService, KModulService modul) {
    }

    @Override
    public boolean addQuestion(Document question) {
        return false;
    }

    @Override
    public boolean deaktivateQuestion(int number) {
        return false;
    }
}
