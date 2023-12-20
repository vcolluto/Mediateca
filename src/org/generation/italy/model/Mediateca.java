package org.generation.italy.model;

import java.util.ArrayList;

public class Mediateca {
	private ArrayList<ElementoMultimediale> elencoElementi=new ArrayList<ElementoMultimediale>();
	
	public void aggiungiElemento(ElementoMultimediale elemento)  {
		elencoElementi.add(elemento);
	}
	
	public Iterable<ElementoMultimediale> getElencoElementi() {		//restituisce tutti gli elementi
		return elencoElementi;
	}
	
	public Iterable<ElementoMultimediale> getElencoElementi(String parolaChiave) {	//restituisce tutti gli elementi che contengono nel titolo la parola chiave
		ArrayList<ElementoMultimediale> elementiFiltrati=new ArrayList<>();
		for(ElementoMultimediale e:elencoElementi)
			if (e.getTitolo().contains(parolaChiave))
				elementiFiltrati.add(e);
		return elementiFiltrati;
	}
	
	public ElementoMultimediale cercaElemento(int id) {
		for(ElementoMultimediale e:elencoElementi)
			if (e.getId()==id)
				return e;
		return null;		//se l'id non è presente restituisce un oggetto vuoto
	}
	
	public ElementoMultimediale cercaElemento(String titolo) {
		for(ElementoMultimediale e:elencoElementi)
			if (e.getTitolo().equals(titolo))		//restituisce il primo che trova
				return e;
		return null;		//se l'id non è presente restituisce un oggetto vuoto
	}
}
