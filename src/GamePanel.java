import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
	private Image background;
	
	private ArrayList<Ennemi> ennemis;
	private ArrayList<Item> items;
	
	private Menu menu;
	
	private Lifes lifes;
	
	private Score score;
	
	private Settings settings;
	private long startTime; 
	private long remainingTime;
	public GamePanel(Menu menu) {
		super();
		this.menu = menu;
		this.settings = this.menu.getSettings();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		menu.setState(Frame.ICONIFIED);
		menu.setState(Frame.NORMAL);
		this.startTime  = new Date().getTime()/1000;
		this.remainingTime = this.settings.getTime();
		//Thread t = new Thread(new Time(this.settings, this.menu, this.thread));
		//t.start();
		
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
			//check time
			
			this.remainingTime = this.settings.getTime()+ this.startTime - new Date().getTime()/1000;
		
			if(this.remainingTime<=0){
				menu.goToMenu("You run out of time!");
			
			}
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
	
	public int getAmountOfItemLeft(){
		return this.items.size();
	}
	
	private void init() {
		
		running = true;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		try{
			background = ImageIO.read(new File("graphics/" + this.settings.getBack()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		g = (Graphics2D) image.getGraphics();
		

		
		tileMap = this.settings.getTileMap();
		player = this.settings.getPlayer();
		
		
		
		lifes = new Lifes();
		
		score = new Score(this, this.settings);
		
		ennemis = this.settings.getEnemies();
		items = this.settings.getItems();
		
		
		
		
		
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
					
					
					if (en.getPosition() == 1 || en.getPosition() == 3){
						this.ennemis.remove(en);
						if(this.lifes.kill()){
							this.menu.goToMenu("You were hit 3 times");
						}
						JukeBox.play("hit");
					
						break;
					}
					else if(en.getPosition()  == 2){
						player.setFalling(false);
						player.setJumping(true);
						JukeBox.play("killennemi");
						score.enemyKileed();
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
				
					score.itemCollected();
					JukeBox.play("item");
					items.remove(it);
					break;
			}
		}
		if(items.size() == 0){
			this.menu.goToMenu("You won and killed " + this.score.getEnemiesKilled()+ " enemies");
		}
			
		
	}
	
	private void render() {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
		
		tileMap.draw(g);
		player.draw(g);
		lifes.draw(g);
		score.draw(g);
		for(Ennemi en : ennemis){
			en.draw(g);
		}
		


		for(Item it : items){
			it.draw(g);
		}
		g.setColor(Color.GREEN);
		String tmp ="";
		if(this.remainingTime/60 <10){
			tmp += "0";
		}
		tmp += String.valueOf(this.remainingTime/60) + ":";
		if(this.remainingTime%60 < 10){
			tmp += "0";
		}
		tmp += String.valueOf(this.remainingTime%60);
		g.drawString(tmp, 100, 20);
		
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












