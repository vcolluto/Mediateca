package org.generation.italy;

import org.generation.italy.model.Libro;
import org.generation.italy.model.Prestito;

public class Main {

	public static void main(String[] args) {
		
		Libro l=
			new Libro(
				"Il signore degli anelli - la compagnia dell'anello",
				"Fantasy",
				2,"Tolkien","Secoli dopo la sconfitta di Sauron, una compagnia di coraggiosi ...");
		
		if (l.effettuaPrestito("Pino")>0)
			System.out.println("Prestito effettuato");
		else
			System.out.println("Prestito non effettuato");
		if (l.effettuaPrestito("Enzo")>0)
			System.out.println("Prestito effettuato");
		else
			System.out.println("Prestito non effettuato");
		if (l.effettuaPrestito("Gino")>0)
			System.out.println("Prestito effettuato");
		else
			System.out.println("Prestito non effettuato");
		
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		l.restituisciPrestito(2);
		
		Libro l1=
			new Libro(
				"L'ombra dello scorpione",
				"Fantasy",
				5,"S.King","Una misteriosa epidemia stermina gran parte della popolazione ...");
		
		System.out.println(l.dettagli());
		
		
		for(Prestito p: l.getElencoPrestiti())
			System.out.println("Prestito: "+p.getId()+" - utente:"+p.getUtente()+
					" datainizio:"+p.getDataInizio()+" datafine:"+p.getDataFine());
		System.out.println(l1.dettagli());
	}

}
