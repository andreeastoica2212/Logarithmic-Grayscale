package loggrayscale;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CitireFisier
{
	public BufferedImage img = null;
	
	public CitireFisier(String numefisier) {
		File f = null;
		
	    try
	    {
	    	f = new File("/Users/andreeastoica/Desktop copy/facultate/anul3/sem1/awj/java/loggrayscale/" + numefisier + ".bmp");
	    	img=ImageIO.read(f);
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
	    }
	}
	
	public BufferedImage getImg()
	{
		return this.img;
	}
}
