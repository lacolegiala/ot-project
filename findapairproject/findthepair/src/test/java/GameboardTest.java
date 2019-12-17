/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.findthepair.Gameboard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofiariekkola
 */
public class GameboardTest {
    
    Gameboard gameboard;
    
    @Before
    public void setUp() {
        this.gameboard = new Gameboard(4, 5);
    }
    
    @Test
    public void gameboardCorrectSize() {
        assertEquals(gameboard.getRows(), 4);
        assertEquals(gameboard.getColumns(), 5);
    }
    
    @Test
    public void emptyBoard() {
        Gameboard gameboard = new Gameboard(0, 0);
        assertEquals(gameboard.boardHasCards(), false);
    }
    
    @Test
    public void boardNotEmpty() {
        assertEquals(gameboard.boardHasCards(), true);
    }
    
    @Test
    public void rightPairCount() {
        assertEquals(gameboard.getPairCount(), 10);
    }
    
    @Test
    public void cardsRemoved() {
        gameboard.removeCards(0, 0, 1, 0);
        assertEquals(gameboard.getBoard()[0][0], null);
        assertEquals(gameboard.getBoard()[1][0], null);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
