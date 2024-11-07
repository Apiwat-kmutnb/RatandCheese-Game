package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Animal
{
	public int worldX,worldY;
	public int speed;
	
	public BufferedImage up,down, left1, left2, right1,right2;
	public String direction;
	
	public int spriteCounter = 0;
	public  int spriteNum = 1;
	
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
	
	public abstract void setDefaultValues(int n);
	public abstract void draw(Graphics g);
}
