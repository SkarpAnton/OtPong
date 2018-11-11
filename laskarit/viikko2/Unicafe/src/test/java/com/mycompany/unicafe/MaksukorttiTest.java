package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/*
    Laitoin arvot väärin päin, en jaksa vaihtaa orientaatiota
  */
public class MaksukorttiTest {
    
    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void voiVahentaaKunSaldoaTarpeeeksi() {
        kortti.otaRahaa(800);
        assertEquals(kortti.saldo(), 200);      
    }
    @Test
    public void voiVahentaaKunSaldoaMinimiMaara() {
        kortti.otaRahaa(1000);
        assertEquals(kortti.saldo(), 0);      
    }
    @Test
    public void eiVoiVahentaaKunSaldoaEiOleTarpeeeksi() {
        kortti.otaRahaa(1200);
        assertEquals(kortti.saldo(), 1000);      
    }
    
    @Test
    public void palauttaaTrueKunSaldoaTarpeeksi() {
        assertTrue(kortti.otaRahaa(800));      
    }
    @Test
    public void palauttaaFalseKunSaldoaEiOleTarpeeksi() {
        assertTrue(!kortti.otaRahaa(1200));      
    }
    @Test
    public void saldoToimii() {
        assertEquals(kortti.saldo(), 1000);      
    }
    @Test
    public void lisaysToimii() {
        kortti.lataaRahaa(100);
        assertEquals(kortti.saldo(), 1100);      
    }
    @Test
    public void toStringToimii() {
        assertEquals(kortti.toString(), "saldo: 10.0");      
    }
}
