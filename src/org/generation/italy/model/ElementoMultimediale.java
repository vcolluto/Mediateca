package org.generation.italy.model;

import java.time.LocalDate;
import java.util.ArrayList;

import org.generation.italy.exceptions.CopieNonValideException;
import org.generation.italy.exceptions.EmptyValueException;

public abstract class ElementoMultimediale {
	private static int prossimoId; 
	protected int id; // (autoincrementante)
	protected String titolo,genere;
	protected int nrCopie;
	
	private ArrayList<Prestito> elencoPrestiti=new ArrayList<Prestito>();

	public ElementoMultimediale(String titolo, String genere, int nrCopie) throws Exception{		//questo metodo può generare un'eccezione (throws)
		super();
		if (!titolo.isEmpty())
			this.titolo = titolo;
		else
			throw new EmptyValueException("Titolo");
		if (!genere.isEmpty())
			this.genere = genere;
		else
			throw new EmptyValueException("Genere");
		if (nrCopie>0)
			this.nrCopie = nrCopie;
		else 			
			throw new CopieNonValideException("Numero di copie non valido!",nrCopie);		//"lancio" un'eccezione se il numero di copie non è valido
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
