<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
=======
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private int FPS = 30;
	private int targetTime = 1000 / FPS;
	
	private TileMap tileMap;
	private Player player;
<<<<<<< HEAD
	
	private ArrayList<Ennemi> ennemis;
	private ArrayList<Item> items;
	
=======
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce
	private Menu menu;
	public GamePanel(Menu menu) {
		super();
		this.menu = menu;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	public void run() {
		
		init();
		
		long startTime;
		long urdTime;
		long waitTime;
		
		while(running) {
			
			startTime = System.nanoTime();
			
			update();
			render();
			draw();
			
			urdTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - urdTime;
			
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception e) {
			}
			
		}
		
	}
	
	private void init() {
		
		running = true;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
<<<<<<< HEAD

		JukeBox.init();
		JukeBox.load("level1.wav", "level1");
		JukeBox.load("getitem.wav", "item");
		JukeBox.load("killennemi.wav", "killennemi");
		JukeBox.load("badtouch.wav", "badtouch");
		//JukeBox.setVolume("level1", -40f);
		JukeBox.play("badtouch");
		
=======
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce
		tileMap = new TileMap("testmap2.txt", 32);
		tileMap.loadTiles("graphics/tileset.gif");
		
		player = new Player(tileMap);
		player.setx(50);
		player.sety(50);
		
<<<<<<< HEAD
		ennemis = new ArrayList<Ennemi>();
		items = new ArrayList<Item>();
		
		
		// ADD ENNEMIES
		for(int j = 0 ; j < 3 ; j++){
			ennemis.add(new Ennemi(tileMap));
		}
		ennemis.get(0).setx(50);
		ennemis.get(0).sety(50);
		ennemis.get(1).setx(200);
		ennemis.get(1).sety(50);
		ennemis.get(2).setx(300);
		ennemis.get(2).sety(50);
		
		// ADD ITEMS
		for(int j = 0 ; j < 4 ; j++){
			items.add(new Item("vodka", tileMap));
		}
		items.get(0).setx(80);
		items.get(0).sety(80);
		items.get(1).setx(210);
		items.get(1).sety(170);
		items.get(2).setx(300);
		items.get(2).sety(330);
		items.get(3).setx(500);
		items.get(3).sety(150);
		
=======
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	private void update() {
		
		tileMap.update();
		player.update();
		
<<<<<<< HEAD

		//                          COLLISION WITH THE ENNEMIES
		
		for(Ennemi en : ennemis){
			en.update();
		
		//TOP / BOTTOM
			if ((player.getx() >= en.getx() &&
				player.getx() <= en.getx() + en.getWidth())
				
				||
				
				(player.getx() + player.getWidth() >= en.getx() &&
				player.getx() + player.getWidth() <= en.getx() + en.getWidth())){
				
				//TOP
				if (player.gety() + player.getHeight() >= en.gety() - 6 &&
				    player.gety() + player.getHeight() <= en.gety() + 6){
					player.setFalling(false);
					player.setJumping(true);
					en.stop();
					JukeBox.play("killennemi");
					//ennemis.remove(en);
					//break;
				}
				
			}
			
		//LEFT / RIGHT
			if ((player.gety() >= en.gety() &&
					player.gety() <= en.gety() + en.getHeight())
					
				||
				
				(player.gety() + player.getHeight() >= en.gety() &&
				player.gety() + player.getHeight() <= en.gety() + en.getHeight())){
				
				//LEFT + RIGHT
				if ((player.getx() + player.getWidth() >= en.getx() - 2.1 &&
				    player.getx() + player.getWidth() <= en.getx() + 2.1) ||
				    (player.getx() >= en.getx() + en.getWidth() - 2.1 &&
				    player.getx() <= en.getx() + en.getWidth() + 2.1)){
					
					System.out.println("die");
				}
					
			}
			
		}
		
		
		//                          COLLISION WITH THE ITEMS
		
		for(Item it : items){
			it.update();
		
		//TOP / BOTTOM
			if ((player.getx() >= it.getx() &&
				player.getx() <= it.getx() + it.getWidth())
				
				||
				
				(player.getx() + player.getWidth() >= it.getx() &&
				player.getx() + player.getWidth() <= it.getx() + it.getWidth())){
				
				//TOP + BOTTOM
				if ((player.gety() + player.getHeight() >= it.gety() - 6 &&
				    player.gety() + player.getHeight() <= it.gety() + 6) ||
				    (player.gety() >= it.gety() + it.getHeight() - 6 &&
				    player.gety() <= it.gety() + it.getHeight() + 6)){

					JukeBox.play("item");
					items.remove(it);
					break;
				}
				
			}
			
		//LEFT / RIGHT
			if ((player.gety() >= it.gety() &&
					player.gety() <= it.gety() + it.getHeight())
					
				||
				
				(player.gety() + player.getHeight() >= it.gety() &&
				player.gety() + player.getHeight() <= it.gety() + it.getHeight())){
				
				//LEFT + RIGHT
				if ((player.getx() + player.getWidth() >= it.getx() - 2.1 &&
				    player.getx() + player.getWidth() <= it.getx() + 2.1) ||
				    (player.getx() >= it.getx() + it.getWidth() - 2.1 &&
				    player.getx() <= it.getx() + it.getWidth() + 2.1)){

					JukeBox.play("item");
					items.remove(it);
					break;
				}
					
			}
			
		}
		
		
=======
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce
	}
	
	private void render() {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		tileMap.draw(g);
		player.draw(g);
<<<<<<< HEAD

		for(Ennemi en : ennemis){
			en.draw(g);
		}
		


		for(Item it : items){
			it.draw(g);
		}
		
=======
>>>>>>> bfa34e54e0c021e1f3f47e0d18251493031ad6ce
		
	}
	
	private void draw() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
		if(code == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}
		if(code == KeyEvent.VK_UP) {
			player.setJumping(true);
		}
		
	}
	public void keyReleased(KeyEvent key) {
		
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}
		if(code == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}
		
	}
	
}











