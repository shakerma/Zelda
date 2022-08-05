package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[30];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/map/Map3.txt");
	}
	
	public void getTileImage() {
		try {
			
			//brown tile with cave thing 
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(126, 0, 30, 30);
			tile[0].collison=true;
			
			//sand tile 
			tile[1]= new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(432, 392, 30, 30);
			
			//tile[1].image = tile[0].image.getSubimage(432, 392, 30, 30);
			
			//brown block 
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(0, 0, 30, 30);
			tile[2].collison = true;
			
			//grey block (grey version of brown block)
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(0, 300, 30, 30);
			tile[3].collison=true;
			
			//grey rock block (square dots)
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(315, 200, 30, 30);
			tile[4].collison=true;
			
			//water block 
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(425, 220, 30, 30);
			tile[5].collison=true;
			
			//grass tile 
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(528, 416, 30, 30); //528 346 30 30
			tile[6].collison=true;
			
			//plain grey block 
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(130, 230, 30, 30);
			
			//tree block 
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(97, 77, 30, 30);  //97 77 30 30
			tile[8].collison=false;
			
			//blue ladder with brown block 
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(27, 37, 30, 30);  
			
			//brown cave tile 2 
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(144, 0, 30, 30);  
			tile[10].collison=true;
			
			//bottom brown cave block R
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(144, 40, 30, 30);  
			tile[11].collison=true;
			
			//half brown block half sand 
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(244, 40, 30, 30);  //98 30 30 30 
			tile[12].collison=true;
			
			//closing brown block cave thing bottom L
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(84, 40, 30, 30); 
			tile[13].collison=true;
			
			//bottom brown cave block R #2
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(154, 30, 30, 30); 
			tile[14].collison=true;
			
			//triangle brown dot formation 
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(135, 76, 30, 30); 
			tile[15].collison=true;
			
			//brown dots square formation 
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(373, 76, 30, 30); 
			tile[16].collison=true;
			
			//more grey square dots 
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(137, 147, 30, 30);
			tile[17].collison=true;
			
			//brown cave block #3 (top) 
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(368, 0, 30, 30);
			tile[18].collison=true;
			
			//brown rock bolder 
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(466, 16, 30, 30);
			tile[19].collison=true;
			
			//water bridge 
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(724, 206, 30, 30);

			//grey rock boulder 
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(73, 165, 30, 30);
			tile[21].collison=true;
			
			//grey rock with ladder 
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(59, 305, 30, 30);
			
			//brown circles block 
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(156, 365, 30, 30);
			tile[23].collison=true;
			
			//brown circle block rectangle 
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(319, 308, 30, 30);
			tile[24].collison=true;
			
			//green circle block 
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(596, 292, 30, 30);
			tile[25].collison=true;

			//sparse green circles 
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png")).getSubimage(596, 322, 30, 30);
			tile[26].collison=true;
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap (String FilePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" "); 
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		
		/*g2.drawImage(tile[2].image, 0, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 96, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[9].image, 144, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 192, 0, gp.tileSize, gp.tileSize, null);
		
		
		g2.drawImage(tile[2].image, 0, 48, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 48, 48, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 96, 48, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 144, 48, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, 192, 48, gp.tileSize, gp.tileSize, null);


		g2.drawImage(tile[2].image, 0, 96, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 48, 96, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[8].image, 96, 96, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[8].image, 144, 96, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, 192, 96, gp.tileSize, gp.tileSize, null);
		
		g2.drawImage(tile[1].image, 0, 144, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 48, 144, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 96, 144, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 144, 144, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 192, 144, gp.tileSize, gp.tileSize, null);

		g2.drawImage(tile[1].image, 0, 192, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[5].image, 48, 192, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[5].image, 96, 192, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[5].image, 144, 192, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, 192, 192, gp.tileSize, gp.tileSize, null); 
		
		*/

		int worldCol =0;
		int worldRow=0;
		//int x=0;
		//int y=0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol*gp.tileSize;
			int worldY = worldRow*gp.tileSize;
			int screenX = worldX - gp.player.worldx + gp.player.screenX;
			int screenY = worldY - gp.player.worldy + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldx - gp.player.screenX && 
					worldX - gp.tileSize < gp.player.worldx + gp.player.screenX && 
					worldY + gp.tileSize > gp.player.worldy - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldy +gp.player.screenY ) {
			
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
				
			worldCol++;
			//x +=gp.tileSize;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol=0;
				//x=0;
				worldRow++;
				//y += gp.tileSize;
			}
		} 
		
	}
}
