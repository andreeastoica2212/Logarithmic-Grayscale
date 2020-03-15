package loggrayscale;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScriereFisier
{

	private BufferedImage img = null;
	
	public void setImage (BufferedImage image)
	{
		this.img=image;
	}
	
	public void Scriere(String fisier)
	{
		File f = null;
		try
	    {
	      f = new File("/Users/andreeastoica/Desktop copy/facultate/anul3/sem1/awj/java/loggrayscale/" + fisier + ".bmp");
	      ImageIO.write(img, "bmp", f);
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
	    }

	}

}
