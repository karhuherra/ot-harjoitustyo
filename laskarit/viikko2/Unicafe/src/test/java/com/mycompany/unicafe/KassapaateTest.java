/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    Kassapaate kassa;
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kassakäynnissäoikein(){
        int raha = kassa.kassassaRahaa();
        int lounaat = 0;
        lounaat += kassa.maukkaitaLounaitaMyyty();
        lounaat += kassa.edullisiaLounaitaMyyty();
        
        assertTrue(raha==100000&&lounaat==0);
    }
    
    @Test
    public void ostaEdullinen300(){
        int vaihto = kassa.syoEdullisesti(300);
        
        assertTrue(vaihto==60&&kassa.kassassaRahaa()==100240&&kassa.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void ostaMaukas500(){
        int vaihto = kassa.syoMaukkaasti(500);
        
        assertTrue(vaihto==100&&kassa.kassassaRahaa()==100400&&kassa.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void yritäEdullinen200(){
        int vaihto = kassa.syoEdullisesti(200);
        
        assertTrue(vaihto==200 && kassa.kassassaRahaa()==100000 && kassa.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void yritäMaukas300(){
        int vaihto = kassa.syoMaukkaasti(300);
        
        assertTrue(vaihto==300 && kassa.kassassaRahaa()==100000 && kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void ostaKorttiEdullinen(){
        Maksukortti kortti = new Maksukortti(400);
        kassa.syoEdullisesti(kortti);
        
        assertTrue(kortti.saldo()==160  && kassa.kassassaRahaa() == 100000 && kassa.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void ostaKorttiMaukas(){
        Maksukortti kortti = new Maksukortti(400);
        kassa.syoMaukkaasti(kortti);
        
        assertTrue(kortti.saldo()==0  && kassa.kassassaRahaa() == 100000 && kassa.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void yritäostaKorttiEdullinen(){
        Maksukortti kortti = new Maksukortti(160);
        kassa.syoEdullisesti(kortti);
        
        assertTrue(kortti.saldo()==160  && kassa.kassassaRahaa() == 100000 && kassa.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void yritäostaKorttiMaukas(){
        Maksukortti kortti = new Maksukortti(300);
        kassa.syoMaukkaasti(kortti);
        
        assertTrue(kortti.saldo()==300  && kassa.kassassaRahaa() == 100000 && kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void lataaKortille(){
        Maksukortti kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 500);
        
        assertTrue(kortti.saldo()==500 && kassa.kassassaRahaa() == 100500);
    }
    
    @Test
    public void yritälataaKortille(){
        Maksukortti kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, -100);
        
        assertTrue(kortti.saldo()==0 && kassa.kassassaRahaa() == 100000);
    }
    
    
}
