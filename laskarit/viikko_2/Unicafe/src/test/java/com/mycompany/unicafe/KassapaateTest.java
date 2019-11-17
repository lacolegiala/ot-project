/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate pääte;
    
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        pääte = new Kassapaate();
        kortti = new Maksukortti(2000);
    }
    
    @Test
    public void defaultMoneySumOk() {
        assertTrue(pääte.kassassaRahaa==100000);
    }
    
    @Test
    public void cashPaymentOk() {
        pääte.syoEdullisesti(250);
        assertTrue(pääte.kassassaRahaa==100240);
        assertEquals(10, pääte.syoEdullisesti(250));
        pääte.syoEdullisesti(230);
        assertEquals(230, pääte.syoEdullisesti(230));
        assertTrue(pääte.kassassaRahaa==100480);
        assertEquals(2, pääte.edullisiaLounaitaMyyty());
        pääte.syoMaukkaasti(410);
        assertTrue(pääte.kassassaRahaa==100880);
        assertEquals(10, pääte.syoMaukkaasti(410));
        assertEquals(390, pääte.syoMaukkaasti(390));
        pääte.syoMaukkaasti(390);
        assertTrue(pääte.kassassaRahaa==101280);
        assertEquals(2, pääte.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void cardChargeHighBalance() {
        assertEquals(pääte.syoEdullisesti(kortti), true);
        assertTrue(kortti.saldo()==1760);
        assertEquals(pääte.syoMaukkaasti(kortti), true);
        assertTrue(kortti.saldo()==1360);
    }
    
    @Test
    public void cardChargeLunchSaleSum() {
        pääte.syoEdullisesti(kortti);
        assertEquals(1, pääte.edullisiaLounaitaMyyty());
        pääte.syoMaukkaasti(kortti);
        assertEquals(1, pääte.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void cardChargeLowBalance() {
        kortti.otaRahaa(1900);
        assertEquals(pääte.syoEdullisesti(kortti), false);
        assertTrue(kortti.saldo()==100);
        assertEquals(0, pääte.edullisiaLounaitaMyyty());
        assertEquals(pääte.syoMaukkaasti(kortti), false);
        assertTrue(kortti.saldo()==100);
        assertEquals(0, pääte.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void cardChargeCashRegister() {
        pääte.syoEdullisesti(kortti);
        pääte.syoMaukkaasti(kortti);
        assertTrue(pääte.kassassaRahaa()==100000);
    }
    
    @Test
    public void cardMoneyLoad() {
        pääte.lataaRahaaKortille(kortti, 1000);
        assertTrue(pääte.kassassaRahaa()==101000);
        assertTrue(kortti.saldo()==3000);
        pääte.lataaRahaaKortille(kortti, -1000);
        assertTrue(pääte.kassassaRahaa()==101000);
        assertTrue(kortti.saldo()==3000);
    }

}
