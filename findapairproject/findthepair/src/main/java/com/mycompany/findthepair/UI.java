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
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sofiariekkola
 */ 
public class UI extends Application {
    
    private Gameboard gameboard;
    
    private int points;
    
    public static void startUI() {
        launch(UI.class);
    }
    
    private int firstCardRow = -1;
    private int firstCardColumn = -1;
    
    private Timeline timeline1;
    
    private void renderCards(GridPane gridPane, Card[][] cardBoard, Label label) {
        gridPane.getChildren().clear();
        label.setText("Your points: " + this.points);
        
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
                        if (timeline1 != null && timeline1.getStatus() == Animation.Status.RUNNING) {
                            return;
                        }
                        this.gameboard.showCard(rowIndex, columnIndex);
                        renderCards(gridPane, gameboard.getBoard(), label);
                        
                        if (this.firstCardRow != -1 && this.firstCardColumn != -1) {
                            
                            timeline1 = new Timeline(new KeyFrame(
                                Duration.millis(1500),
                                show -> {
                                    if (gameboard.match(firstCardRow, firstCardColumn, rowIndex, columnIndex) == true) {
                                        points = points + 5;
                                        gameboard.removeCards(firstCardRow, firstCardColumn, rowIndex, columnIndex);
                                        if (gameboard.boardHasCards() == false) {
                                            Timeline timeline2;
                                            timeline2 = new Timeline(new KeyFrame(
                                                Duration.millis(1500),
                                                exit -> {    
                                                System.exit(0);
                                                }
                                            ));
                                            timeline2.play();
                                        }
                                    }
                                    else {
                                        points = points - 1;
                                        gameboard.hideCard(firstCardRow, firstCardColumn);
                                        gameboard.hideCard(rowIndex, columnIndex);
                                    }
                                    this.firstCardRow = -1;
                                    this.firstCardColumn = -1;

                                    renderCards(gridPane, gameboard.getBoard(), label);
                                }));
                                    
                            timeline1.play();
                            
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
        
        BorderPane borderPane = new BorderPane();
        
        Scene scene = new Scene(borderPane);
        
        GridPane gridPane = new GridPane();
        
        Label label = new Label("Select your card");
        
        Label pointLabel = new Label();
        
        ObservableList<String> options = 
            FXCollections.observableArrayList(
            "Easy",
            "Medium",
            "Hard"
            );
        
        final ComboBox<String> comboBox = new ComboBox(options);
        
        borderPane.setRight(label);
        borderPane.setBottom(pointLabel);
        borderPane.setTop(comboBox);
        borderPane.setLeft(gridPane);
        
        comboBox.setOnAction((ActionEvent event) -> {
            String selection = comboBox.getSelectionModel().getSelectedItem();
            switch (selection) {
                case "Easy":
                    gameboard = new Gameboard(2, 3);
                    break;
                case "Medium":
                    gameboard = new Gameboard(4, 5);
                    break;
                default:
                    gameboard = new Gameboard(6, 7);
                    break;
            }
            Card[][] cardBoard = gameboard.getBoard();
            renderCards(gridPane, cardBoard, pointLabel);
        });
        
        stage.setScene(scene);
        stage.setHeight(425);
        stage.setWidth(425);
        stage.show();
        
    }    
    
}
