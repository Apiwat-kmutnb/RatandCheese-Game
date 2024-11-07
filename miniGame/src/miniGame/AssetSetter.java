package miniGame;

import object.Cat;
import object.Cheese;
import object.Fireball;
import object.Cheese;
import object.SuperObject;

public class AssetSetter
{
	GamePanel gp;
	
	public AssetSetter(GamePanel gp)
	{
		this.gp = gp;
	}
	
	public void setObjectposition(int n)
	{
		if(n==1) {
			gp.obj[0] = new Cheese();
			gp.obj[0].worldX = 34 * gp.tileSize;
			gp.obj[0].worldY = 34 * gp.tileSize;
			
			gp.obj[1] = new Fireball(18 *gp.tileSize,32 *gp.tileSize);
			gp.obj[1].worldX = 31 * gp.tileSize;
			gp.obj[1].worldY = 18 * gp.tileSize;
			
			gp.obj[2] = new Fireball(16 *gp.tileSize,34 *gp.tileSize);
			gp.obj[2].worldX = 33 * gp.tileSize;
			gp.obj[2].worldY = 16 * gp.tileSize;
			
			gp.obj[3] = new Cat(16 *gp.tileSize, 33 *gp.tileSize);
			gp.obj[3].worldX = 16 * gp.tileSize;
			gp.obj[3].worldY = 16 * gp.tileSize;
		}
		else if(n==2) {
			gp.obj[0] = new Cheese();
			gp.obj[0].worldX = 15 * gp.tileSize;
			gp.obj[0].worldY = 17 * gp.tileSize;
			
			//cat
			gp.obj[1] = new Cat(16 *gp.tileSize,22 *gp.tileSize);
			gp.obj[1].worldX = 16 * gp.tileSize;
			gp.obj[1].worldY = 24 * gp.tileSize;
			
			gp.obj[2] = new Cat(24 *gp.tileSize,26*gp.tileSize);
			gp.obj[2].worldX = 24 * gp.tileSize;
			gp.obj[2].worldY = 26 * gp.tileSize;
			
			gp.obj[3] = new Fireball(17 *gp.tileSize,20 *gp.tileSize);
			gp.obj[3].worldX = 18 * gp.tileSize;
			gp.obj[3].worldY = 17 * gp.tileSize;
			
		}
		
	}
}
