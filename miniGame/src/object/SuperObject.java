package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import miniGame.GamePanel;

public class SuperObject 
{
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreDefaultX = 0;
	public int solidAreDefaultY = 0;
	public boolean godown = true; 
	GamePanel gp;
	
	
	
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

	
}
