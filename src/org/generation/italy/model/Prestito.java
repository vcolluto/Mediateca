package org.generation.italy.model;

import java.time.LocalDate;

public class Prestito {
	private static int prossimoId=0;		//prossimo id generato (condiviso)
	
	protected int id;						//id del prestito (di istanza)
	
	protected String utente;
	
	protected LocalDate dataInizio, dataFine;

	public Prestito(String utente) {
		super();
		prossimoId++;						//genero un nuovo id
		this.id=prossimoId;					//lo assegno al prestito creato
		this.utente = utente;
		this.dataInizio=LocalDate.now();	//data attuale
		this.dataFine=null;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public int getId() {
		return id;
	}

	public String getUtente() {
		return utente;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	} 
	
	
}
