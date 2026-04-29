package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia stanza;
    private Attrezzo lanterna;

    @BeforeEach
    void setUp() {
        stanza = new StanzaBuia("caverna", "lanterna");
        lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    void testStanzaBuiaSenzaAttrezzo() {
        String descrizione = stanza.getDescrizione();
        assertEquals("qui c'è un buio pesto", descrizione);
    }

    @Test
    void testStanzaBuiaConAttrezzo() {
        stanza.addAttrezzo(lanterna);
        String descrizione = stanza.getDescrizione();
        assertTrue(descrizione.contains("caverna"));
        assertFalse(descrizione.equals("qui c'è un buio pesto"));
    }
}
