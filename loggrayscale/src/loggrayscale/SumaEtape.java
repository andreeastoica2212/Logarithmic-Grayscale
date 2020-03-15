package loggrayscale;

public class SumaEtape 
{
	public long Suma(long ... args)
	{
        long sum=0;
		for(long x: args)
        {
            sum += x;
        }
        return sum;
    }
}
