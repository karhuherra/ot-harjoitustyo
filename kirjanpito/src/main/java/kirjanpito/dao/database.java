/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjanpito.dao;

/**
 *
 * @author kaikarhu
 */
import java.sql.*;
import java.util.*;
import kirjanpito.dao.receipt;

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
    
    
    public ArrayList<receipt> listAll() throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT total,category FROM receipts");        
            ResultSet result = statement.executeQuery();
            ArrayList<receipt> ret = new ArrayList<>();
            while(result.next()){
                receipt rec = new receipt(result.getDouble("total"),result.getString("category"));
                ret.add(rec);
            }
            return ret;
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
            return new ArrayList<receipt>();
        }
    }
    
    
    public ArrayList<receipt> listAllReceiptsFrom(String category) throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT total,category FROM receipts WHERE category=?");
            statement.setString(1,category);
            ResultSet result = statement.executeQuery();
            ArrayList<receipt> list = new ArrayList();
            while(result.next()){
                receipt rec = new receipt(result.getDouble("total"),result.getString("category"));
                list.add(rec);
            }
            return list;
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
            return new ArrayList<>();
        }
    }
    
    
    public double listAllReceiptsFromSum(String category) throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT SUM(total) FROM receipts WHERE category=?");
            statement.setString(1,category);
            ResultSet result = statement.executeQuery();
            double ret = 0;
            while(result.next()){
                ret = result.getDouble("SUM(total)");
            }
            return ret;
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
            return 0;
        }
    }
    
    public double listAllReceiptsSum() throws SQLException{
        try{
            PreparedStatement statement = db.prepareStatement("SELECT SUM(total) FROM receipts");
            ResultSet result = statement.executeQuery();
            double ret = 0;
            while(result.next()){
                ret = result.getDouble("SUM(total)");
            }
            return ret;
            
        }catch (SQLException e){
            System.out.println("Ei toimi, kokeile uudestaan");
            return 0;
        }
    }
}
