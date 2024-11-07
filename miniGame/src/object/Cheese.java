package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Cheese extends SuperObject
{
	 public Cheese()
	{
		 name = "Cheese";
		 try
		{
			image = ImageIO.read(getClass().getResource("/objects/Cheese.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		 collision = true;
	}
}
