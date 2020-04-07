/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operatingsystem;
import kirjanpito.action.database;
import java.util.*;
import java.sql.*;
/**
 *
 * @author kaikarhu
 */
public class textOperatingSystem {
    
    private Scanner s;
    private Map<String, String> staments;
    private database db;
    
    public textOperatingSystem(Scanner s, database db){
        this.s = s;
        this.db = db;
        this.staments = new TreeMap<>();
        
        this.staments.put("666", "666 lopeta");
        this.staments.put("1", "1 lisää kuitti");
        this.staments.put("2", "2 näytä kaikki kuiti");
        this.staments.put("3", "3 näytä kaikki kuitit kategoriasta");
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
            
            if(statement.equals("1")){
                System.out.println("Anna kuitin summa:");
                double total = Double.valueOf(s.nextLine());
                System.out.println("Anna kuitin kategoria:");
                String category = s.nextLine();
                db.addReceipt(total, category);
            }
            
            if(statement.equals("2")){
                db.listAllReceipts();
            }
            
            if(statement.equals("3")){
                System.out.println("Anna kategoria:");
                String category = s.nextLine();
                db.listAllReceiptsFrom(category);
            }
            
            if(statement.equals("4")){
                db.clean();
            }
        }
    }
    
    
    public void printInstruction(){
        for(String row : staments.values()){
            System.out.println(row);
        }
    }
    
}
