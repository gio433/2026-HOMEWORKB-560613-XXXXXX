package it.uniroma3.diadia.giocatore;


public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	 private String nome;
	 private int cfu;
	 private Borsa borsa;

	 /**
	  * 
	  * @param nome
	  */
	 public Giocatore(String nome) {
		 this.nome = nome;
	     this.cfu = CFU_INIZIALI; // valore iniziale
	     this.borsa = new Borsa();
	   
	 }

	 public int getCfu() {
	      return this.cfu;
	 }

	 public void setCfu(int cfu) {
	      this.cfu = cfu;
	 }

	 public Borsa getBorsa() {
	      return this.borsa;
	 }

	 public String getNome() {
		 return this.nome;
	 }

	 public void setNome(String nome) {
		 this.nome = nome;
	 }

	 public void setBorsa(Borsa borsa) {
		 this.borsa = borsa;
	 }
	 public String getNomeGiocatoreDescrizione() {
		 return this.toString();
	 }
	 public String toString() {
			return this.getNome()+" ("+this.getBorsa()+")";
		}

}
