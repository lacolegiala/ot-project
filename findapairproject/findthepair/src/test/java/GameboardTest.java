/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.findthepair.Gameboard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        this.gameboard = new Gameboard(3, 5);
    }
    
    @Test
    public void gameboardCorrectSize() {
        assertEquals(gameboard.getRows(), 3);
        assertEquals(gameboard.getColumns(), 5);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
