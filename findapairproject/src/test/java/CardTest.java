import com.mycompany.findthepair.domain.Card;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofiariekkola
 */
public class CardTest {
    
    Card card;
    
    @Before
    public void setUp() {
        card = new Card(2);
    }
    
    @Test
    public void cardRightValue() {
        assertEquals(card.getValue(), 2);
    }
    
}
