package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBloccataTest {

	private StanzaBloccata stanza;
    private Stanza stanzaNord;
    private Stanza stanzaEst;

    @BeforeEach
    void setUp() {
        stanza = new StanzaBloccata("centrale", "nord", "chiave");
        stanzaNord = new Stanza("nord");
        stanzaEst = new Stanza("est");
        stanza.impostaStanzaAdiacente("nord", stanzaNord);
        stanza.impostaStanzaAdiacente("est", stanzaEst);
    }

    @Test
    void testDirezioneBloccataSenzaAttrezzo() {
        Stanza risultato = stanza.getStanzaAdiacente("nord");
        assertEquals(stanza, risultato);
    }

    @Test
    void testDirezioneBloccataConAttrezzo() {
        stanza.addAttrezzo(new it.uniroma3.diadia.attrezzi.Attrezzo("chiave", 1));
        Stanza risultato = stanza.getStanzaAdiacente("nord");
        assertEquals(stanzaNord, risultato);
    }

    @Test
    void testDirezioneNonBloccata() {
        Stanza risultato = stanza.getStanzaAdiacente("est");
        assertEquals(stanzaEst, risultato);
    }

    @Test
    void testDescrizioneSenzaAttrezzo() {
        String desc = stanza.getDescrizione();
        assertTrue(desc.contains("bloccata"));
        assertTrue(desc.contains("nord"));
    }
}
