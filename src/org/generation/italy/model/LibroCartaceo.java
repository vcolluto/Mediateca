package org.generation.italy.model;

public class LibroCartaceo extends Libro {

	private int pagine;
	
	public LibroCartaceo(String titolo, String genere, int nrCopie, String autore, String sinossi, int pagine) throws Exception {
		super(titolo, genere, nrCopie, autore, sinossi);
		this.pagine=pagine;
	}

	@Override
	public String dettagli() {		
		return "Libro cartaceo:\n"+
				"\tId: "+id+"\n"+
				"\tTitolo: "+titolo+"\n"+
				"\tAutore: "+autore+"\n"+
				"\tSinossi: "+sinossi+"\n"+
				"\tGenere: "+genere+"\n"+
				"\tCopie: "+nrCopie+"\n"+
				"\tPagine: "+pagine;
	}

	
	
	
}
