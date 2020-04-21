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
public class receiptTest {
    
    public receiptTest() {
    }
    
    

    /**
     * Test of toString method, of class receipt.
     */
    @Test
    public void testReceipt() {
        receipt r = new receipt(2.0, "th");
        String res = r.toString();
        
        assertEquals("summa: 2.0 kategoria: th", res);
    }
    
    @Test
    public void testgetcategory(){
        receipt r = new receipt(22,"hera");
        String res = r.getCategory();
        assertEquals("hera",res);
    }
}
