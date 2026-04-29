package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);  //***************
		//scannerDiLinee = new Scanner(System.in);
		
		do		
			istruzione =  io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
		io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}
	/*private boolean processaIstruzione(String istruzione, IO io) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome()==null) return false;
 	
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(io); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(), io);
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(io);
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(), io);
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(), io);
		
		else
			io.mostraMessaggio("Comando sconosciuto"); //**************
			
		
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");  //*******************
			
			return true;
		}
		else
			return false;
	}   */

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole io) {
		for(int i=0; i< elencoComandi.length; i++) {
			io.mostraMessaggioSenzaACapo(elencoComandi[i]+ " ");  //******************
		}
		//System.out.println();
	}	

	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione, IO io) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?"); //*******************
			
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");  //**************
			
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			
			Giocatore giocatore=this.partita.getGiocatore();
			int cfu= giocatore.getCfu();        //giocatoore.getCfu() - 1);
			this.partita.getGiocatore().setCfu(--cfu);     //MODIFICATO da me(cfu--)
			//int cfu = this.partita.getCfu();
		}
		
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione()); //*******
		
	}

	/**
	 * prende un attrezzo dalla stanza corrente e lo aggiunge alla borsa del giocatore:
	 * Recupera la stanza corrente, Cerca l’attrezzo nella stanza
	 * se esiste: lo rimuove dalla stanza e lo aggiunge alla borsa
	 * altrimenti  messaggio di errore
	 * @param nomeAttrezzo
	 */
	private void prendi (String nomeAttrezzo, IOConsole io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Quale attrezzo vuoi prendere ?");  //************
		
		Stanza corrente = this.partita.getStanzaCorrente();  
		//if(corrente!=null) 
		if(corrente.hasAttrezzo(nomeAttrezzo)) {  
			Attrezzo a=corrente.getAttrezzo(nomeAttrezzo);
			io.mostraMessaggio(a.toString());
			
			if (this.partita.getGiocatore().getBorsa().getPeso()+a.getPeso()<
				this.partita.getGiocatore().getBorsa().getPesoMax()) {
				corrente.removeAttrezzo(nomeAttrezzo);
				this.partita.getGiocatore().getBorsa().addAttrezzo(a);
				Giocatore g= this.partita.getGiocatore();
				io.mostraMessaggio(g.getNomeGiocatoreDescrizione());
			}
			else {
				io.mostraMessaggio(a.getNome()+" aumenta il peso borsa oltre peso max consentito");
			}
		}
		else 
			io.mostraMessaggio("Attrezzo inesistente");
			
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa del giocatore e lo aggiunge alla stanza:
	 * 	Recupera la borsa, cerca l’attrezzo nella borsa
	 * se esiste: lo rimuove dalla borsa e lo aggiunge alla stanza corrente
	 * altrimenti  messaggio di errore
	 * @param nomeAttrezzo
	 */
	private void posa (String nomeAttrezzo, IOConsole io) {
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Quale attrezzo vuoi posare ?");
			
		Borsa borsaCorrente = this.partita.getGiocatore().getBorsa();
		if(borsaCorrente!=null) 
			if(borsaCorrente.hasAttrezzo(nomeAttrezzo)) {
	            Attrezzo a = borsaCorrente.getAttrezzo(nomeAttrezzo);
	            io.mostraMessaggio(a.toString());
	            
	            borsaCorrente.removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio(borsaCorrente.toString());
				
				this.partita.getStanzaCorrente().addAttrezzo(a);
				io.mostraMessaggio(this.partita.getStanzaCorrente().toString());
			}
			else {
				io.mostraMessaggio("Attrezzo inesistente nella borsa");
			}
		else
			io.mostraMessaggio("borsa vuota");
			
	}
			
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  //****************
	}

	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}