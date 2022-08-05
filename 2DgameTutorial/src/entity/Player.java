package entity;



//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
	
		this.gp =gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2- (gp.tileSize/2);
		
		solidarea = new Rectangle(20, 24, 4, 4); // 8 16 32 32
 		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		//default player position 
		worldx=gp.tileSize * 23;  //100
		worldy=gp.tileSize * 21;  //100
		speed=4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		InputStream is = getClass().getResourceAsStream("/player/zeldaGame_Sprites.png");
		
		try {
			
			//link = ImageIO.read(is);
			//up1 = ImageIO.read(getClass().getResourceAsStream("/player/zeldaGame_Sprites.png"));
			up1 = ImageIO.read(is);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	if(keyH.downPressed == true||keyH.upPressed == true|| keyH.leftPressed == true||keyH.rightPressed == true) {
		if(keyH.upPressed == true) {
			direction = "up";
			//worldy -= speed; //playerY = playerY - playerSpeed
		}
		else if (keyH.downPressed == true) {
			direction = "down";
			//worldy += speed;
		}
		else if(keyH.leftPressed == true) {
			direction ="left";
			//worldx -= speed;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			//worldx += speed;
		}
		
		//checking for collison 
		collisionOn = false;
		gp.collision.CheckTile(this);
		
		//if collision is false then player can move 
		if(collisionOn == false) {
			switch(direction) {
			
				case "up":
					worldy -= speed;
					break;
					
				case "down":
					worldy += speed;
					break;
				
				case "right":
					worldx += speed;
					break;
				
				case "left":
					worldx -= speed;
					break;
			}
		}
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum =2;
			}
			else if(spriteNum == 2) {
				spriteNum =1;
			}
			spriteCounter = 0;
		}
		
	   }
	}
	
	public void Draw(Graphics2D g2) {

		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
			
		case "up":
			if(spriteNum==1) {
				image = up1.getSubimage(90, 0, 30, 30);
			}
			if(spriteNum==2) {
				image = up1.getSubimage(90, 30, 30, 30);
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = up1.getSubimage(25, 0, 30, 30);
			}
			if(spriteNum == 2) {
				image = up1.getSubimage(25, 30, 30, 30);
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = up1.getSubimage(50, 0, 30, 30);
			}
			if(spriteNum == 2) {
				image = up1.getSubimage(50, 30, 30, 30);
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = up1.getSubimage(120, 0, 30, 30);
			}
			if(spriteNum == 2) {
				image = up1.getSubimage(120, 30, 30, 30);
			}
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); // Draw player
		g2.fillRect(screenX + solidarea.x, screenY + solidarea.y, solidarea.width, solidarea.height); // Draw collision rectangle
	}
	
}
