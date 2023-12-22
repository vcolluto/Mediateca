package org.generation.italy.exceptions;

public class CopieNonValideException extends Exception {	
	private static final long serialVersionUID = 1L;
	private int nrCopie;

	public CopieNonValideException(String messaggio, int nrCopie) {
		super(messaggio);		//passo il messaggio di errore a Exception
		this.nrCopie = nrCopie;
	}

	public int getNrCopie() {
		return nrCopie;
	}

	
}
