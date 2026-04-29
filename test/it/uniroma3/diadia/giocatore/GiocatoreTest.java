package it.uniroma3.diadia.giocatore;
//import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiocatoreTest {

	@Test
	void testCfu() {
		Giocatore g = new Giocatore ("Alice");
		
		assertEquals(20, g.getCfu());	
	}

	@Test
	void testNome() {
		Giocatore g =new Giocatore ("Alis");
		assertEquals("Alis", g.getNome());
	}
	@Test
	void testBorsa() {
		Giocatore g = new Giocatore("Ken");
		assertEquals(0, g.getBorsa().getPeso());
	}
}
