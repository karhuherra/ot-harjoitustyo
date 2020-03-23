package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortillaKybäSenttiä() {
        
        String vastaus = kortti.toString();
        
        assertEquals("saldo: 0.10", vastaus);      
    }
    
    
    @Test
    public void kortille400Senttii() {
        
        kortti.lataaRahaa(400);
        
        String vastaus = kortti.toString();
        
        assertEquals("saldo: 4.10", vastaus);      
    }
    
    @Test
    public void korttiKokeileRahanliikkuminen() {
        kortti.otaRahaa(20);
        kortti.lataaRahaa(400);
        kortti.otaRahaa(240);
        

        
        assertTrue(kortti.saldo()==170);
    }
    
    
    
    
}
