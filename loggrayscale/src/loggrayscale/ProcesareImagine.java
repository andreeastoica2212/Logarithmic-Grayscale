package loggrayscale;

import java.awt.image.BufferedImage;
import java.lang.Math;

public class ProcesareImagine extends Operatii
{
	
	private BufferedImage img = null;
	
	public void setImage (BufferedImage image)
	{
		this.img=image;
	}
	
	public void Operatie()
	{
		int width = img.getWidth();
		int height = img.getHeight();

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				int pix=0;
				
				int alpha = 0xff & (img.getRGB(j, i)>>24);
				int red = 0xff &(img.getRGB(j, i)>>16);
                int green = 0xff &(img.getRGB(j, i)>>8);
                int blue = 0xff & img.getRGB(j, i);
                    
				//aplic log
				red = (int)Math.round( 100.0*Math.log10((double)red));
                green = (int)Math.round( 100.0*Math.log10((double)green));
                blue = (int)Math.round( 100.0*Math.log10((double)blue));
                
                //tai pixelii redundanti
                pix = pix | blue;
                pix = pix | (green <<8);
                pix = pix | (red <<16);
                pix = pix | (alpha <<24);
                
                img.setRGB( j, i, pix);
                pix = 0;
			}
		}

	}
	
	public BufferedImage imgProcesata ()
	{
		return this.img;
	}
}