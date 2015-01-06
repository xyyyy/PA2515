import java.awt.Color;
import java.awt.Graphics2D;


public class Score {
	private int enemiesKilled = 0;
	private int itemsCollected = 0;
	
	public void itemCollected(){
		this.itemsCollected++;
		
	}
	
	public void enemyKileed(){
		this.enemiesKilled++;
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		String tmp = "Enemies killed: " + this.enemiesKilled;
		g.drawString(tmp, 5, 40);
		tmp = "Vodka's collected: " + this.itemsCollected;
		g.drawString(tmp, 5, 80);
	}
	
	
}
