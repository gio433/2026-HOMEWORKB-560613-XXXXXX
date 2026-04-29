package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

    private Partita partita;
    private Attrezzo leggero;
    private Attrezzo pesante;
    private ComandoPrendi comando;

    @BeforeEach
    void setUp() {
        partita = new Partita();

        leggero = new Attrezzo("martello", 2);
        pesante = new Attrezzo("incudine", 11);

        comando = new ComandoPrendi();
        comando.setIo(new IOConsole());
    }

    @Test
    void testPrendiAttrezzoPresente() {

        partita.getStanzaCorrente().addAttrezzo(leggero);

        comando.setParametro("martello");
        comando.esegui(partita);

        assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    void testAttrezzoNonPresente() {

        comando.setParametro("martello");
        comando.esegui(partita);

        assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }

    @Test
    void testAttrezzoTroppoPesante() {

        partita.getStanzaCorrente().addAttrezzo(pesante);

        comando.setParametro("incudine");
        comando.esegui(partita);

        assertTrue(partita.getStanzaCorrente().hasAttrezzo("incudine"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("incudine"));
    }

    @Test
    void testAttrezzoNull() {

        comando.setParametro(null);
        comando.esegui(partita);

        assertTrue(partita.getStanzaCorrente().getAttrezzi().length >= 0);
    }
}