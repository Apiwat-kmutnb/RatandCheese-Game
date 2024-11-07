package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import miniGame.GamePanel;
import miniGame.KeyHandler;

public class Rat extends Animal
{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	 public Rat(GamePanel gp, KeyHandler keyH, int n) {
		 System.out.println("Rat involke");
		 this.gp = gp;
		 this.keyH = keyH;
		 
		 screenX = gp.screenWidth/2 - (gp.tileSize/2);
		 screenY = gp.screenHeight/2 - (gp.tileSize/2);
		 
		 solidArea = new Rectangle();
		 solidArea.x = 8;
		 solidArea.y = 17;
		 solidAreaDefaultX = solidArea.x;
		 solidAreaDefaultY = solidArea.y;
		 solidArea.width = 26;
		 solidArea.height = 17;
		 
		 setDefaultValues(n);
		 getRatImage();
	}
	 public void setDefaultValues(int n) {//setRatPosition Rat
		 if(n==1) {
			 worldX= gp.tileSize * 31;//starting point
			 worldY= gp.tileSize * 35;//starting point
			 
			 
		 }
		 else if(n==2) {
			 worldX= gp.tileSize * 33;//starting point
			 worldY= gp.tileSize * 32;//starting point
			 
		 }
		 speed = 4;
		 direction = "right";
		 
	 }
	 void getRatImage() {
		 try
		{
			up = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseUp.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseDown.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseL.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseL2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseR.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Rat/mouseR2.png"));
			 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	 }
	 public void update() {
		 
		 if(keyH.upPressed == true || keyH.downPressed == true || 
				 keyH.leftPressed == true || keyH.rightPressed == true ) {
			 if(keyH.upPressed == true) {
				 	direction = "up";
				}
				else if(keyH.downPressed == true) {
					direction = "down";
				}
				else if(keyH.leftPressed == true) {
					direction = "left";
					
				}
				else if(keyH.rightPressed == true) {
					direction = "right";
					
				}
			 
			 //CHECK TILE COLLISION
			 collision = false;
			 gp.cChecker.checkTile(this);
			 
			 //CHECK OBJ COLLISION
			 int objIndex = gp.cChecker.checkObject(this, true);
			 foundObject(objIndex);
			 
			 
			 //IF COLLISION IS FALSE, PLAYER CAN MOVE
			 if(collision == false) {
				 switch (direction) {
				 case "up": worldY -= speed; 
				 break;
				 case "down": worldY += speed; 
				 break;
				 case "left": worldX -= speed; 
				 break;
				 case "right": worldX += speed; 
				 break;
				 }
			 }
			 
			 spriteCounter++;
			 if(spriteCounter>12) {
				 if(spriteNum == 1) {
					 spriteNum = 2;
				 }
				 else if(spriteNum==2) {
					 spriteNum = 1;
				 }
				 spriteCounter = 0;
			 }
		 }
		 
		
	 }
	
	 public void foundObject(int i)
	{
		if(i != 999) {
			String objectName = gp.obj[i].name;
			if(objectName == "Cheese") {
				gp.ui.gameFinished = true;
				
			}
			else if(objectName == "Fireball") {
				gp.obj[i] = null;
				gp.ui.showMessage("-5 seconds");
				gp.ui.timeMinus(5);
			}
			else if(objectName == "Cat") {
				gp.obj[i] = null;
				gp.ui.showMessage("Slow!");
				gp.rat.speed -= 1;
			}
		}
	}
	 
	 
	 public void draw(Graphics g2) {
		 
		 BufferedImage Image = null;
		 
		 switch (direction)
		{
		 
		case "up":
			Image = up;
			break;
		case "down":
			Image = down;
			break;
		case "left":
			if(spriteNum == 1) {
				Image = left1;
			}
			if(spriteNum == 2) {
				Image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				Image = right1;
			}
			if(spriteNum == 2) {
				Image = right2;
			}
			break;
		}
		 
		 g2.drawImage(Image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	 }
		  
	

}
