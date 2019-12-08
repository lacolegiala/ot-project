/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
                        renderCards(gridPane, gameboard.getBoard());
                        
                        
                        if (this.firstCardRow != -1 && this.firstCardColumn != -1) {
                            
                            Timeline timeline = new Timeline(new KeyFrame(
                                Duration.millis(1500),
                                ae -> {
                                    if (gameboard.match(firstCardRow, firstCardColumn, rowIndex, columnIndex) == true) {
                                        gameboard.removeCards(firstCardRow, firstCardColumn, rowIndex, columnIndex);
                                    }
                                    else {
                                        gameboard.hideCard(firstCardRow, firstCardColumn);
                                        gameboard.hideCard(rowIndex, columnIndex);
                                    }
                                    this.firstCardRow = -1;
                                    this.firstCardColumn = -1;

                                    renderCards(gridPane, gameboard.getBoard());
                                }));
                                    
                            timeline.play();
                        
                                    
                        }
                        
                        else {
                            this.firstCardRow = rowIndex;
                            this.firstCardColumn = columnIndex;
                        }
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
        
       
    }    
    
}
