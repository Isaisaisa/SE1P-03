package Interface;

import javax.swing.text.Document;

/**
 * Created by Louisa on 03.11.2014.
 */
public interface KForumService {

    /**
     * add the passed question to the Forum
     * @param question
     * @return true if it was added without problems otherwise false
     */
    public boolean addQuestion(String question);

    /**
     * deactivates a question in Forum
     * @param number (int)
     * @return true if it's deactivated correctly, otherwise false
     */
    public boolean deaktivateQuestion(int number);

}
