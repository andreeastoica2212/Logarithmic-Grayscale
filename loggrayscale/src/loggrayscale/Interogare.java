package loggrayscale;

import java.lang.String;

public class Interogare extends Scanare
{ //Interogare mosteneste clasa Scanare
	
	public String numein;
	public String numeout;
	
	public void InterogareFisiere()
	{
		System.out.print("Introduceti numele fisierului de intrare: ");
		Interogare nume_fisier_intrare = new Interogare();
		nume_fisier_intrare.setNume();
		numein=nume_fisier_intrare.nume;
		
		System.out.print("Introduceti numele fisierului de iesire: ");
		Scanare nume_fisier_iesire = new Scanare();
		nume_fisier_iesire.setNume();
		numeout=nume_fisier_iesire.nume;
	}
	
	public String getNume()  //polimorfism cu clasa Scanare
	{
		return this.numein;
	}
	
	public String getNumeout()
	{
		return this.numeout;
	}
	
}
