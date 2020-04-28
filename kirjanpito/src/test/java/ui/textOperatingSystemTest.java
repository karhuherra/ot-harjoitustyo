/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kaikarhu
 */
public class textOperatingSystemTest {
    
    textOperatingSystem tos;
    
    public textOperatingSystemTest() {
    }
    
    
    @Before
    public void setUp() throws SQLException {
        Scanner s = new Scanner(System.in);
        tos = new textOperatingSystem(s, "jdbc:sqlite:fakedatabase.db");        
    }
    
    @After
    public void tearDown() throws SQLException {
        tos.drop();
    }

    /**
     * Test of start method, of class textOperatingSystem.
     */
    @Test
    public void testStart() throws Exception {
    }


    
}
