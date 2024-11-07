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

public class Fireball extends SuperObject
{
	public boolean godown = true; 
	public int maxlength, minlength;
	public int speed = 1;
	GamePanel gp;
	
	public Fireball(int min, int max)
	{
		name = "Fireball";
		maxlength = max;
		minlength = min;
	 try
		{
			image = ImageIO.read(getClass().getResource("/objects/Fire.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	 	collision = true;
	 	startThead();
	}
	
	 public void draw(Graphics2D g2, GamePanel gp) {
			System.out.println("Fireball Draw");
			int screenX = worldX - gp.rat.worldX + gp.rat.screenX;
			int screenY = worldY - gp.rat.worldY + gp.rat.screenY;
			
			if(worldX + gp.tileSize > gp.rat.worldX - gp.rat.screenX &&
			   worldX - gp.tileSize < gp.rat.worldX +gp.rat.screenX &&
			   worldY + gp.tileSize >gp.rat.worldY - gp.rat.screenY &&
			   worldY - gp.tileSize < gp.rat.worldY + gp.rat.screenY){
				
				g2.drawImage(image, screenX, screenY, gp.tileSize-(gp.tileSize/4), gp.tileSize, null);
			}
			
			
	} 
	 
	 public void startThead() {
		 runner.start();
	 }
	 
	Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
            	if(worldY<=minlength) {
            		godown = true;
            	}
            	else if(worldY>=maxlength) {
            		godown = false;
            	}
            	//System.out.println("running");
            	if(godown) {
            		worldY+=speed;
            		
            	}
            	else {
            		worldY-=speed;
            	}
            	
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
                
            }
        }
    });
	
}
