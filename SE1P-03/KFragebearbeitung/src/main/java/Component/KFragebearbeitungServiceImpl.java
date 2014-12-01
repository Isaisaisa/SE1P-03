package Component;

import Datatypes.ProcentType;
import Entities.UebungImpl;
import Interface.*;
import Services.PersistenceService;
import Services.PersistenceServiceImpl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public Date getZeit(){
//        SimpleDateFormat formatter = new SimpleDateFormat(
//                "dd.MM.yyyy - HH:mm ");
        Date currentTime = new Date();
        return currentTime;
//        System.out.println(formatter.format(currentTime));        // "yyyy.MM.dd - HH:mm:ss    2012.04.14 - 21:34:07
    }

    //TODO ist das wirklich richtig?
    @Override
    public Uebung generateUebung(Modul modul) {
        List<Frage> fragen = fragestellung.getZufallsFragen(modul);
        Uebung uebung = UebungImpl.valueOf(getZeit(), null, ProcentType.valueOf(0), fragen);
        return uebung;
    }

    @Override
    public void saveUebung(Uebung uebung) {

//        PersistenceService database = PersistenceServiceImpl.getInstance();
//        ResultSet rSet = database.sendUpdate("INSERT INTO uebung");
    }

    @Override
    public Frage nextFrage() {
        return null;
    }
}
