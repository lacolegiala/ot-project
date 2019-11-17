package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    
    Kassapaate pääte;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void defaultBalanceOk() {
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void moneyLoadOk() {
        kortti.lataaRahaa(20);
        assertTrue(kortti.saldo()==30);
    }
    
    @Test
    public void moneyChargeOk() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo()==5);
        kortti.otaRahaa(15);
        kortti.lataaRahaa(1000);
        assertTrue(kortti.saldo()==1005);
        assertEquals("saldo: 10.5", kortti.toString());
        kortti.otaRahaa(1000);
        kortti.lataaRahaa(7000);
        assertEquals(kortti.otaRahaa(9000), false);
        assertEquals(kortti.otaRahaa(5000), true);
    }
}
