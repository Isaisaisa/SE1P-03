

import Datatypes.EmailTyp;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Louisa on 02.11.2014.
 */
public class TestEmailTyp {

    @Test
    public void blaTest() {
        EmailTyp mail1 = EmailTyp.valueOf("abd@blubb.de");
        EmailTyp mail2 = mail1;
        EmailTyp mail3 = EmailTyp.valueOf("test@web.de");
        EmailTyp mail4 = EmailTyp.valueOf("abd@blubb.de");

        assertEquals(true, mail1.equals(mail2));
        assertEquals(false, mail1.equals(mail3));
        assertEquals(0, mail1.compareTo(mail2));
        assertTrue(mail1.compareTo(mail3) < 0);
        assertTrue(mail3.compareTo(mail2) > 0);
        assertEquals(true, mail1.equals(mail4));
        assertEquals(true, EmailTyp.test("marlene.klausen@aol.de"));
        assertEquals(false, EmailTyp.test("marlene.klausen@--?.de"));
        assertEquals(false, EmailTyp.test(".marlene.klausen@aol.de.com.po"));
        assertEquals(true, EmailTyp.test("mm@o-hamburg.de"));
        }
}
