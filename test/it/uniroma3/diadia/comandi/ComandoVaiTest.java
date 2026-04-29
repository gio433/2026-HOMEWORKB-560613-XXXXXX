package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

    private Stanza s1;
    private Stanza s2;
    private ComandoVai vai;
    private Partita p;

    @BeforeEach
    public void setUp() {
        s1 = new Stanza("aula 1");
        s2 = new Stanza("aula 2");
        vai = new ComandoVai();
        p = new Partita();
        vai.setIo(new IOConsole());
    }

    @Test
    public void testVaiNull() {
        p.setStanzaCorrente(s1);

        int cfuPrima = p.getGiocatore().getCfu();

        vai.esegui(p);

        assertEquals(s1, p.getStanzaCorrente());
        assertEquals(cfuPrima, p.getGiocatore().getCfu());
    }

    @Test
    public void testVaiDirezioneEsistente() {
        p.setStanzaCorrente(s1);
        s1.impostaStanzaAdiacente("nord", s2);

        vai.setParametro("nord");

        vai.esegui(p);

        assertEquals(s2, p.getStanzaCorrente());
    }

    @Test
    public void testVaiDirezioneInesistente() {
        p.setStanzaCorrente(s1);
        s1.impostaStanzaAdiacente("nord", s2);

        vai.setParametro("sud");

        vai.esegui(p);

        assertEquals(s1, p.getStanzaCorrente());
    }

    @Test
    public void testVaiConsumaCfu() {
        p.setStanzaCorrente(s1);
        s1.impostaStanzaAdiacente("nord", s2);

        vai.setParametro("nord");

        int cfuPrima = p.getGiocatore().getCfu();

        vai.esegui(p);

        assertEquals(cfuPrima - 1, p.getGiocatore().getCfu());
    }
}