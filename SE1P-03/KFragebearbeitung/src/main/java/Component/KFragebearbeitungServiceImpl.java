package Component;

import Entities.Frage;
import Entities.Uebung;
import Interface.KFragebearbeitungService;
import Interface.KFragestellungService;
import Interface.KModulService;
import Services.PersistenceService;

import java.util.List;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class KFragebearbeitungServiceImpl implements KFragebearbeitungService {

    public KFragebearbeitungServiceImpl(PersistenceService persistenceService, KFragestellungService fragestellung, KModulService modul) {

    }

    @Override
    public List<Frage> generateTask(KModulService modul) {
        return null;
    }

    @Override
    public int getAllCorrectAnswer() {
        return 0;
    }

    @Override
    public int getAllInCorrectAnswer() {
        return 0;
    }

    @Override
    public void save(Uebung uebung) {

    }
}
