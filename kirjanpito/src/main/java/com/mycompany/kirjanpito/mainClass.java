/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kirjanpito;

import java.util.Scanner;
import operatingsystem.textOperatingSystem;
import kirjanpito.action.database;
import java.sql.*;

/**
 *
 * @author kaikarhu
 */
public class mainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        System.out.println("Haluatko tekstikäyttöliittymän vai graafisen? (saatavilla vain teksti)");
        Scanner s = new Scanner(System.in);
        database db = new database("jdbc:sqlite:database.db");
        textOperatingSystem top = new textOperatingSystem(s,db);
        top.start();
    }
    
}
