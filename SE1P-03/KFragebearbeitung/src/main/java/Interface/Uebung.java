package Interface;

import Datatypes.ProcentType;

import java.util.Date;

/**
 * Created by Louisa on 01.12.2014.
 */
public interface Uebung {

    public Date getUebungsbeginn();
    public Date getUebungsende();
    public ProcentType getKorrektheit();
    public int getId();

}
