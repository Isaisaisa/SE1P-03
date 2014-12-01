package Interface;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface KFragebearbeitungService {

    /**
     * generates a Task of question from KFragestellungService
     * @param modul: an existing Modul from KModul
     * @return an Uebung with question from KFragestellungService
     * @pre the passed parameter modul exists
     */
    public Uebung generateUebung(Modul modul);


    /**
     * saves the results of the task.
     * The number of right and wrong questions are saved with integers.
     * @param uebung
     */
    public void saveUebung(Uebung uebung, Benutzer benutzer);


    /**
     * switch to the next question.
     * @return the next question. If no next question return null.
     */
    public Frage nextFrage();

}
