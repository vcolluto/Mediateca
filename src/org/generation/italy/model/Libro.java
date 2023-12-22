package org.generation.italy.model;

public class Libro extends ElementoMultimediale {
	protected String autore, sinossi;

	/**
	 * @param titolo
	 * @param genere
	 * @param nrCopie
	 * @param autore
	 * @param sinossi
	 * @throws Exception 
	 */
	public Libro(String titolo, String genere, int nrCopie, String autore, String sinossi) throws Exception {
		super(titolo, genere, nrCopie);
		this.autore = autore;
		this.sinossi = sinossi;
	}

	public String getAutore() {
		return autore;
	}

	public String getSinossi() {
		return sinossi;
	}

	@Override
	public String dettagli() {
		
		return "Libro:\n"+
				"\tId: "+id+"\n"+
				"\tTitolo: "+titolo+"\n"+
				"\tAutore: "+autore+"\n"+
				"\tSinossi: "+sinossi+"\n"+
				"\tGenere: "+genere+"\n"+
				"\tCopie: "+nrCopie;
	}
	
	
	
}
