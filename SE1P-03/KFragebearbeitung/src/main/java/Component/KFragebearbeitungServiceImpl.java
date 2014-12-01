package Component;

import Interface.KFragebearbeitungService;
import Interface.KFragestellungService;
import Interface.KModulService;
import Services.PersistenceService;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class KFragebearbeitungServiceImpl implements KFragebearbeitungService {

    //Attributs
    private PersistenceService persistenceService;
    private KFragestellungService fragestellung;
    private KModulService modul;

    public KFragebearbeitungServiceImpl(PersistenceService persistenceService, KFragestellungService fragestellung, KModulService modul) {
        this.persistenceService = persistenceService;
        this.fragestellung = fragestellung;
        this.modul = modul;
    }


}
