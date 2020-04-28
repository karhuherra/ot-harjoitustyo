/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import kirjanpito.dao.database;
import java.util.*;
import java.sql.*;
import kirjanpito.dao.receipt;
/**
 *
 * @author kaikarhu
 */
public class textOperatingSystem {
    
    private Scanner s;
    private Map<String, String> staments;
    private database db;
    
    public textOperatingSystem(Scanner s, String st) throws SQLException{
        this.s = s;
        this.db = new database(st);
        this.staments = new TreeMap<>();
        
        this.staments.put("666", "666 lopeta");
        this.staments.put("999", "999 drop tables");
        this.staments.put("1", "1 lisää kuitti");
        this.staments.put("2", "2 näytä kaikki kuiti");
        this.staments.put("3", "3 näytä kaikki kuitit kategoriasta");
        this.staments.put("4", "4 summa kaikista kuiteista");
        this.staments.put("5", "5 summa kuiteista tietyssä kategoriassa");
    }
    
    public void start() throws SQLException{
        System.out.println("Kirjanpito");
        System.out.println("----------");
        printInstruction();
        
        while(true){
            System.out.println("Syötä komento");
            String statement = s.nextLine();
            
            if(statement.equals("666")){
                System.out.println("suljetaan.");
                break;
            }
            
            if(statement.equals("999")){
                db.clean();
            }
            
            if(statement.equals("1")){
                System.out.println("Anna kuitin summa:");
                double total = Double.valueOf(s.nextLine());
                System.out.println("Anna kuitin kategoria:");
                String category = s.nextLine();
                db.addReceipt(total, category);
            }
            
            if(statement.equals("2")){
                ArrayList<receipt> receipts = db.listAll();
                if(receipts.isEmpty()){
                    System.out.println("Ei kuitteja");
                }
                for(receipt r : receipts){
                    System.out.println(r);
                }                
            }
            
            if(statement.equals("3")){
                System.out.println("Anna kategoria:");
                String category = s.nextLine();
                ArrayList<receipt> list = db.listAllReceiptsFrom(category);
                
                if(list.isEmpty()){
                    System.out.println("Ei kuitteja");
                }
                
                for(receipt r : list){
                    System.out.println(r);
                }
            }
            
            if(statement.equals("4")){
                System.out.println("kuittien summa yhteensä: " + db.listAllReceiptsSum());
            }
            
            if(statement.equals("5")){
                System.out.println("Anna kategoria:");
                String category = s.nextLine();
                System.out.println(category + " kuittien summa yhteensä: " + db.listAllReceiptsFromSum(category));
            }
        }
    }
    
    
    public void printInstruction(){
        for(String row : staments.values()){
            System.out.println(row);
        }
    }
    
    public void drop() throws SQLException{
        db.clean();
    }
    
}
