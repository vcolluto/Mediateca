package org.generation.italy.model;

public class eBook extends Libro {
	private String formato;
	private int dimensioneKB;
	
	public eBook(String titolo, String genere, int nrCopie, String autore, String sinossi, String formato,
			int dimensioneKB) throws Exception {
		super(titolo, genere, nrCopie, autore, sinossi);
		this.formato = formato;
		this.dimensioneKB = dimensioneKB;
	}

	@Override
	public String dettagli() {		
		return "eBook:\n"+
				"\tId: "+id+"\n"+
				"\tTitolo: "+titolo+"\n"+
				"\tAutore: "+autore+"\n"+
				"\tSinossi: "+sinossi+"\n"+
				"\tGenere: "+genere+"\n"+
				"\tCopie: "+nrCopie+"\n"+
			"\tformato: "+formato+"\n"+
			"\tdimensione: "+dimensioneKB+" KB";
	}
	
	

}
