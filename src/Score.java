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
	private Settings settings;
	
	
	public Score(Settings settings){
		this.settings = settings;
		try {
			item = ImageIO.read(new File("graphics/items/" + this.settings.getItem()));
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
				15,
				30,
				null
			);
		
		
		g.setColor(Color.GREEN);
		String tmp = "Enemies killed: " + this.enemiesKilled;
		g.drawString(tmp, 5, 40);
		tmp = ": " + this.itemsCollected;
		g.drawString(tmp, 20, 80);
	}
	
	
}
