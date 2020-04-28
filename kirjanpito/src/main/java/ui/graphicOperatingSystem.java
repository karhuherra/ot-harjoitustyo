/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.sun.javafx.scene.control.DoubleField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kirjanpito.dao.database;
import java.sql.*;
import java.util.*;
import javafx.scene.control.*;
import kirjanpito.dao.receipt;
/**
 *
 * @author kaikarhu
 */
public class graphicOperatingSystem extends Application{
    
    public void start(Stage stage) throws SQLException {
        
        database db = new database("jdbc:sqlite:database.db");
        stage.setTitle("Kirjanpito");
       
        Label Total = new Label("Kuitin summa:  ");
        TextField TotalField = new TextField();
        TextArea receipts = new TextArea();
        Label header = new Label("Kuitit: ");



        Button addButton = new Button("Lisää kuitti");
        addButton.setOnAction((event)  ->  {
            try{
            db.addReceipt(Double.valueOf(TotalField.getText()), "kakka");
            }catch (SQLException e){
                
            }
        });

        Button addButton2 = new Button("Listaa kuitit");
        addButton2.setOnAction((event) -> {
            try{
            ArrayList<receipt> list = db.listAll();
            receipts.setText(list.toString());
                
            }catch(SQLException e){
                
            }
        });
        

        GridPane gp = new GridPane();
        gp.add(Total, 0, 0);
        gp.add(TotalField, 1, 0);
        gp.add(addButton, 2, 0);
        gp.add(addButton2, 2, 1);
        gp.add(header, 1, 2);
        gp.add(receipts, 1, 3);
        
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(gp);
        
        stage.setScene(scene);        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(graphicOperatingSystem.class);
    }
    
    
}
