package Interface;


import Datatypes.EmailTyp;
import Entities.Modul;

import java.util.List;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface KModulService {

    /**
     * shows all Moduls of a unser, who is authorized by its email
     * @param email (EmailTyp)
     * @return List<KModulService>
     * @pre valid email-adresse
     */
    public List<Modul> showModuls(EmailTyp email);
}
