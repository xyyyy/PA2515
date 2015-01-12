import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;

public class Item {
	
	private double x;
	private double y;
	private int width;
	private int height;
	private boolean isTouched = false;
	
	private Animation animation;
	private BufferedImage[] sprite;
	private TileMap tileMap;
	
	public Item(Settings settings, TileMap tm) {
		
		this.tileMap = tm;
		
		width = 15;
		height = 30;
		
		try {
			
			sprite = new BufferedImage[1];
			sprite[0] = ImageIO.read(new File("graphics/items/" + settings.getItem()));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		animation = new Animation();
		
	}
	
	public void setx(int i) { x = i; }
	public void sety(int i) { y = i; }
	public double getx() { return x; }
	public double gety() { return y; }
	public double getWidth() { return width; }
	public double getHeight() { return height; }
	public void setTouch(boolean b){ isTouched = b; }

	
	public void update() {
			animation.setFrames(sprite);
			animation.setDelay(-1);
		
	}
	
	public void draw(Graphics2D g) {
		
		int tx = tileMap.getx();
		int ty = tileMap.gety();
	
		if(!isTouched){
		g.drawImage(
				animation.getImage(),
				(int) (tx + x - width / 2),
				(int) (ty + y - height / 2),
				width,
				height,
				null
			);
		}
		
	}
	
}












