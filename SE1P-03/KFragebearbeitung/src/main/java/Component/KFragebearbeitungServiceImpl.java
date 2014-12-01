package Component;

import Datatypes.ProcentType;
import Entities.UebungImpl;
import Interface.*;
import Services.PersistenceService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Louisa on 03.11.2014.
 */
public class KFragebearbeitungServiceImpl implements KFragebearbeitungService {

    //Attributs
    private PersistenceService persistenceService;
    private KBenutzerService benutzer;
    private KFragestellungService fragestellung;
    private KModulService modul;

    public KFragebearbeitungServiceImpl(PersistenceService persistenceService, KBenutzerService benutzer, KFragestellungService fragestellung, KModulService modul) {
        this.persistenceService = persistenceService;
        this.benutzer = benutzer;
        this.fragestellung = fragestellung;
        this.modul = modul;
    }

    public Date getZeit(){
        Date currentTime = new Date();
        return currentTime;
    }


    @Override
    public Uebung generateUebung(Modul modul) {
        List<Frage> fragen = fragestellung.getZufallsFragen(modul);
        Uebung uebung = UebungImpl.valueOf(1, getZeit(), null, ProcentType.valueOf(0), fragen);
        return uebung;
    }


    @Override
    public void saveUebung(Uebung uebung, Benutzer benutzer) {
        int uebungsId = uebung.getId();
        Date uebungsAnfang = uebung.getUebungsbeginn();
        Date uebungsEnde = uebung.getUebungsende();
        int benoetigteZeit = (int)(uebungsEnde.getTime() - uebungsAnfang.getTime());
        int benutzerID = benutzer.getId();
        int korrektheit = uebung.getKorrektheit().value();


        try {
            Date d = new SimpleDateFormat("dd/MMM/yyyy").parse(uebungsAnfang.toString());
            java.sql.Date uebungAnfangFormatted = new java.sql.Date(d.getTime());
            this.persistenceService.sendUpdate(String.format(
                    "INSERT INTO uebung (uebung_id, zeitpunkt, korrektheit, benoetigte_zeit, benutzer_id) VALUES ('%d', '%s', '%d', '%d', '%d')",
                    uebungsId, uebungAnfangFormatted, korrektheit, benoetigteZeit, benutzerID));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Frage nextFrage() {
        return null;
    }
}
