package miniGame;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import entity.Rat;
import object.Cat;
import object.Fireball;
import object.SuperObject;
import tile.TileManager;
public class GamePanel extends JPanel implements Runnable
{
	//SCREEN SETTINGS
	final int  originalTileSize = 16; //16*16
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	
	public final int maxscreenCol = 20; //20 column
	public final int maxscreenRow = 12; //12 row
	public final  int screenWidth = tileSize * maxscreenCol; // 768 pixels
	public final  int screenHeight = tileSize * maxscreenRow; // 576 pixels
	
	//WORLD SETTING
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	
	//FPS
	int FPS =60;
	int n;
	
	//SYSTEM
	TileManager tileM;
	KeyHandler keyH = new KeyHandler();
	
	//SYSTEM
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui;
	Thread gameThread;
	
	
	//ENTITY AND OBJECT
	public Rat rat;
	public SuperObject obj[] = new SuperObject[4];
	
	public GamePanel(int n)
	{
		System.out.println("GamePanel(n) involke");
		this.n = n;
		
		this.setupGame();
		this.starGameThread();
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);
		
		this.addKeyListener(keyH);
		
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		aSetter.setObjectposition(n);
		tileM = new TileManager(this,n);
		rat = new Rat(this, keyH,n);
		ui = new UI(this,n);
	}
	
	public void starGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	

	public void run() {
	    System.out.println("run invoked");
	    
	    while (gameThread != null) {
	        update(); 
	        repaint(); 
	        
	        try {
	            Thread.sleep(1000/FPS); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	            Thread.currentThread().interrupt();
	        }
	    }
	}

	public void update() {
		rat.update();
	}
	
	public void paintComponent(Graphics g) { //method to draw things on screen
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//TILE
		tileM.draw(g2);
		
		//OBJECT cheese
		for(int i=0;i<obj.length;i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//PLAYER
		rat.draw(g2);
		
		//UI
		ui.draw(g2);
		
		
		g2.dispose();
	}

	
	
}
