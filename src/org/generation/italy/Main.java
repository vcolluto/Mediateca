package org.generation.italy;

import org.generation.italy.model.Prestito;

public class Main {

	public static void main(String[] args) {
		Prestito p1=new Prestito("Enzo");
		
		System.out.println("id="+p1.getId()+ "   datainizio="+p1.getDataInizio());

		
		Prestito p2=new Prestito("Gino");
		
		System.out.println("id="+p2.getId()+ "   datainizio="+p2.getDataInizio());

Prestito p3=new Prestito("Pino");
		
		System.out.println("id="+p3.getId()+ "   datainizio="+p3.getDataInizio());
	}

}
