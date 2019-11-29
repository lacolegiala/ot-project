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

    
    private ArrayList<Integer> createCardValues(int rows, int columns) {
        int cardCount = rows * columns;
        int pairCount = cardCount / 2;
        
        ArrayList<Integer> numberList = new ArrayList();
        
        
        for (int i = 0; i < pairCount; i++) {
            numberList.add(i + 1);
            numberList.add(i + 1);
        }
        
        Collections.shuffle(numberList);
        
        return numberList;
    }

    public Gameboard(int rows, int columns) {
        
        ArrayList<Integer> cardValues = createCardValues(rows, columns);
 
        this.board = new Card[rows][columns];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Card(cardValues.remove(0));
            }
        }
       
    }
    
    public boolean match(int row1, int column1, int row2, int column2) {
        return this.board[row1][column1].getValue() == this.board[row2][column2].getValue();
    }
    
    public void showCard(int row, int column) {
        board[row][column].isShown = true;
    }
    
    public void render() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isShown == true) {
                    System.out.print(board[i][j].getValue() + "\t");
                }
                else {
                    System.out.print("x" + "\t");
                }
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
