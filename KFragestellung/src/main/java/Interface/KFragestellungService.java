package Interface;
//TODO evtl. falscher Import
import Entities.BinaereAnkreuzFrage;
import Entities.MultipleChoiceFrage;
import Entities.SingleChoiceFrage;

import javax.swing.text.Document;

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

