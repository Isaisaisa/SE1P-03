package Datatypes;

import java.awt.font.NumericShaper;

/**
 * Created by Louisa on 02.11.2014.
 */
public class ProcentType{
    private int procent;

    // getter and setter
    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    // constructor
    private ProcentType(int procent){
        if (procent >= 0 && procent <= 100){
            this.procent = procent;
        }else{
            throw new IllegalArgumentException("This number is not in range");
        }
    }

    public ProcentType valueOf(int procent){
        return new ProcentType(procent);
    }

    public int value() {
        return procent;
    }

    // basic functions
    public int compareTo(ProcentType other) {
        return Integer.compare(this.value(), other.value());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcentType)) {
            return false;
        }
        return this.compareTo((ProcentType) other) == 0;
    }

    @Override
    public int hashCode() {
        return procent;
    }
}
