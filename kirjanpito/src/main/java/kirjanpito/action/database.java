/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjanpito.action;

/**
 *
 * @author kaikarhu
 */
import java.sql.*;
import java.util.*;

public class database {
    
    Connection db;
    
    public database(String text) throws SQLException{
        db = DriverManager.getConnection(text);
        Statement s = db.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT UNIQUE)");
        s.execute("CREATE TABLE IF NOT EXISTS receipts (id INTEGER PRIMARY KEY, total NUMERIC, category TEXT)");
        
    }
    
    public void clean() throws SQLException{
        Statement s = db.createStatement();
        s.execute("DROP TABLE receipts");
        s.execute("DROP TABLE users");
        
    }
    
    public void addReceipt(double total, String category) throws SQLException{
        try{PreparedStatement statement = db.prepareStatement("INSERT INTO receipts (total,category) VALUES (?,?)");
        statement.setDouble(1, total);
        statement.setString(2, category);
        statement.executeUpdate(); 
        System.out.println("kuitti lisätty");
        }catch(SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
        }
    }
    
    public void listAllReceipts() throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT total,category FROM receipts");        
            ResultSet result = statement.executeQuery();
            System.out.println("Kuitit:");
            System.out.println("");
            while(result.next()){
                System.out.println(result.getDouble("total") + " " + result.getString("category"));
            }
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
        }
    }
    
    public ArrayList<Double> listAllReceiptsGraphic() throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT total FROM receipts");        
            ResultSet result = statement.executeQuery();
            ArrayList<Double> list = new ArrayList<>();
            while(result.next()){
                list.add(result.getDouble("total"));
            }
            return list;
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
        }
        ArrayList<Double> list = new ArrayList<>();
        return list;
    }
    
    public void listAllReceiptsFrom(String category) throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT total,category FROM receipts WHERE category=?");
            statement.setString(1,category);
            ResultSet result = statement.executeQuery();
            System.out.println("Kuitit:");
            System.out.println("");
            while(result.next()){
                System.out.println(result.getDouble("total") + " " + result.getString("category"));
            }
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
        }
    }
    
    
    
}
