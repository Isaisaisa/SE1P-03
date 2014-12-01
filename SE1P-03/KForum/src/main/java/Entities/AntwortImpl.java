package Entities;

import Interface.Antwort;

import java.util.Date;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class AntwortImpl implements Antwort{
    // Declaration
    private String antwort;
    private Date zeitstempel;

    // Getter and Setter
    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public Date getZeitstempel() {
        return zeitstempel;
    }
    
    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    // Constructor
    private AntwortImpl(String antwort) {
        this(antwort, new Date());
    }

    private AntwortImpl(String antwort, Date zeitstempel) {
        this.antwort = antwort;
        this.zeitstempel = zeitstempel;
    }

    public AntwortImpl valueOf(String antwort) { return new AntwortImpl(antwort); }
    public AntwortImpl valueOf(String antwort, Date zeitstempel) {
        return new AntwortImpl(antwort,zeitstempel);
    }
}
