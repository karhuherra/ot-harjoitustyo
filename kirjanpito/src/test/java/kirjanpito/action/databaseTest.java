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
import java.sql.*;
import java.util.*;
import kirjanpito.action.database;

/**
 *
 * @author kaikarhu
 */
public class databaseTest {
    database datab;
    
    
    
    
    
    @Before
    public void setUp() throws SQLException{
       datab = new database("jdbc:sqlite:fakedatabase.db");
    }
    
    @After
    public void clean() throws SQLException {
        datab.clean();
    }

    @Test
    public void databaseTest() throws SQLException {
        PreparedStatement statement = datab.db.prepareStatement("SELECT COUNT(*) FROM sqlite_master WHERE type = 'table'");        
        ResultSet result = statement.executeQuery();
        assertEquals(result, 2);
    }
    
}
