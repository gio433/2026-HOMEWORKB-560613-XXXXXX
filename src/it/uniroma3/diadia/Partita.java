package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;
//import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(){    //costruttore
		this.labirinto = new Labirinto();  //MODIFICATO
		this.stanzaCorrente = labirinto.getStanzaCorrente();
		this.stanzaVincente = labirinto.getStanzaVincente();   //MODIFICATO
		this.finita = false;
		this.giocatore= new Giocatore("Bob"); //?????? ma può andare per me
		
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public String getNomeStanzaCorrente() {
	    return this.stanzaCorrente.getNome();
	}

	/*public String getNomeStanzaVincente() {
	    return this.stanzaVincente.getNome();
	}*/

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);   //MODIFICATO
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita(boolean finita) {   //*************sovraccaricato
		this.finita = finita;
	}
	
	public void setFinita() {   //metodo iniziale
		this.finita = true;
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}


	public Labirinto getLabirinto() {
		return labirinto;
	}


	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}
		
}
