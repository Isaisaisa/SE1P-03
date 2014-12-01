package Entities;


/**
 * Created by Louisa on 02.11.2014.
 */
public abstract class Fragenart {
    private int fragenart;

    public abstract int getFragenart();

    public void deactivateQuestion(int frageNummer) {
        //TODO: isAvailable auf false setzen, falls FrageImpl vorhanden.
        //nothing to do here, needs communication with DB -> put into Controller ModulImpl

    }


}
