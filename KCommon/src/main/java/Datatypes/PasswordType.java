package Datatypes;

import java.util.regex.Pattern;

/**
 * Created by Louisa on 02.11.2014.
 */
public class PasswordType {

    private String passwort;

    //getter and setter

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    private PasswordType(String passwort){
        this.passwort = passwort;
    }

    public static PasswordType valueOf(String passwort){
        //http://www.php.de/php-fortgeschrittene/20982-regex-auf-starkes-passwort-und-erlaubte-zeichen-pruefen.html
        // help to understanding regex: http://www.regenechsen.de/phpwcms/index.php?id=2,0,0,1,0,0
        boolean tmp = Pattern.matches("%^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{6,15}$%", passwort);

        if (tmp){
            return new PasswordType(passwort);
        }
        throw new IllegalArgumentException("not a valid password");
    }

    // basic functions
    public int compareTo(PasswordType other) {
        return this.toString().compareTo(other.toString());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof PasswordType)) { return false; }
        return this.compareTo((PasswordType) other) == 0;
    }

    @Override
    public int hashCode() {
        return passwort.hashCode();
    }
}
