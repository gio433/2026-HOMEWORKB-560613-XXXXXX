package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica fabbrica;

    @BeforeEach
    void setUp() {
        fabbrica = new FabbricaDiComandiFisarmonica(new IOConsole());
    }

    @Test
    void testComandoVaiConParametro() {
        Comando c = fabbrica.costruisciComando("vai nord");
        assertTrue(c instanceof ComandoVai);
        assertEquals("nord", c.getParametro());
    }

    @Test
    void testComandoPrendiConParametro() {
        Comando c = fabbrica.costruisciComando("prendi martello");
        assertTrue(c instanceof ComandoPrendi);
        assertEquals("martello", c.getParametro());
    }

    @Test
    void testComandoPosaConParametro() {
        Comando c = fabbrica.costruisciComando("posa chiave");
        assertTrue(c instanceof ComandoPosa);
        assertEquals("chiave", c.getParametro());
    }

    @Test
    void testComandoAiuto() {
        Comando c = fabbrica.costruisciComando("aiuto");
        assertTrue(c instanceof ComandoAiuto);
        assertNull(c.getParametro());
    }

    @Test
    void testComandoFine() {
        Comando c = fabbrica.costruisciComando("fine");
        assertTrue(c instanceof ComandoFine);
        assertNull(c.getParametro());
    }

    @Test
    void testComandoNonValido() {
        Comando c = fabbrica.costruisciComando("sbadabam qualcosa");
        assertTrue(c instanceof ComandoNonValido);
    }

    @Test
    void testComandoSenzaInput() {
        Comando c = fabbrica.costruisciComando("");
        assertTrue(c instanceof ComandoNonValido);
    }

    @Test
    void testParametroMancante() {
        Comando c = fabbrica.costruisciComando("vai");
        assertTrue(c instanceof ComandoVai);
        assertNull(c.getParametro());
    }
}