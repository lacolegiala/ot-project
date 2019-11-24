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
public class Gameboard {

    private Card[][] board;    

    public Gameboard(int rows, int columns) {
        this.board = new Card[rows][columns];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Card();
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
    
}
