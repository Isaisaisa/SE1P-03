package Datatypes;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class Minutes {
    // declaration
    private int minutes;

    // getter and setter
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    // constructor
    private Minutes(int minutes) {
        if (minutes >= 0) {
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("This number is not in range.");
        }
    }

    public Minutes valueOf(int minutes) {
        return new Minutes(minutes);
    }

    public int value() {
        return minutes;
    }

    // basic functions
    public int compareTo(Minutes other) {
        return Integer.compare(this.value(), other.value());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Minutes)) {
            return false;
        }
        return this.compareTo((Minutes) other) == 0;
    }

    @Override
    public int hashCode() {
        return minutes;
    }

}
