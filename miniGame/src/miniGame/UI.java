package miniGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import javax.swing.JButton;

public class UI
{
	GamePanel gp;
	Font arial_20,arial_40, arial_80;
	public boolean messageOn = false;
	public String message = "";
	public int messageCount;
	public boolean gameFinished = false;
	
	//Time
	public double playTime = 20;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp,int n)
	{
		this.gp = gp;
		arial_20 = new Font("Arial", Font.BOLD, 20);
		arial_40 = new Font("Arial", Font.BOLD, 40);
		arial_80 = new Font("Arial", Font.BOLD, 85);
		setTime(n);
	}
	public void setTime(int n) {
		if(n==1) {
			playTime = 40;
		}
		else {
			playTime = 20;
		}
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
		messageCount = 0;
	}
	public void timeMinus(int n) {
		playTime -= n;
	}
	
	public void draw(Graphics2D g2) {
		if(playTime < 0) {
			gameFinished = true;
		}
		//Finished
		if(gameFinished == true) {
			
			String text1,text2;
			int texLenght;
			int x;
			int y;
			
			//set Text Win
			
			text2 = "Time remainning: "+dFormat.format(playTime);
			
			//set Text Lose
			if(playTime > 0) {
				text1 = "You Win!";
			}
			else {
				playTime=0.00;
				text1 = "Game Over!";
			}
			
			texLenght = 365;
			 x= gp.screenWidth/2 - texLenght/2;
			 y= gp.screenHeight/2 - (gp.tileSize*3);
			 
			//draw MESSAGE
			 g2.setColor(Color.white);
			 g2.setFont(arial_80);
			 g2.drawString(text1, x, y);
			 g2.setFont(arial_20);
			 g2.drawString(text2, x+60, y+30);
			
			 //Stop thread working
			 gp.gameThread = null;
			
		}
		//Not finish
		else {
			
			//TIME
			playTime -= (double)1/gp.FPS; 
			
			//set color red
			g2.setColor(Color.white);
			if(playTime<=10) {g2.setColor(Color.red);}
			g2.setFont(arial_40);
			//draw MESSAGE
			
			g2.drawString("Time: "+dFormat.format(playTime), gp.screenWidth-230, gp.tileSize*1);
			
			//MESSAGE
			if(messageOn == true) {
				g2.setFont(arial_40);
				g2.setColor(Color.WHITE);
				g2.drawString(message, 20, 260);
				messageCount ++;
				if(messageCount>150) {
					messageOn = false;
					messageCount = 0;
				}
				
			}
		}

	}
	
}
