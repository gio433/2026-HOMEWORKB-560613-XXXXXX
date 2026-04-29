package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LabirintoTest {

	Labirinto labir = new Labirinto();
	
	@Test
	public void testStanzaCorrente() {
		
		assertEquals("Atrio", labir.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testStanzaVincente() {
		
		assertEquals("Biblioteca", labir.getStanzaVincente().getNome());
	}

	@Test
	public void testCollegamentoBiblioteca() {
		
	assertEquals("Biblioteca", 
		    labir.getStanzaCorrente().getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	public void testCollegamentoLabBiblioteca() {
		
	assertEquals("Aula N11", 
		    labir.getStanzaCorrente().getStanzaAdiacente("ovest").getStanzaAdiacente("ovest").getNome());
	}
}
