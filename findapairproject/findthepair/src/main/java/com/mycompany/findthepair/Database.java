/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.findthepair;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofiariekkola
 */
public class Database {
    
    Connection connection = null;

    public Database() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:findThePair.db");
            System.out.println("Opened database successfully");

           
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS SCORES " +
                           "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                           " SCORE          INT    NOT NULL," + 
                           " DIFFICULTY     TEXT   NOT NULL);" ;
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception exception) {
           System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
           System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    
    public void saveScore(int score, String difficulty) {
        try {        
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO SCORES (SCORE, DIFFICULTY)" +
                         "VALUES (" + score + ", '" + difficulty + "');";
            statement.executeUpdate(sql);
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
