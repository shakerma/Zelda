package entity;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
	
		this.gp =gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x=100;
		y=100;
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
			y -= speed; //playerY = playerY - playerSpeed
		}
		else if (keyH.downPressed == true) {
			direction = "down";
			y += speed;
		}
		else if(keyH.leftPressed == true) {
			direction ="left";
			x -= speed;
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
			x += speed;
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
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
	
}
