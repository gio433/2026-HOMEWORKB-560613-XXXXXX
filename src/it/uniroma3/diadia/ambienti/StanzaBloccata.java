package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione != null && direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoSbloccante)) {
			return super.getDescrizione() +"\nLa direzione " + direzioneBloccata + " è bloccata.";
		}
		return super.getDescrizione();
	}
}
