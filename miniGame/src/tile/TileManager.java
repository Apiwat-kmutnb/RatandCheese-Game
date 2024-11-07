package tile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import miniGame.GamePanel;

public class TileManager
{
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	
	public TileManager(GamePanel gp, int n)
	{
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage(n);
		if(n==1) {
			loadMap("/maps/map1.txt");
		}
		else if(n==2) {
			
			loadMap("/maps/map3.txt");
		}
		
		
	}
	
	public void getTileImage(int n)
	{
		if(n==1) {
			try
			{
				tile[0] = new Tile();
				tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FullGrass.png"));
				tile[0].collision = true;
				
				tile[1] = new Tile();
				tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Rice.png"));
				tile[1].collision = true;
				
				tile[2] = new Tile();
				tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FullGrass.png"));
				
				
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if(n==2) {
			System.out.println("n=="+n);
			try
			{
				tile[0] = new Tile();
				tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fullgrass.png"));
				
				
				tile[1] = new Tile();
				tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brick.png"));
				tile[1].collision = true;
				
				tile[2] = new Tile();
				tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Fullgrass.png"));
				tile[2].collision = true;
				
				
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void loadMap(String filePath) {
		try
		{
			InputStream is = getClass().getResourceAsStream(filePath); //collect file path 
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); //for reading the map1.txt content
			
			int col = 0;
			int row = 0;
			
			while(col<gp.maxWorldCol && row<gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col< gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
			
				col = 0;
				row++;
				
			}
			br.close();
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public void draw(Graphics g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.rat.worldX + gp.rat.screenX;
			int screenY = worldY - gp.rat.worldY + gp.rat.screenY;
			
			if(worldX + gp.tileSize > gp.rat.worldX - gp.rat.screenX &&
			   worldX - gp.tileSize < gp.rat.worldX +gp.rat.screenX &&
			   worldY + gp.tileSize >gp.rat.worldY - gp.rat.screenY &&
			   worldY - gp.tileSize < gp.rat.worldY + gp.rat.screenY){
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			
			
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
		
		
}
