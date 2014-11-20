package Datatypes;

/**
 * Created by Louisa on 02.11.2014.
 */
public class LaengeDerPruefungTyp {
    LaengeDerPruefungEnum laenge;

    private LaengeDerPruefungTyp(LaengeDerPruefungEnum laenge){
        this.laenge = laenge;
    }

    public LaengeDerPruefungTyp valueOf(LaengeDerPruefungEnum laenge){
        return new LaengeDerPruefungTyp(laenge);
    }

    public int laengeInMinuten() {
        switch (laenge){
            case SHORT_FORTYFIVE:
              return 45;

            case LONG_NINETY:
                return 90;

            default:
                return 0;
        }
    }

    // basic functions
    public int compareTo(LaengeDerPruefungTyp other) {
        return Integer.compare(this.laengeInMinuten(), other.laengeInMinuten());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LaengeDerPruefungEnum)) {
            return false;
        }
        return this.compareTo((LaengeDerPruefungTyp) other) == 0;
    }

    @Override
    public int hashCode() {
        return laenge.hashCode();
    }
}
