package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

    private Partita partita;
    private Attrezzo attrezzo;
    private ComandoPosa comando;

    @BeforeEach
    public void setUp() {
        partita = new Partita();
        attrezzo = new Attrezzo("martello", 2);
        comando = new ComandoPosa();
        comando.setIo(new IOConsole());
    }

    @Test
    public void testAttrezzoPosato() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        comando.setParametro("martello");
        comando.esegui(partita);

        assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    public void testAttrezzoNonPresenteInBorsa() {
        comando.setParametro("martello");

        comando.esegui(partita);

        assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    public void testStanzaPiena() {
        int max = partita.getStanzaCorrente().getNumeroAttrezziPossibili();

        for(int i = 0; i < max; i++) {
            partita.getStanzaCorrente().addAttrezzo(new Attrezzo("u"+i, 1));
        }

        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        comando.setParametro("martello");
        comando.esegui(partita);

        assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    public void testAttrezzoRimossoDaBorsa() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        comando.setParametro("martello");
        comando.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }
}