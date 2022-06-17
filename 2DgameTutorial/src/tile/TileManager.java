package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/zeldaMap.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(tile[0].image.getSubimage(0, 0, 30, 30), 0, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image.getSubimage(1200, 0, 30, 30), 48, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image.getSubimage(0, 0, 30, 30), 96, 0, gp.tileSize, gp.tileSize, null);
	}
}
