package Entities;


import Datatypes.Minutes;
import javax.swing.text.Document;


public class Frage {

    //Attrubutes
    private Fragenart fragenart;
    private int frageNummer;
    private Minutes loesungszeit;
    private Document fragestellung;
    private Document musterloesung;
    private Boolean isAvailable;


    //Getter and Setter
    public Fragenart getFragenart() {
        return fragenart;
    }

    public int getFrageNummer() {
        return frageNummer;
    }

    public Minutes getLoesungszeit() {
        return loesungszeit;
    }

    public Document getFragestellung() {
        return fragestellung;
    }

    public void setFragestellung(Document fragestellung) {
        this.fragestellung = fragestellung;
    }

    public Document getMusterloesung() {
        return musterloesung;
    }

    public void setMusterloesung(Document musterloesung) {
        this.musterloesung = musterloesung;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //Constructor
    private Frage(int frageNummer, Minutes loesungszeit, Document fragestellung, Document musterloesung, Fragenart fragenart) {
        this.frageNummer = frageNummer;
        this.loesungszeit = loesungszeit;
        this.fragestellung = fragestellung;
        this.musterloesung = musterloesung;
        this.fragenart = fragenart;
        this.isAvailable = true;
    }

    //TODO: Fragenummer darf nicht von jedem änderbar sein... sollte automatisch generieren ~> via DB geregelt später?
    public Frage valueOf(int frageNummer, Minutes loesungszeit, Document fragestellung, Document musterloesung, Fragenart fragenart){
        return new Frage(frageNummer, loesungszeit, fragestellung, musterloesung, fragenart);
    }

}
