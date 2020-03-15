package loggrayscale;

import java.lang.String;
import java.util.Scanner;

public class Scanare implements Fisiere //Scanare implementeaza o interfata
{
	
	protected String nume;
	
	public void setNume()
	{
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine();
		this.nume=inputString;
	}
	
	public String getNume()
	{
		return this.nume;
	}	
}