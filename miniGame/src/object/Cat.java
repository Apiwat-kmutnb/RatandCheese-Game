package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniGame.GamePanel;

public class Cat extends SuperObject
{
	public BufferedImage image1, image2;
	public boolean goright = true; 
	public int maxlength, minlength;
	GamePanel gp;
	
	public Cat(int min, int max)
	{
		name = "Cat";
		maxlength = max;
		minlength = min;
	 try
		{
			image1 = ImageIO.read(getClass().getResource("/objects/OrangeCatR.png"));
			image2 = ImageIO.read(getClass().getResource("/objects/OrangeCatL.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	 collision = true;
	 	startThead();
	}
	
	 public void draw(Graphics2D g2, GamePanel gp) {
			
			int screenX = worldX - gp.rat.worldX + gp.rat.screenX;
			int screenY = worldY - gp.rat.worldY + gp.rat.screenY;
			
			if(worldX + gp.tileSize > gp.rat.worldX - gp.rat.screenX &&
			   worldX - gp.tileSize < gp.rat.worldX +gp.rat.screenX &&
			   worldY + gp.tileSize >gp.rat.worldY - gp.rat.screenY &&
			   worldY - gp.tileSize < gp.rat.worldY + gp.rat.screenY){
				
				g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			
			
	} 
	 
	 public void startThead() {
		 runner.start();
	 }
	 
	Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
            	if(worldX<=minlength) {
            		goright = true;
            	}
            	else if(worldX>=maxlength) {
            		goright = false;
            	}
            	//System.out.println("running");
            	if(goright) {
            		image = image1;
            		worldX++;
            		
            	}
            	else {
            		image = image2;
            		worldX--;
            	}
            	
                try {
                    runner.sleep(5);
                } catch (InterruptedException e) {
                }
                
            }
        }
    });
	
}
