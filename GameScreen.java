package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScreen extends JPanel implements ActionListener, KeyListener{

	//	private Random random;
	//	private long lastTime;
	//	private int frames;
	//	private double timePerFrame;
	//	private long lastFrame;
	private Game game;
	private BufferedImage img;
	Timer tm = new Timer(5, this);
	int x=0, y=0, velx=0, vely=0;
	int direction=0;

	private ArrayList <BufferedImage> sprites = new ArrayList();

	public GameScreen(BufferedImage img) {
		this.img=img;
		//		random = new Random();
		loadSprites();
		//		timePerFrame = 1000000000.0/60.0; 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}


	private void loadSprites() {

		sprites.add(img.getSubimage(0, 0,120, 130));
		sprites.add(img.getSubimage(0, 130,120, 130));
		sprites.add(img.getSubimage(0, 260,120, 130));
		sprites.add(img.getSubimage(0, 390,120, 130));


	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(sprites.get(direction),x ,y, null);
		tm.start();
		//		callFPS();

	}


	//	private void callFPS() {
	//		frames++;
	//		if(System.currentTimeMillis() - lastTime>=1000) {
	//			System.out.println("FPS:"+ frames);
	//			frames=0;
	//			lastTime=System.currentTimeMillis();
	//		}
	//
	//	}
	//	private int getRandInt() {
	//		return random.nextInt(4);
	//	}
	//	private Color getRanColor() {
	//		int r =random.nextInt(256);
	//		int g =random.nextInt(256);
	//		int b =random.nextInt(256);
	//		return new Color(r,g,b);
	//	}


	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c==KeyEvent.VK_LEFT) {
			velx=-1;
			vely =0;
			direction = 1;
		}
		else if(c==KeyEvent.VK_RIGHT) {
			velx=1;
			vely=0;
			direction = 3;

		}
		if(c==KeyEvent.VK_UP) {
			velx=0;
			vely=-1;
			direction = 2;

		}
		if(c==KeyEvent.VK_DOWN) {
			velx=0;
			vely=1;
			direction =0;
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		velx=0;
		vely=0;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//		System.out.println(game.getWidth());
		if( x<0) {
			velx=0;
			x=0;
		}
		if( y<0) {
			vely=0;
			y=0;
		}
		if( y> 645) {
			vely=0;
			y=645;
		}
		if( x> 700) {
			velx=0;
			x=700;
		}
		x+=velx;		
		y+=vely;
		repaint();
	}

}
