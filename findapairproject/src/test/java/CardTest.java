/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
