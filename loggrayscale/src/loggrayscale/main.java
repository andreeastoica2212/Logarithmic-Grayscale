package loggrayscale;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {	
	public static void main (String[] args) 
	{	
		//CITIRE INFORMATII IDENTIFICARE FISIER SURSA SI FISIER DESTINATIE///////////////////////////////////////////
		Instant start1 = Instant.now(); //memoreaza timpul de inceput pentru acest thread
		
		//cod citire informatii de identificare propriu zis
		Interogare interogare = new Interogare();
		String nume_fisier_intrare, nume_fisier_iesire;
		
		interogare.InterogareFisiere();
		nume_fisier_intrare=interogare.getNume();
		nume_fisier_iesire=interogare.getNumeout();
		//cod citire informatii de identificare propriu zis
		
		Instant finish1 = Instant.now(); //memoreaza timpul de la sfarsitul executiei bucatii de cod
		//definita mai sus (cod citire informatii de identificare propriu zis)
		
	    long timeElapsed1 = Duration.between(start1, finish1).toMillis(); //face diferenta celor 2 timpi 
	    //obtinuti mai sus, pentru a obtine timpul de executie al bucatii de cod
	    
	    System.out.print("\nEtapa de citire informatii de identificare fisier dureaza: " + timeElapsed1 + "\n");
	    
	    //pentru fiecare etapa voi aplica acelasi procedeu pentru a masura timpul de executie
	    //CITIRE INFORMATII IDENTIFICARE FISIER SURSA SI FISIER DESTINATIE///////////////////////////////////////////
	    
		//CITIRE DIN FISIER//////////////////////////////////////////////////////////////////////////////////
	    Instant start2 = Instant.now();
	    
		CitireFisier citireFisier = new CitireFisier(nume_fisier_intrare);

		Instant finish2 = Instant.now();
		long timeElapsed2 = Duration.between(start2, finish2).toMillis();
		System.out.print("Etapa de citire a imaginii dureaza: " + timeElapsed2 + "\n");
		//FUNCTIE CITIRE DIN FISIER//////////////////////////////////////////////////////////////////////////////////
		
		
		//PROCESARE IMAGINE OBTINUTA/////////////////////////////////////////////////////////////////////////////////
		Instant start3 = Instant.now();
		
		ProcesareImagine procesareImagine = new ProcesareImagine();
		procesareImagine.setImage(citireFisier.img);
		procesareImagine.Operatie();
		
		Instant finish3 = Instant.now();
		long timeElapsed3 = Duration.between(start3, finish3).toMillis();
		System.out.print("Procesarea imaginii dureaza: " + timeElapsed3 + "\n");
		//PROCESARE IMAGINE OBTINUTA/////////////////////////////////////////////////////////////////////////////////
		
		//SCRIERE IN FISIER DESTINATIE///////////////////////////////////////////////////////////////////////////////
		Instant start4 = Instant.now();
		
		ScriereFisier scriereFisier = new ScriereFisier();
		scriereFisier.setImage(procesareImagine.imgProcesata());
		scriereFisier.Scriere(nume_fisier_iesire);
		
		Instant finish4 = Instant.now();
		long timeElapsed4 = Duration.between(start4, finish4).toMillis();
		System.out.print("Etapa de scriere in fisier dureaza: " + timeElapsed4 + "\n");
		//SCRIERE IN FISIER DESTINATIE////////////////////////////////////////////////////////////////////////////////
	
		//calculare timp pt etapa de citire completa 
		SumaEtape sumaEtape = new SumaEtape();
        long sum = sumaEtape.Suma(timeElapsed1, timeElapsed2);
        System.out.println("\nTimpul pentru intreaga etapa de citire este: " + sum);	
	}
	
	private static void methodToTime()  //clasa folosita pentru masurarea timpului de executie al portiunilor de cod
	{
	    try 
	    {
	      TimeUnit.SECONDS.sleep(3);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	}

}