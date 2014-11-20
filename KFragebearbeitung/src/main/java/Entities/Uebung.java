package Entities;

import Datatypes.ProcentType;
import java.util.Date;

/**
 * Created by Louisa on 02.11.2014.
 */
public class Uebung {

    private Date uebungsbeginn;
    private Date uebungsende;
    private ProcentType korrektheit;

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


    private Uebung() {

    }

    private Uebung(Date uebungsbeginn, Date uebungsende, ProcentType korrektheit){
        setUebungsbeginn(uebungsbeginn);
        setUebungsende(uebungsende);
        setKorrektheit(korrektheit);
    }

    public static Uebung valueOf() {
        return new Uebung();
    }

    public static Uebung valueOf(Date uebungsbeginn, Date uebungsende, ProcentType korrektheit){
        return new Uebung(uebungsbeginn, uebungsende, korrektheit);
    }

    //TODO: IMPORTANT: while generating Pruefung/ Uebung we need to check if the questions are available!!!
}
