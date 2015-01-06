import java.awt.Color;
import java.awt.Graphics2D;


public class Lifes {
	
	private int amount = 3;
	
	public boolean kill(){
		if(--amount <= 0){
			return true;
		}
		return false;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		int amountTmp = this.amount;
		int max = 3;
		int x = 5;
		int y = 5;
		int size = 20;
	
		while(max-- > 0){
			if(amountTmp-- <= 0){
				g.setColor(Color.RED);
			}
			g.fillRect(x, y, size, size);
			x+= size + 5;
			
		}
	
	}
	
	
}
