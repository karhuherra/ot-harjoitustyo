/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjanpito.action;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import java.util.*;
import kirjanpito.action.receipt;

/**
 *
 * @author kaikarhu
 */
public class databaseTest {
    
    database db;
    
    public databaseTest() {
    }
    
    
    @Before
    public void setUp() throws SQLException{
        db = new database("jdbc:sqlite:fakedatabase.db");
    }
    
    @After
    public void tearDown() throws SQLException {
        db.clean();
    }

    

    /**
     * Test of addReceipt method, of class database.
     */
    @Test
    public void testAddReceipt() throws Exception {
        double total = 10.0;
        String category = "office";
        db.addReceipt(total, category);
        List<receipt> list = db.listAll();
        int size = list.size();
        
        assertEquals(1, size);
        
    }
    
    
    @Test
    public void testAddReceiptCategory() throws Exception {
        db.addReceipt(12, "office");
        db.addReceipt(3, "dog");
        db.addReceipt(3, "office");
        List<receipt> list = db.listAllReceiptsFrom("office");
        int size = list.size();
        
        assertEquals(2, size);
        
    }
    
    @Test
    public void testAddReceiptCategorySum() throws Exception {
        db.addReceipt(12, "office");
        db.addReceipt(3, "dog");
        db.addReceipt(3, "office");
        double num = db.listAllReceiptsFromSum("office");
        boolean val = false;
        if(num == 15){
            val = true;
        }
        
        assertEquals(true, val);
        
    }
    
    @Test
    public void testAddReceiptSum() throws Exception {
        db.addReceipt(12, "office");
        db.addReceipt(3, "dog");
        db.addReceipt(3, "office");
        double n = db.listAllReceiptsSum();
        boolean val = false;
        if(n == 18){
            val = true;
        }
        
        assertEquals(true, val);
        
    }
    
}