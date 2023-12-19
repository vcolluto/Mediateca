package org.generation.italy.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ElementoMultimediale {
	private static int prossimoId; 
	protected int id; // (autoincrementante)
	protected String titolo,genere;
	protected int nrCopie;
	
	private ArrayList<Prestito> elencoPrestiti=new ArrayList<Prestito>();

	public ElementoMultimediale(String titolo, String genere, int nrCopie) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.nrCopie = nrCopie;
		prossimoId++;						//genero un nuovo id
		this.id=prossimoId;	
	}
	
	public int effettuaPrestito(String utente) {
		if (nrCopie>0) {
			Prestito prestito=new Prestito(utente);
			elencoPrestiti.add(prestito);
			nrCopie--;
			return prestito.getId();		
		} else	//non si può fare il prestito
			return -1;		
	}
	
	public void restituisciPrestito(int idPrestito) {
		for(Prestito prestito:elencoPrestiti)		//per ogni prestito
			if (prestito.getId()==idPrestito 
				&& prestito.getDataFine()==null)		//se trovo il prestito con quell'id 
			{
				prestito.setDataFine(LocalDate.now());	//imposto la data fine alla data attuale
				nrCopie++;
			}
	}

	public int getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getGenere() {
		return genere;
	}

	public int getNrCopie() {
		return nrCopie;
	}
	
	public Iterable<Prestito> getElencoPrestiti() {
		return elencoPrestiti;
	}
	
	public abstract String dettagli();
	
}
