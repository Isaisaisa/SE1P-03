package Interface;

import java.util.List;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface KFragebearbeitungService {

    /**
     * generates a Task of question from KFragestellungService
     * @param modul (KModulService)
     * @return a List with Elements from KFragestellungService
     * @pre the passed parameter modul exists
     */
    public List<KFragestellungService> generateTask(KModulService modul);

    /**
     * gets a integer number of all correct answered question
     * @return integer number between minimum 0 and maximum "number of question in task"
     */
    public int getAllCorrectAnswer();

    /**
     * gets a integer number of all incorrect answered question
     * @return integer number between minimum 0 and maximum "number of question in task"
     */
    public int getAllInCorrectAnswer();

}
