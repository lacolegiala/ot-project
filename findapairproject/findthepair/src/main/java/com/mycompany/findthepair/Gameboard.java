/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author sofiariekkola
 */
public class Gameboard {

    private Card[][] board;    

    public Gameboard(int rows, int columns) {
        int cardCount = rows * columns;
        int pairCount = cardCount / 2;
        
        ArrayList<Integer> numberList = new ArrayList();
        
        
        for (int i = 0; i < pairCount; i++) {
            numberList.add(i + 1);
            numberList.add(i + 1);
        }
        
        Collections.shuffle(numberList);
        
        
        this.board = new Card[rows][columns];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Card(numberList.remove(0));
            }
        }
       
    }
    
    public void render() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getValue() + "\t");
            }
            System.out.println("\n");
        }
    }
    
    public int getRows() {
        return board.length;
    }
    
    public int getColumns() {
        return board[0].length;
    }
    
}
