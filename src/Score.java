import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Score {
	private int enemiesKilled = 0;
	private int itemsCollected = 0;
	private BufferedImage item;
	private BufferedImage enemy;
	private Settings settings;
	private GamePanel gamePanel;
	
	public int getEnemiesKilled(){
		return this.enemiesKilled;
		
	}
	public Score(GamePanel gp, Settings settings){
		this.settings = settings;
		this.gamePanel = gp;
		try {
			item = ImageIO.read(new File("graphics/items/" + this.settings.getItem()));
			enemy = ImageIO.read(new File("graphics/player/kirbyjump.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//graphics/items/
	public void itemCollected(){
		this.itemsCollected++;
		
	}
	
	public void enemyKileed(){
		this.enemiesKilled++;
		
	}
	
	public void draw(Graphics2D g) {
		
		
		g.drawImage(
				item,
				5,
				60 ,
				20,
				30,
				null
			);
		
		g.drawImage(
				enemy,
				5,
				30 ,
				20,
				20,
				null
			);
		g.setColor(Color.GREEN);
		String tmp = " " + this.enemiesKilled;
		g.drawString(tmp, 25, 50);
		tmp = "  remaining: " + this.gamePanel.getAmountOfItemLeft();
		g.drawString(tmp, 20, 80);
	}
	
	
}
