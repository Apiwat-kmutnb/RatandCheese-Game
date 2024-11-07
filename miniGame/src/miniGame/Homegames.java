package miniGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homegames extends JPanel 
{
	public BufferedImage fire,cat; 
	public String s1,s2;
	Font arial_40;
	ImageIcon firstmap = new ImageIcon(this.getClass().getResource("/tiles/map11.png"));	//image button
	ImageIcon secondmap = new ImageIcon(this.getClass().getResource("/tiles/map2.png")); //image button
	ImageIcon background  = new ImageIcon(this.getClass().getResource("/tiles/Background.png")); //image background
	JButton jbt_map1 = new JButton(firstmap); 
	JButton jbt_map2 = new JButton(secondmap);
	
	Homegames(){
		s1="=-5 seconds";
		s2="=speed down";
		arial_40 = new Font("Arial", Font.BOLD, 40);
		setLayout(null);
		jbt_map1.setBounds(475, 570, 120, 65);
		jbt_map2.setBounds(625, 570, 120, 65);
		add(jbt_map1);
		add(jbt_map2);
		this.getImage();
		
	}
	void getImage() {
		 try
		{
			fire = ImageIO.read(getClass().getResourceAsStream("/objects/Fire.png"));
			cat = ImageIO.read(getClass().getResourceAsStream("/objects/OrangeCatR.png"));
			 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	 }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(),0,0,1300,700,this);
		g.drawImage(fire,30,50,60,60,null);
		g.drawImage(cat,30,130,60,60,null);
		g.setColor(Color.black);
		g.setFont(arial_40);
		g.drawString(s1, 95, 95);
		g.drawString(s2, 95, 175);
	}
	
	

}
