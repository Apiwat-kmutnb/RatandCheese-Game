package miniGame;

import entity.Animal;

public class CollisionChecker
{
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp)
	{
		this.gp = gp;
	}
	
	public void checkTile(Animal animal) {
		
		int entityLeftWorldX = animal.worldX +animal.solidArea.x; //Left of Rat
		int entityRightWorldX = animal.worldX +animal.solidArea.x + animal.solidArea.width; //Right of Rat//bottom of Rat
		int entityTopWorldY = animal.worldY + animal.solidArea.y; //Top of Rat
		int entityBottomWorldY = animal.worldY +animal.solidArea.y + animal.solidArea.height; //bottom of Rat
	
		int entityLeftCol = entityLeftWorldX/gp.tileSize; //Tile position
		int entityRightCol = entityRightWorldX/gp.tileSize; //Tile position
		int entityTopRow  = entityTopWorldY/gp.tileSize; //Tile position
		int entityBottomRow = entityBottomWorldY/gp.tileSize; //Tile position
		
		int tileNum1 , tileNum2;
		
		switch (animal.direction)
		{
		case "up":
			entityTopRow = (entityTopWorldY - animal.speed)/ gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];//check Left top
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];//check Right top
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				animal.collision = true;
			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY + animal.speed)/ gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow]; //check Left bottom
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow]; //check Right bottom
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				animal.collision = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - animal.speed)/ gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				animal.collision = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + animal.speed)/ gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				animal.collision = true;
			}
			break;
		}
	}
	
	public int checkObject (Animal animal, boolean rat) {
		
		int index = 999;
		
		for(int i=0;i<gp.obj.length;i++) {
			if(gp.obj[i] != null) {
				//get Animal's solid are position
				animal.solidArea.x = animal.worldX +animal.solidArea.x;
				animal.solidArea.y = animal.worldY +animal.solidArea.y;
				// get the object's solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				switch(animal.direction) {
				case "up":
					animal.solidArea.y -= animal.speed;
					if(animal.solidArea.intersects(gp.obj[i].solidArea)) {//check crash UP
						if(gp.obj[i].collision == true) {
							animal.collision = true;
						}
						if(rat == true) {
							index = i;
						}
					}
					break;
				case "down":
					animal.solidArea.y += animal.speed;
					if(animal.solidArea.intersects(gp.obj[i].solidArea)) {//check crash Down
						if(gp.obj[i].collision == true) {
							animal.collision = true;
						}
						if(rat == true) {
							index = i;
						}
					}
					break;
				case "left":
					animal.solidArea.x -= animal.speed;
					if(animal.solidArea.intersects(gp.obj[i].solidArea)) {//check crash LEFT
						if(gp.obj[i].collision == true) {
							animal.collision = true;
						}
						if(rat == true) {
							index = i;
						}
					}
					break;
				case "right":
					animal.solidArea.y += animal.speed;
					if(animal.solidArea.intersects(gp.obj[i].solidArea)) { //check crash RIGHT
						if(gp.obj[i].collision == true) {
							animal.collision = true;
						}
						if(rat == true) {
							index = i;
						}
					}
					break;
				}
			}
			if(gp.obj[i] != null) {
				animal.solidArea.x = animal.solidAreaDefaultX;
				animal.solidArea.y = animal.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreDefaultY;
			}
		}
		
		return index;
	}

	
}
