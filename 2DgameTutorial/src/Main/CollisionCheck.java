package Main;

import entity.Entity;

public class CollisionCheck {

	GamePanel gp;
	
	public CollisionCheck(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void CheckTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldx + entity.solidarea.x;
		int entityRightWorldX = entity.worldx + entity.solidarea.x + entity.solidarea.width;
		int entityTopWorldY = entity.worldy + entity.solidarea.y;
		int entityBottomWorldY = entity.worldy + entity.solidarea.y + entity.solidarea.height;
		
		int entityLeftcol = entityLeftWorldX/gp.tileSize;
		int entityRightcol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		//check 
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
			
			case "up":
				entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftcol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightcol][entityTopRow];
				if(gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entity.collisionOn = true;
				}
				break;
				
			case "down":
				entityTopRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftcol][entityBottomRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightcol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entity.collisionOn = true;
				}
				break;
				
			case "right":
				entityRightcol = (entityRightWorldX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightcol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightcol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entity.collisionOn = true;
				}
				break;
				
			case "left":
				entityLeftcol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftcol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityLeftcol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entity.collisionOn = true;
				}
				break;
		}
		
	}
}
