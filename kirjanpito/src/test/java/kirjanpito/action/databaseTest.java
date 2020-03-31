/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjanpito.action;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaikarhu
 */
public class databaseTest {
    
    public databaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addReceipt method, of class database.
     */
    @Test
    public void testAddReceipt() throws Exception {
        System.out.println("addReceipt");
        double total = 0.0;
        database instance = new database();
        instance.addReceipt(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllReceipts method, of class database.
     */
    @Test
    public void testListAllReceipts() throws Exception {
        System.out.println("listAllReceipts");
        database instance = new database();
        instance.listAllReceipts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
