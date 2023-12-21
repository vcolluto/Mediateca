package org.generation.italy;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import org.generation.italy.model.AudioLibro;
import org.generation.italy.model.ElementoMultimediale;
import org.generation.italy.model.Film;
import org.generation.italy.model.Libro;
import org.generation.italy.model.LibroCartaceo;
import org.generation.italy.model.Mediateca;
import org.generation.italy.model.Prestito;
import org.generation.italy.model.eBook;

public class Main {
	static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		Mediateca m=new Mediateca();
		Scanner sc=new Scanner(System.in);
		String scelta;
		
				
		Libro l=
			new LibroCartaceo(
				"Il signore degli anelli - la compagnia dell'anello",
				"Fantasy",
				2,"Tolkien","Secoli dopo la sconfitta di Sauron, una compagnia di coraggiosi ...",700);
		m.aggiungiElemento(l);
		
		Libro l1=
			new eBook(
				"L'ombra dello scorpione",
				"Fantasy",
				5,"S.King","Una misteriosa epidemia stermina gran parte della popolazione ...","mobi",300);
		m.aggiungiElemento(l1);
		
		Film f=new Film("Pulp fiction", "Pulp", 2, "Tarantino", "B. Willis, J.Travolta, U. Thurman", 154);
		m.aggiungiElemento(f);
		
		do {
			//JConsole.clear();
			
			//JConsole.setForegroundColor(JConsoleColor.GREEN);
			//JConsole.setBold();
			System.out.println("\n\n\n\n\n\n\n\n\n\n**** MEDIATECA JAITA101 *****\n");
			//JConsole.resetText();
			System.out.println("1 - aggiungi elemento");
			System.out.println("2 - elenco elementi");
			System.out.println("3 - cerca per titolo");
			System.out.println("4 - effettua prestito");
			System.out.println("5 - restituisci prestito");
			System.out.println("6 - elenco prestiti");
			System.out.println();
			System.out.println("9 - esci");
			System.out.print("\nInserisci la tua scelta: ");
			scelta=sc.nextLine();
			
			switch (scelta) {
			case "1": {		//inserimento
				System.out.print("Che tipo di elemento vuoi aggiungere (L: libro/F: film/A: audiolibro/E: ebook): ");
				scelta=sc.nextLine();
				if (scelta.equalsIgnoreCase("L") || scelta.equalsIgnoreCase("F") ||
					scelta.equalsIgnoreCase("A") || scelta.equalsIgnoreCase("E")) {
					String titolo, genere;
					int nrCopie;
					System.out.print("Titolo: ");
					titolo=sc.nextLine();
					System.out.print("Genere: ");
					genere=sc.nextLine();
					System.out.print("Nr copie: ");
					nrCopie=Integer.parseInt(sc.nextLine());
					switch (scelta) {
						case "L":
						case "A":
						case "E":
							//chiedo autore, sinossi (comuni a tutti i libri)
							String autore, sinossi;						
							System.out.print("Autore: ");
							autore=sc.nextLine();
							System.out.print("Sinossi: ");
							sinossi=sc.nextLine();
							switch (scelta) {
								case "L": {		//libro cartaceo
									int nrPagine;
									System.out.print("Nr pagine: ");
									nrPagine=Integer.parseInt(sc.nextLine());
									m.aggiungiElemento(new LibroCartaceo(titolo, genere, nrCopie, autore, sinossi, nrPagine));
									break;
								}
								case "A": {		//audiolibro
									String voceNarrante;
									System.out.print("Voce narrante: ");
									voceNarrante=sc.nextLine();
									m.aggiungiElemento(new AudioLibro(titolo, genere, nrCopie, autore, sinossi, voceNarrante));						
									break;
								}
								case "E": {		//ebook
									String formato;
									int dimensioneKB;
									System.out.print("Formato: ");
									formato=sc.nextLine();
									System.out.print("Dimensione (KB): ");
									dimensioneKB=Integer.parseInt(sc.nextLine());
									m.aggiungiElemento(new eBook(titolo, genere, nrCopie, autore, sinossi, formato, dimensioneKB));						
									break;						
									
								}						
							}						
							
							break;
						case "F":
							//chiedo attori, durata, regista
							String attori, regista;
							int durata;
							System.out.print("Attori: ");
							attori=sc.nextLine();
							System.out.print("Regista: ");
							regista=sc.nextLine();
							System.out.print("durata: ");
							durata=Integer.parseInt(sc.nextLine());
							m.aggiungiElemento(new Film(titolo, genere, nrCopie, regista, attori, durata));
							break;
					}
				} else
					System.out.println("Scelta non valida!");
				break;	
			}
			case "2": {		//elenco di tutti gli elementi
				for (ElementoMultimediale e: m.getElencoElementi())
					System.out.println(e.dettagli());
				break;
			}
			case "3": {		//elenco filtrato per parola chiave
				String titolo;
				System.out.print("Titolo: ");
				titolo=sc.nextLine();
				for(ElementoMultimediale e:m.getElencoElementi(titolo))
					System.out.println(e.dettagli());
				break;
			}
				
			case "4": {		//effettua il prestito
				int id;
				System.out.print("Inserisci l'id dell'elemento da prestare: ");
				id=Integer.parseInt(sc.nextLine());
				ElementoMultimediale e=m.cercaElemento(id);
				System.out.println(e.dettagli());
				if (e.getNrCopie()>0) {
					String utente;
					System.out.print("Inserisci il nome dell'utente: ");
					utente=sc.nextLine();
					e.effettuaPrestito(utente);
					System.out.println("Prestito correttamente effettuato");
				} else 
					System.out.println("Nessuna copia disponibile!");
				break;
			}
			
			case "5": {		//restituisci prestito
				int id;
				System.out.print("Inserisci l'id dell'elemento da restituire: ");
				id=Integer.parseInt(sc.nextLine());
				ElementoMultimediale e=m.cercaElemento(id);
				System.out.println(e.dettagli());
				for(Prestito p:e.getElencoPrestiti())
					dettaglioPrestito(p);
				System.out.print("Inserisci l'id del prestito da restituire: ");
				int idPrestito=Integer.parseInt(sc.nextLine());
				for (Prestito p:e.getElencoPrestiti())
					if (p.getId()==idPrestito) {
						e.restituisciPrestito(idPrestito);
						System.out.println("Prestito correttamente restituito");
					}						
				break;
			}
			case "6": {		//elenco prestiti	
				HashMap<Integer, Prestito> elencoPrestiti=new HashMap<Integer, Prestito>();
				for(ElementoMultimediale e:m.getElencoElementi()) {
					System.out.println(e.dettagli());
					System.out.println("\t\nElenco prestiti:");
					for(Prestito p:e.getElencoPrestiti()) 
					{
						elencoPrestiti.put(p.getId(), p);
						dettaglioPrestito(p);					
						System.out.println();
					}
				}
					
				break;
			}
			case "9":
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida!");
			}
			System.out.println("Premi Enter per continuare...");
			sc.nextLine();
		} while (!scelta.equals("9"));
		
		sc.close();
	}

	private static void dettaglioPrestito(Prestito p) {	
		System.out.println("\tId: "+p.getId());
		System.out.println("\tData inizio: "+p.getDataInizio().format(dtf));
		System.out.print("\tData fine: ");
		if (p.getDataFine()!=null)
			System.out.println(p.getDataFine().format(dtf));
		System.out.println("\tUtente: "+p.getUtente());		
	}

}
