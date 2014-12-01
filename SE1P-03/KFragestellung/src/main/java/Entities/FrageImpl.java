package Entities;


import Datatypes.Minutes;


public class FrageImpl {

    //Attrubutes
    private Fragenart fragenart;
    private int frageNummer;
    private Minutes loesungszeit;
    private String fragestellung;
    private String musterloesung;
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

    public String getFragestellung() {
        return fragestellung;
    }

    public void setFragestellung(String fragestellung) {
        this.fragestellung = fragestellung;
    }

    public String getMusterloesung() {
        return musterloesung;
    }

    public void setMusterloesung(String musterloesung) {
        this.musterloesung = musterloesung;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //Constructor
    public FrageImpl(int frageNummer, Minutes loesungszeit, String fragestellung, String musterloesung, Fragenart fragenart) {
        this.frageNummer = frageNummer;
        this.loesungszeit = loesungszeit;
        this.fragestellung = fragestellung;
        this.musterloesung = musterloesung;
        this.fragenart = fragenart;
        this.isAvailable = true;
    }

    //TODO: Fragenummer darf nicht von jedem änderbar sein... sollte automatisch generieren ~> via DB geregelt später?
    public static FrageImpl valueOf(int frageNummer, Minutes loesungszeit, String fragestellung, String musterloesung, Fragenart fragenart){
        return new FrageImpl(frageNummer, loesungszeit, fragestellung, musterloesung, fragenart);
    }

}
