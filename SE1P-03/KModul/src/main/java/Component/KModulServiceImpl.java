package Component;

import Interface.Modul;
import Interface.KModulService;
import Services.PersistenceService;

import java.util.List;


/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class KModulServiceImpl implements KModulService {


    public KModulServiceImpl(PersistenceService persistenceService) {

    }

    @Override
    public List<Modul> getModule(int benutzerNummer) {
        return null;
    }
}
