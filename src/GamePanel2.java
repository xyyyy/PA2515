import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel2 extends JPanel implements Runnable, KeyListener {
	
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
	
	private ArrayList<Ennemi> ennemis;
	private ArrayList<Item> items;
	
	private Menu menu;
	public GamePanel2(Menu menu) {
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
		

		JukeBox.init();
		JukeBox.load("level1.wav", "level1");
		JukeBox.load("getitem.wav", "item");
		JukeBox.load("killennemi.wav", "killennemi");
		JukeBox.load("badtouch.wav", "badtouch");
		JukeBox.setVolume("level1", -40f);
		JukeBox.play("badtouch");
		
		tileMap = new TileMap("Map_2.txt", 32);
		tileMap.loadTiles("graphics/tileset.gif");
		
		player = new Player(tileMap, 2);
		player.setx(50);
		player.sety(50);
		
		ennemis = new ArrayList<Ennemi>();
		items = new ArrayList<Item>();
		
		
		// ADD ENNEMIES
		for(int j = 0 ; j < 11 ; j++){
			ennemis.add(new Ennemi(tileMap));
		}
		ennemis.get(0).setx(100);
		ennemis.get(0).sety(500);
		ennemis.get(1).setx(250);
		ennemis.get(1).sety(500);
		ennemis.get(2).setx(300);
		ennemis.get(2).sety(500);
		ennemis.get(3).setx(625);
		ennemis.get(3).sety(100);
		ennemis.get(4).setx(725);
		ennemis.get(4).sety(500);
		ennemis.get(5).setx(1000);
		ennemis.get(5).sety(500);
		ennemis.get(6).setx(1200);
		ennemis.get(6).sety(500);
		ennemis.get(7).setx(1700);
		ennemis.get(7).sety(500);
		ennemis.get(8).setx(1750);
		ennemis.get(8).sety(100);
		ennemis.get(9).setx(1750);
		ennemis.get(9).sety(500); 
		ennemis.get(10).setx(750);
		ennemis.get(10).sety(200); 
		
		// ADD ITEMS
		for(int j = 0 ; j < 6 ; j++){
			items.add(new Item("vodka", tileMap));
		}
		items.get(0).setx(180);
		items.get(0).sety(250);
		items.get(1).setx(370);
		items.get(1).sety(130);
		items.get(2).setx(960);
		items.get(2).sety(80);
		items.get(3).setx(750);
		items.get(3).sety(180);
		items.get(4).setx(1700);
		items.get(4).sety(255);
		items.get(5).setx(1655);
		items.get(5).sety(50);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	private void update() {
		
		tileMap.update();
		player.update();
		

		//                          COLLISION WITH THE ENNEMIES
		
		for(Ennemi en : ennemis){
			en.update();
		
			
			// PLAYER IS ON LEFT
			if (player.getx() < en.getx() + en.getWidth() &&
				player.getx() + player.getWidth() <= en.getx() && 
				player.gety() < en.gety() + en.getHeight() &&
				player.gety() + player.getHeight() > en.gety()){
				
				en.setPosition(1);
			}
			
			//PLAYER IS ON TOP
			if (player.getx() < en.getx() + en.getWidth() &&
				player.getx() + player.getWidth() > en.getx() && 
				player.gety() < en.gety() + en.getHeight() &&
				player.gety() + player.getHeight() <= en.gety()){
				
				en.setPosition(2);
			}
			
			//PLAYER IS ON RIGHT
			if (player.getx() >= en.getx() + en.getWidth() &&
				player.getx() + player.getWidth() > en.getx() && 
				player.gety() < en.gety() + en.getHeight() &&
				player.gety() + player.getHeight() > en.gety()){
				
				en.setPosition(3);
			}
			
			
			// COLLISION  
			if (player.getx() < en.getx() + en.getWidth() &&
				player.getx() + player.getWidth() > en.getx() && 
				player.gety() < en.gety() + en.getHeight() &&
				player.gety() + player.getHeight() > en.gety()){
					
					
					if (en.getPosition() == 1){
						System.out.println("gauche");
					}
					
					if (en.getPosition() == 3){
						System.out.println("droite");
					}
					
					if(en.getPosition()  == 2){
						player.setFalling(false);
						player.setJumping(true);
						JukeBox.play("killennemi");
						ennemis.remove(en);
						break;
					}
						
				}
						
			
			
		}
		
		
		//                          COLLISION WITH THE ITEMS
		
		for(Item it : items){
			it.update();
		
			if (player.getx() < it.getx() + it.getWidth() &&
				player.getx() + player.getWidth() > it.getx() &&
				player.gety() < it.gety() + it.getHeight() &&
				player.gety() + player.getHeight() > it.gety()
				){
				

					JukeBox.play("item");
					items.remove(it);
					break;
			}
		}
			
		
	}
	
	private void render() {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		tileMap.draw(g);
		player.draw(g);

		for(Ennemi en : ennemis){
			en.draw(g);
		}
		


		for(Item it : items){
			it.draw(g);
		}
		
		
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












