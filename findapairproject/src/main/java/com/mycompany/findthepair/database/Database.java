package com.mycompany.findthepair.database;

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
                           " DIFFICULTY     TEXT   NOT NULL);";
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
    
    public int fetchHighScore(String difficulty) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( 
                "SELECT SCORE FROM SCORES " +
                "WHERE DIFFICULTY='" + difficulty + "' " +
                "ORDER BY SCORE DESC LIMIT 1;");
            boolean foundRow = resultSet.next();
            
            int highestScore = foundRow ? resultSet.getInt("score") : 0;
            
            resultSet.close();
            statement.close();
            return highestScore;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
}
