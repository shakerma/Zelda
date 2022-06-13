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
	private BufferedImage link;
	private BufferedImage world;

	Timer tm = new Timer(5, this);
	int x=0, y=0, velx=0, vely=0;
	int direction=0,screennumber=0;

	private ArrayList <BufferedImage> sprites = new ArrayList();
	private ArrayList <BufferedImage> screens = new ArrayList();


	public GameScreen(BufferedImage link, BufferedImage world) {
		this.link=link;
		this.world=world;
		//		random = new Random();
		loadSprites();
		//		timePerFrame = 1000000000.0/60.0; 
		loadScreens();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}


	private void loadSprites() {
		//walking
		sprites.add(link.getSubimage(25, 0,30, 30));//down
		sprites.add(link.getSubimage(50, 0,30, 30));//left
		sprites.add(link.getSubimage(90, 0,30, 30));//up
		sprites.add(link.getSubimage(120, 0,30, 30));//right
		//attacking
		sprites.add(link.getSubimage(150, 0,25, 40));//down
		sprites.add(link.getSubimage(170, 0,40,30 ));//left
		sprites.add(link.getSubimage(210, 0,20, 40));//up
		sprites.add(link.getSubimage(230, 0,35, 30));//right	

	}
	private void loadScreens() {
		//top level 0 - 11
		for(int i =0; i<11;i++) {
			screens.add(world.getSubimage(i*350, 0,500,350));	
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(screens.get(screennumber),0 ,0,500,500, null);
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
		//moving
		int c = e.getKeyCode();
		int previous=0;

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
		//attacking
		if(c== KeyEvent.VK_A && (direction==1||direction ==5)) {
			velx=-1;
			vely =0;
			direction = 5;		}
		if(c== KeyEvent.VK_A && (direction==3|| direction==7) ){
			velx=1;
			vely=0;
			direction = 7;

		}
		if(c== KeyEvent.VK_A && (direction==2||direction ==6)) {
			velx=0;
			vely=-1;
			direction = 6;

		}
		if(c== KeyEvent.VK_A && (direction==0||direction==4)){
			velx=0;
			vely=1;
			direction =4;
		}
		previous=c;
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
			x=440;
			if(screennumber==0) {
				return;
			}
			screennumber-=1;
		}
		if( y<0) {
			vely=0;
			y=0;
		}
		if( y> 450) {
			vely=0;
			y=450;
		}
		if( x> 450) {
			velx=0;
			x=10;
			if(screennumber==11) {
				return;
			}
			screennumber+=1;
		}
		x+=velx;		
		y+=vely;
		repaint();
	}

}

