package org.generation.italy.model;

public class Film extends ElementoMultimediale implements IMedia {
	private String regista;
	private String attori;
	private int durata;

	
	public Film(String titolo, String genere, int nrCopie, String regista, String attori, int durata) throws Exception {
		super(titolo, genere, nrCopie);
		this.regista = regista;
		this.attori = attori;
		this.durata = durata;
	}

	@Override
	public void play() {
		System.out.println("Riproduzione del film: "+ titolo+" in corso...");
	}

	@Override
	public void stop() {
		System.out.println("Riproduzione del film: "+ titolo+" terminata.");
	}

	@Override
	public String dettagli() {
		
		return "Film:\n"+
				"\tId: "+id+"\n"+
				"\tTitolo: "+titolo+"\n"+
				"\tRegista: "+regista+"\n"+
				"\tAttori: "+attori+"\n"+
				"\tDurata: "+durata+"\n"+
				"\tGenere: "+genere+"\n"+
				"\tCopie: "+nrCopie;
	}

}
