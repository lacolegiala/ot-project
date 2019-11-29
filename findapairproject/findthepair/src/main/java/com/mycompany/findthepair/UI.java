/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author sofiariekkola
 */
public class UI {
    
    public void start() {
        Gameboard gameboard = new Gameboard(2, 2);
        gameboard.render();
        
       
        while (true) {
        
            System.out.println("Choose a card by giving coordinates. For example, '0,2'");
            Scanner scanner1 = new Scanner(System.in);                 
            String input1 = scanner1.nextLine();
            String[] splitInput1 = input1.split(",");

            int row1 = parseInt(splitInput1[0]);
            int column1 = parseInt(splitInput1[1]);
            gameboard.showCard(row1, column1);
            gameboard.render();

            System.out.println("Thank you. Please choose another card");
            Scanner scanner2 = new Scanner(System.in);                 
            String input2 = scanner2.nextLine();
            String[] splitInput2 = input2.split(",");

            int row2 = parseInt(splitInput2[0]);
            int column2 = parseInt(splitInput2[1]); 
            gameboard.showCard(row2, column2);
            gameboard.render();

            System.out.println(gameboard.match(row1, column1, row2, column2));

            if (gameboard.match(row1, column1, row2, column2) == true) {
                gameboard.removeCards(row1, column1, row2, column2);
            }
            else {
                gameboard.hideCard(row1, column1);
                gameboard.hideCard(row2, column2);
            }
            gameboard.render();

        }
    }    
    
}
