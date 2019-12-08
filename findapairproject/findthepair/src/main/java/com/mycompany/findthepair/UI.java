/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author sofiariekkola
 */
public class UI extends Application {
    
    private Gameboard gameboard;
    
    public static void startUI() {
        launch(UI.class);
    }
    
    private int firstCardRow = -1;
    private int firstCardColumn = -1;
    
    private void renderCards(GridPane gridPane, Card[][] cardBoard) {
        gridPane.getChildren().clear();
        
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                Button button = new Button();
                button.setStyle("-fx-pref-width: 50px; -fx-pref-height: 50px");
                if (cardBoard[i][j] == null) {
                    button.setText("");
                    gridPane.add(button, j+1, i+1);
                }
                else if (cardBoard[i][j].isShown == true) {
                    button.setText(Integer.toString(cardBoard[i][j].getValue()));
                    gridPane.add(button, j+1, i+1);
                }
                else {
                    final int rowIndex = i;
                    final int columnIndex = j;
                    button.setText("x");
                    gridPane.add(button, j+1, i+1);
                    button.setOnAction((event) -> {
                        this.gameboard.showCard(rowIndex, columnIndex);
                        if (this.firstCardRow != -1 && this.firstCardColumn != -1) {
                            if (gameboard.match(firstCardRow, firstCardColumn, rowIndex, columnIndex) == true) {
                                gameboard.removeCards(firstCardRow, firstCardColumn, rowIndex, columnIndex);
                            }
                            else {
                                gameboard.hideCard(firstCardRow, firstCardColumn);
                                gameboard.hideCard(rowIndex, columnIndex);
                            }
                            this.firstCardRow = -1;
                            this.firstCardColumn = -1;
                        }
                        else {
                            this.firstCardRow = rowIndex;
                            this.firstCardColumn = columnIndex;
                        }
                        renderCards(gridPane, gameboard.getBoard());
                    });
                }

            }
        }
        
    }
    
    
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Find the pair");
        
        this.gameboard = new Gameboard(6, 6);

        Card[][] cardBoard = gameboard.getBoard();
        
        GridPane gridPane = new GridPane();
        
        Label label = new Label("Select your card");

        renderCards(gridPane, cardBoard);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(label);
        borderPane.setLeft(gridPane);
        
        Scene scene = new Scene(borderPane);
        
        stage.setScene(scene);
        stage.show();
        
       
//        while (gameboard.boardHasCards() == true) {
//        
//            System.out.println("Choose a card by giving coordinates. For example, '0,2'");
//            Scanner scanner1 = new Scanner(System.in);                 
//            String input1 = scanner1.nextLine();
//            String[] splitInput1 = input1.split(",");
//
//            int row1 = parseInt(splitInput1[0]);
//            int column1 = parseInt(splitInput1[1]);
//            gameboard.showCard(row1, column1);
//            gameboard.render();
//
//            System.out.println("Thank you. Please choose another card");
//            Scanner scanner2 = new Scanner(System.in);                 
//            String input2 = scanner2.nextLine();
//            String[] splitInput2 = input2.split(",");
//
//            int row2 = parseInt(splitInput2[0]);
//            int column2 = parseInt(splitInput2[1]); 
//            gameboard.showCard(row2, column2);
//            gameboard.render();
//
//            System.out.println(gameboard.match(row1, column1, row2, column2));
//
//            if (gameboard.match(row1, column1, row2, column2) == true) {
//                gameboard.removeCards(row1, column1, row2, column2);
//            }
//            else {
//                gameboard.hideCard(row1, column1);
//                gameboard.hideCard(row2, column2);
//            }
//            gameboard.render();
//        }
    }    
    
}
