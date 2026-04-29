package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaCorrente;
    private Stanza stanzaVincente;

    public Labirinto() {   //costruttore
        this.creaLabirinto(); 
    }
   
	private void creaLabirinto() {
		 
		/**
		   * Crea tutte le stanze e le porte di collegamento
		*/
		 
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

          
	     
	     /* crea gli attrezzi */
	     Attrezzo lanterna = new Attrezzo("lanterna",3);
		 Attrezzo osso = new Attrezzo("osso",1);
			
		//MODIFICATO************************************
		Attrezzo spada = new Attrezzo("spada",4);
		Attrezzo lancia = new Attrezzo("lancia",7);
		
		
		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		//MODIFICATO ***************************************
		aulaN10.addAttrezzo(spada);
		aulaN10.addAttrezzo(lancia);
				
		
		// il gioco comincia nell'atrio
	     this.stanzaCorrente = atrio;   //ENTRATA  ????????????????
	     this.stanzaVincente = biblioteca;    //USCITA
	    
	}

	 public Stanza getStanzaVincente() {
		 return this.stanzaVincente;
	 }
	 
	 /** 
	  * @return stanzaFinale
	  * @see 
	  */
	 public Stanza getStanzaCorrente() {
		 return this.stanzaCorrente;
	 }
	 
	 /**
	  * 
	  * @param stanzaIniziale
	  */
	 public void setStanzaCorrente(Stanza stanzaCorrente) {
		 this.stanzaCorrente = stanzaCorrente;
	 }
	
}
