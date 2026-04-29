package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BorsaTest {

	@Test
	void testAddAttrezzo() {
		Borsa b = new Borsa();
		Attrezzo lancia = new Attrezzo("lancia", 5);
		b.addAttrezzo(lancia);
		assertEquals(lancia,b.getAttrezzo("lancia"));
	}
	
	@Test
	void testBorsaVuota() {
		Borsa b = new Borsa();
		assertTrue(b.isEmpty());
	}
	
	@Test
	void testHaAttrezzo() {
		Borsa b = new Borsa();
		Attrezzo lancia = new Attrezzo("lancia", 5);
		b.addAttrezzo(lancia);
		assertTrue(b.hasAttrezzo("lancia"));
	}
}
