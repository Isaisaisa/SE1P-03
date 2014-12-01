package Entities;

import Interface.Forumseintrag;

import java.util.Date;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class ForumseintragImpl implements Forumseintrag{
    // Declaration
    private String frage;
    private Date zeitstempel;

    // Getter and Setter
    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public Date getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    // Constructor
    private ForumseintragImpl(String frage) {
        this(frage, new Date());
    }

    private ForumseintragImpl(String frage, Date zeitstempel) {
        this.frage = frage;
        this.zeitstempel = zeitstempel;
    }

    public ForumseintragImpl valueOf(String frage) { return new ForumseintragImpl(frage); }
    public ForumseintragImpl valueOf(String frage, Date zeitstempel) {
        return new ForumseintragImpl(frage, zeitstempel);
    }
}
