package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StanzaTest {

	 @Test
	    void testimpostaStanzaAdiacente() {
	       
		   Stanza stanza1 = new Stanza("stanza1");
	       Stanza stanza2 = new Stanza("stanza2");

	       stanza1.impostaStanzaAdiacente("nord", stanza2);
	        
	       assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
	    }
	
	 @Test
	    void hasAttrezzo() {
	       
	        Stanza stanza1 = new Stanza("stanza1");
	       	       
	        Attrezzo chiave = new Attrezzo("chiave",3);
	        stanza1.addAttrezzo(chiave);

	        assertTrue(stanza1.hasAttrezzo("chiave"));
	 }
	 
	 @Test
	    void removeAttrezzo() {
	       
	        Stanza stanza1 = new Stanza("stanza1");
	       
	        Attrezzo chiave = new Attrezzo("chiave",3);
	        stanza1.addAttrezzo(chiave); 
	       
	        assertTrue(stanza1.removeAttrezzo("chiave"));
	 }
	 
	 @Test
	 void testLeStanzeVuoteNoAttrezzi() {       //caso 0 stanza vuota
		 assertFalse(new Stanza("vuota").hasAttrezzo("martello"));  //INLINE
	 }
	 
	 @Test
	 void testStanzaConAttrezzo_trovato() {    //caso 1 -  1 stanza 1 attrezzo
		 Stanza piena = new Stanza("piena");             //EXTRACT
		 assertFalse(piena.hasAttrezzo("martello"));
		 piena.addAttrezzo(new Attrezzo("martello", 10));
		 assertTrue(piena.hasAttrezzo("martello"));
	 }
	
	 @Test
	 void testStanzaConAttrezzo_mancante() {   //caso 1 attrezzo inesistente
		 Stanza piena = new Stanza("piena");
		 assertFalse(piena.hasAttrezzo("martello"));
		 piena.addAttrezzo(new Attrezzo("martello", 10));
		 assertFalse(new Stanza("piena").hasAttrezzo("introvabile"));
	 }
	 
	 @Test
	 void testMassimoDieciAttrezzi() {      //caso 10 attrezzi
		 final Stanza piena=new Stanza("piena");
		 for (int i = 0; i < 10; i++) {
			    Attrezzo a = new Attrezzo("attrezzo" + i, i);
			    assertTrue(piena.addAttrezzo(a));
			}
		 assertFalse(piena.addAttrezzo(new Attrezzo("escluso", 1)));
	 }
}
