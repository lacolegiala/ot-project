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
    public void moneyCharge() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo()==5);
    }
    
    @Test
    public void notEnoughMoney() {
        kortti.otaRahaa(15);
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void returnBoolean() {
        assertEquals(kortti.otaRahaa(5), true);
        assertEquals(kortti.otaRahaa(15), false);
    }
}
