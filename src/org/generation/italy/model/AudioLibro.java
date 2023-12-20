package org.generation.italy.model;

public class AudioLibro extends Libro implements IMedia {
	
	private String voceNarrante;
	

	public AudioLibro(String titolo, String genere, int nrCopie, String autore, String sinossi, String voceNarrante) {
		super(titolo, genere, nrCopie, autore, sinossi);
		this.voceNarrante = voceNarrante;
	}

	@Override
	public void play() {
		System.out.println("Riproduzione dell'audiolibro: "+ titolo+" in corso...");

	}

	@Override
	public void stop() {
		System.out.println("Riproduzione dell'audiolibro: "+ titolo+" terminata.");

	}

	@Override
	public String dettagli() {		
		 return "AudioLibro:\n"+
		"\tId: "+id+"\n"+
		"\tTitolo: "+titolo+"\n"+
		"\tVoce narrante: "+voceNarrante+"\n"+
		"\tAutore: "+autore+"\n"+
		"\tSinossi: "+sinossi+"\n"+
		"\tGenere: "+genere+"\n"+
		"\tCopie: "+nrCopie;
	}

}
