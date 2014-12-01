package Entities;

import Datatypes.ProcentType;
import Interface.Frage;
import Interface.Uebung;

import java.util.Date;
import java.util.List;

/**
 * Created by Louisa on 02.11.2014.
 */
public class UebungImpl implements Uebung{

    private Date uebungsbeginn;
    private Date uebungsende;
    private ProcentType korrektheit;
    private List<Frage> fragen;

    // getter and setter
    public Date getUebungsbeginn() {
        return uebungsbeginn;
    }

    public void setUebungsbeginn(Date uebungsbeginn) {
        this.uebungsbeginn = uebungsbeginn;
    }

    public Date getUebungsende() {
        return uebungsende;
    }

    public void setUebungsende(Date uebungsende) {
        this.uebungsende = uebungsende;
    }

    public ProcentType getKorrektheit() {
        return korrektheit;
    }

    public void setKorrektheit(ProcentType korrektheit) {
        korrektheit = korrektheit;
    }

    public long getBenoetigteZeit() {
        long benoetigteZeitInMilisekunden = uebungsende.getTime() - uebungsbeginn.getTime();
        // returns needed time in minutes
        return benoetigteZeitInMilisekunden / 1000 / 60;
    }


    private UebungImpl() {

    }

    private UebungImpl(Date uebungsbeginn, Date uebungsende, ProcentType korrektheit, List<Frage> fragen){
        setUebungsbeginn(uebungsbeginn);
        setUebungsende(uebungsende);
        setKorrektheit(korrektheit);
        this.fragen = fragen;
    }

    public static UebungImpl valueOf() {
        return new UebungImpl();
    }

    public static UebungImpl valueOf(Date uebungsbeginn, Date uebungsende, ProcentType korrektheit, List<Frage> fragen){
        return new UebungImpl(uebungsbeginn, uebungsende, korrektheit, fragen);
    }

}
