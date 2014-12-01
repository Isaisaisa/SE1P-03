package Interface;
//TODO evtl. falscher Import
import Entities.*;

import javax.swing.text.Document;
import java.util.List;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface KFragestellungService {
    /**
     * Shows correct Answer which is the sample solution of the question
     *
     * @param frageNummer: unique number of a question
     * @return a String with the sample solution
     * @pre the question-number exists in Database
     */
    public String getRichtigeAntwort(int frageNummer);

    /**
     * Gets a number of random questions of the specified Modul
     *
     * @param modul
     * @return a list of questions
     * @pre Modul exists
     */
    public List<Frage> getZufallsFragen(Modul modul);


}

