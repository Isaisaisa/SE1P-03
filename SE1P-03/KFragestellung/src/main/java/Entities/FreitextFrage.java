package Entities;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class FreitextFrage extends Fragenart {

    private FreitextFrage(){
        getFragenart();
    }

    public static FreitextFrage valueOf(){
        return new FreitextFrage();
    }

    @Override
    public  int getFragenart() {
        return 3;
    }
}
