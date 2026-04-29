package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;

class DiaDiaTest {

	@Test
	public void testProcessaIstruzione() {
	/*Comando comando = new Comando("vai sud");

	assertEquals("vai", comando.getNome());
	assertEquals("sud", comando.getParametro());*/
	
	}

	@Test
	public void testCfu() {
		IOConsole inOut= new IOConsole();
		Partita p =new Partita();
		assertEquals(20, p.getGiocatore().getCfu());
	}
	
	@Test
	public void testVai() {
		IOConsole inOut= new IOConsole();
		Partita p =new Partita();
		
		assertEquals("Atrio", p.getNomeStanzaCorrente());
	}
}
