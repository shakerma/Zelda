package main;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame{

	private GameScreen gameScreen;
	private BufferedImage img;
	private long lastTime;
	private int frames;

	private double timePerFrame;
	private long lastFrame;

	public Game() {

		importImg();

		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Dimension j = getSize();
		j.getWidth();
		gameScreen = new GameScreen(img);
		add(gameScreen);
		setVisible(true);

	}
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/s.png");	
		try {
			img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	//	private void loopGame() {
	//		while(true) {
	//		if(System.nanoTime()-lastTime>= timePerFrame) {
	//			lastFrame=System.nanoTime();
	//			repaint();
	//		}
	//		}
	//	}

	public int getWidth() {
		Dimension j = getSize();
		return (int) j.getWidth();
	}
	public int getHeight() {
		Dimension j = getSize();
		return (int) j.getHeight();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		//	game.loopGame();
	}

}
