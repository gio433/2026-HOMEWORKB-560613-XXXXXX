package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	
	@Override
    public void esegui(Partita partita) {

        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Devi specificare un attrezzo da prendere!");
            return;
        }

        Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);

        if (a == null) {
            io.mostraMessaggio("L'attrezzo non è presente nella stanza!");
            return;
        }
        if (partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
            partita.getGiocatore().getBorsa().addAttrezzo(a);
            partita.getStanzaCorrente().removeAttrezzo(a.getNome());
        } else {
            io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
        }
    }

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
