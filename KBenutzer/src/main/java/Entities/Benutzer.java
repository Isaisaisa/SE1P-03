package Entities;

import Datatypes.*;
import java.awt.*;

/**
 * Created by Louisa on 02.11.2014.
 */
public class Benutzer {
    // declaration
    private String name;
    private String vorname;
    private EmailTyp email;
    private String benutzername;
    private PasswordType passwort;
    private int berechtigung;
    private Image anzeigebild;

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public EmailTyp getEmail() {
        return email;
    }

    public void setEmail(EmailTyp email) {
        this.email = email;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public PasswordType getPasswort() {
        return passwort;
    }

    public void setPasswort(PasswordType passwort) {
        this.passwort = passwort;
    }

    public int getBerechtigung() {
        return berechtigung;
    }
//
//    public void setBerechtigung(int berechtigung) {
//        this.berechtigung = berechtigung;
//    }

    public Image getAnzeigebild() {
        return anzeigebild;
    }

    public void setAnzeigebild(Image anzeigebild) {
        this.anzeigebild = anzeigebild;
    }


    //Constructor
    private Benutzer(String name, String vorname, EmailTyp email,String benutzername, PasswordType passwort, int berechtigung, Image anzeigebild) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.berechtigung = berechtigung;
        this.anzeigebild = anzeigebild;
    }

    public Benutzer valueOf(String name, String vorname, EmailTyp email,String benutzername, PasswordType passwort, int berechtigung, Image anzeigebild){
        return new Benutzer(name, vorname, email, benutzername, passwort, berechtigung, anzeigebild);
    }


}
