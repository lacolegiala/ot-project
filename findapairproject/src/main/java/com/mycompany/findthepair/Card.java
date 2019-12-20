/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair;

/**
 *
 * @author sofiariekkola
 */
public class Card {
    
    private int value;
    boolean isShown;
    
    public Card(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
