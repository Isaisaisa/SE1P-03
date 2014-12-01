package Entities;

import Datatypes.LaengeDerPruefungTyp;
import Datatypes.ProcentType;

import java.util.Date;

/**
 * Created by Louisa on 02.11.2014.
 */
public class PruefungImpl {
    private Date pruefungsbeginn;  //ehemals zeitstempel in UML
    private Date pruefungsende;
    private ProcentType korrektheit;
    private LaengeDerPruefungTyp laengeDerPruefung;

    //Länge der Prüfung befindet sich im Enum LaengeDerPruefungEnum


    // Getter and setter
    public Date getPruefungsbeginn() {
        return pruefungsbeginn;
    }

    public void setPruefungsbeginn(Date pruefungsbeginn) {
        this.pruefungsbeginn = pruefungsbeginn;
    }

    public Date getPruefungsende() {
        return pruefungsende;
    }

    public void setPruefungsende(Date pruefungsende) {
        this.pruefungsende = pruefungsende;
    }

    public ProcentType getKorrektheit() {
        return korrektheit;
    }

    public void setKorrektheit(ProcentType korrektheit) {
        this.korrektheit = korrektheit;
    }

    public long getBenoetigteZeit() {
        long benoetigteZeitInMilisekunden = pruefungsende.getTime() - pruefungsbeginn.getTime();
        // returns needed time in minutes
        return benoetigteZeitInMilisekunden / 1000 / 60;
    }

    private void setLaengeDerPruefung(LaengeDerPruefungTyp laengeDerPruefung) {
        this.laengeDerPruefung = laengeDerPruefung;
    }


    // Constructors
    private PruefungImpl(LaengeDerPruefungTyp laengeDerPruefung){
        setLaengeDerPruefung(laengeDerPruefung);
    }

    private PruefungImpl(Date pruefungsbeginn, Date pruefungsende, ProcentType korrektheit, LaengeDerPruefungTyp laengeDerPruefung){
        setPruefungsbeginn(pruefungsbeginn);
        setPruefungsende(pruefungsende);
        setKorrektheit(korrektheit);
        setLaengeDerPruefung(laengeDerPruefung);
    }

    public static PruefungImpl valueOf(LaengeDerPruefungTyp laengeDerPruefung) {
        return new PruefungImpl(laengeDerPruefung);
    }

    public static PruefungImpl valueOf(Date pruefungsbeginn, Date pruefungsende, ProcentType korrektheit, LaengeDerPruefungTyp laengeDerPruefung) {
        return new PruefungImpl(pruefungsbeginn, pruefungsende, korrektheit, laengeDerPruefung);
    }

    //TODO: IMPORTANT: while generating PruefungImpl/ UebungImpl we need to check if the questions are available!!!
}
