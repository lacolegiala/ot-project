package com.mycompany.findthepair.domain;

/**
 *
 * @author sofiariekkola
 */
public class Card {
    
    private int value;
    public boolean isShown;
    
    public Card(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
