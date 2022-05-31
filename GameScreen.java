package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
	private Random random;
	private BufferedImage img;
	private long lastTime;
	private int frames;

	private double timePerFrame;
	private long lastFrame;

	private ArrayList <BufferedImage> sprites = new ArrayList();

	public GameScreen(BufferedImage img) {
		this.img=img;
		random = new Random();
		loadSprites();

		timePerFrame = 1000000000.0/60.0; 

	}




	private void loadSprites() {
		for (int y=0;y<10;y++) {
			for(int x = 0;x<10;x++) {
				sprites.add(img.getSubimage(x*32, y*32, 32, 32));
			}
		}
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		//		g.drawImage(sprites.get(19),0,0,null);
		//		g.drawImage(img.getSubimage(32*9, 32, 32, 32), 0, 0, null);
		for (int y=0;y<20;y++) {
			for(int x = 0;x<20;x++) {
				g.drawImage(sprites.get(getRandInt()),x*32 ,y*32, null);
			}
		}

		callFPS();

	}


	private void callFPS() {
		frames++;
		if(System.currentTimeMillis() - lastTime>=1000) {
			System.out.println("FPS:"+ frames);
			frames=0;
			lastTime=System.currentTimeMillis();
		}

	}
	private int getRandInt() {
		return random.nextInt(100);
	}
	private Color getRanColor() {
		int r =random.nextInt(256);
		int g =random.nextInt(256);
		int b =random.nextInt(256);
		return new Color(r,g,b);
	}

}

