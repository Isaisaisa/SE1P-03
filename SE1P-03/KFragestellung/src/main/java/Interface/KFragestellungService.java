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
     * @param frageNummer (int)
     * @return a Document with the sample solution
     * @pre the question with its question-number exists
     */
    public Document showCorrectAnswer(int frageNummer);

    /**
     * Gets a number of random questions of the specified Modul
     * @param modul (Modul)
     * @return a list of questions
     * @pre Modul exists
     */
    public List<Frage> getRandomQuestion(Modul modul);

    /**
     * if answer is correct it returns true otherwise false
     * @param frage (MultipleChoiceFrage)
     * @return true if answer is correct, false if not
     * @pre the question is a multiple choice question
     */
    public boolean isAnswerCorrect(MultipleChoiceFrage frage);

    /**
     * if answer is correct it returns true otherwise false
     * @param frage (SingleChoiceFrage)
     * @return true if answer is correct, false if not
     * @pre the question is a single choice question
     */
    public boolean isAnswerCorrect(SingleChoiceFrage frage);

    /**
     * if answer is correct it returns true otherwise false
     * @param frage (BinaereAnkreuzFrage)
     * @return true if answer is correct, false if not
     * @pre the question is a polar question (Entscheidungsfrage bzw. Binärefrage)
     */
    public boolean isAnswerCorrect(BinaereAnkreuzFrage frage);
}

