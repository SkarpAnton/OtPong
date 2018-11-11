package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class KassapaateTest {
    /*
    Laitoin arvot väärin päin, en jaksa vaihtaa orientaatiota
    */
    Kassapaate kassapaate;
    Maksukortti kortti;
    @Before
    public void setUp() {
         kassapaate = new Kassapaate();
         kortti = new Maksukortti(100000);
    }
    @Test
    public void alustusRahaOikein() {
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
    @Test
    public void alustusMaaraOikein() {
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 0);
    }
    @Test
    public void maksuRiittavaEdulliseenVaihtoOikein() {
        assertEquals(kassapaate.syoEdullisesti(500), 250);
        assertEquals(kassapaate.kassassaRahaa(), 100250);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 1);
    }
    @Test
    public void maksuRiittavaMaukkaaseenVaihtoOikein() {
        assertEquals(kassapaate.syoMaukkaasti(500), 100);
        assertEquals(kassapaate.kassassaRahaa(), 100400);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 1);
    }
    @Test
    public void maksuEiOleRiittavaEdulliseenVaihtoOikein() {
        assertEquals(kassapaate.syoEdullisesti(200), 200);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 0);
    }
    @Test
    public void maksuEiOleRiittavaMaukkaaseenVaihtoOikein() {
        assertEquals(kassapaate.syoMaukkaasti(200), 200);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 0);
    }
    @Test
    public void kortillaRiittavastiEdulliseenVaihtoOikein() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(kortti.saldo(), 99750);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 1);
    }
    @Test
    public void kortillaRiittavastiMaukkaaseenVaihtoOikein() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(kortti.saldo(), 99600);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 1);
    }
    @Test
    public void kortillaEiOleRiittavastiEdulliseenVaihtoOikein() {
        kortti = new Maksukortti(50);
        assertTrue(!kassapaate.syoEdullisesti(kortti));
        assertEquals(kortti.saldo(), 50);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 0);
    }
    @Test
    public void kortillaEiOleRiittavastiMaukkaaseenVaihtoOikein() {
        kortti = new Maksukortti(50);
        assertTrue(!kassapaate.syoMaukkaasti(kortti));
        assertEquals(kortti.saldo(), 50);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 0);
    }
    @Test
    public void kortilleLatausOikein() {
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals(kortti.saldo(), 101000);
        assertEquals(kassapaate.kassassaRahaa(), 101000);
    }
    @Test
    public void negatiivinenLatausEiMuuta() {
        kassapaate.lataaRahaaKortille(kortti, -1000);
        assertEquals(kortti.saldo(), 100000);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
}
