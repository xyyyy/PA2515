import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */















import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author M
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Settings
     */
        private final Menu start;
    	public static final int WIDTH = 700;
    	public static final int HEIGHT = 500;
    private int characterSkin = 4;//1-4 dependnds on gender and behaviour
    
    private int volume = 50; //0-100
    
    private int map = 1; 
    
    private String tileSet = "tileset.gif";
    
   private TileMap tileMap; 
    
    private String item = "book.png";
    
    private int time = 900;//set Time in seconds
    
    private BufferedImage backgroundImage;
    private BufferedImage logoImage;
    private ArrayList<BufferedImage> characterImages;
    private ArrayList<BufferedImage> headImages;

    
    public Settings(Menu start) {
        initComponents();
        groupButtons();
        
        this.start = start;
        this.map1.doClick();
        this.girl.doClick();
        this.nerd.doClick();
        this.easy.doClick();
        this.mapChanged();
        this.characterImages = new ArrayList<BufferedImage>();
        this.headImages = new ArrayList<BufferedImage>();
        this.setSize(WIDTH, HEIGHT + 300);
        this.loadPictures();
       
        this.result.enable();
        repaint();
    }
    public void setMessage(String m){
    	this.result.setText(m);
    }
    private void loadPictures(){
    	 


         try {                
            this.backgroundImage = ImageIO.read(new File("graphics/menu_back.png"));
            this.logoImage = ImageIO.read(new File("graphics/logo.png"));//graphics/logo.png"));
            for(int i = 1; i < 5; i++){
            	this.characterImages.add(ImageIO.read(new File("graphics/characters/ch0"+  i+".png")));
            }
            for(int i = 1; i < 5; i++){
            	this.headImages.add(ImageIO.read(new File("graphics/characters/ch0"+  i+"-headicon.png")));
            }
         } catch (IOException ex) {
         }
    }
    
    private void mapChanged(){
    	this.tileMap = new TileMap("map" + this.map + ".txt", 32); 
		this.tileMap.loadTiles("graphics/" + this.tileSet); 
		if(this.easy.isSelected()){
			this.easy.doClick();
		}else if(this.medium.isSelected()){
			this.medium.doClick();
		}else if(this.hard.isSelected()){
			this.hard.doClick();
		}
    }
    
    
    public String getBack(){
    	if(this.characterSkin < 3){
    		return "back2.jpg";
    	}
    	return "back.jpg";
    }
    
    public int getTime(){
    	return this.time;
    }
    
   
 
	public String getItem(){
    	return this.item;
    }
  //  private Player player = new Nerd();
    
    
    
    public TileMap getTileMap(){
    	
		return this.tileMap;
		
    	
    }
    public Player getPlayer(){
    	Player player = new Player(tileMap, this.characterSkin);
		player.setx(50);
		player.sety(50);
    	return player;
    }
    
    

    public ArrayList getItems(){
    	
		ArrayList<Item> items = new ArrayList<Item>();
		// ADD ITEMS
		
		switch(this.map){
			case 1:	for(int j = 0 ; j < 6 ; j++){
						items.add(new Item(this, tileMap));
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
					break;
			case 2: for(int j = 0 ; j < 4 ; j++){
						items.add(new Item(this, tileMap));
					}
					items.get(0).setx(80);
					items.get(0).sety(80);
					items.get(1).setx(210);
					items.get(1).sety(170);
					items.get(2).setx(300);
					items.get(2).sety(330);
					items.get(3).setx(500);
					items.get(3).sety(150);
					break;
			case 3: for(int j = 0 ; j < 7 ; j++){
						items.add(new Item(this, tileMap));
					}
					items.get(0).setx(335);
					items.get(0).sety(400);
					items.get(1).setx(780);
					items.get(1).sety(220);
					items.get(2).setx(900);
					items.get(2).sety(130);
					items.get(3).setx(1170);
					items.get(3).sety(210);
					items.get(4).setx(1290);
					items.get(4).sety(210);
					items.get(5).setx(1710);
					items.get(5).sety(50);
					items.get(6).setx(1870);
					items.get(6).sety(80);
					break;
			case 4: // ADD ITEMS
					for(int j = 0 ; j < 4 ; j++){
						items.add(new Item(this, tileMap));
					}
					items.get(0).setx(190);
					items.get(0).sety(140);
					items.get(1).setx(460);
					items.get(1).sety(100);
					items.get(2).setx(1230);
					items.get(2).sety(350);
					items.get(3).setx(1640);
					items.get(3).sety(170);
					break;
		}
		return items;
    }
    
    public ArrayList getEnemies(){
    	
    	ArrayList<Ennemi> ennemis = new ArrayList<Ennemi>();
		
		// ADD ENNEMIES
    	switch(this.map){
    		case 1:	for(int j = 0 ; j < 11 ; j++){
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
    			
    				break;
    		case 2: for(int j = 0 ; j < 10 ; j++){
						ennemis.add(new Ennemi(tileMap));
					}
					ennemis.get(0).setx(50);
					ennemis.get(0).sety(50);
					ennemis.get(1).setx(200);
					ennemis.get(1).sety(50);
					ennemis.get(2).setx(300);
					ennemis.get(2).sety(50);
					ennemis.get(3).setx(250);
					ennemis.get(3).sety(50);
					ennemis.get(4).setx(500);
					ennemis.get(4).sety(50);
					ennemis.get(5).setx(300);
					ennemis.get(5).sety(80);
					ennemis.get(6).setx(120);
					ennemis.get(6).sety(150);
					ennemis.get(7).setx(600);
					ennemis.get(7).sety(50);
					ennemis.get(8).setx(300);
					ennemis.get(8).sety(300);
					ennemis.get(9).setx(900);
					ennemis.get(9).sety(50);
					break;
	    		case 3: for(int j = 0 ; j < 25 ; j++){
		    			ennemis.add(new Ennemi(tileMap));
		    		}
		    		ennemis.get(0).setx(200);
		    		ennemis.get(0).sety(500);
		    		ennemis.get(1).setx(250);
		    		ennemis.get(1).sety(500);
		    		ennemis.get(2).setx(300);
		    		ennemis.get(2).sety(500);
		    		ennemis.get(3).setx(350);
		    		ennemis.get(3).sety(500);
		    		ennemis.get(4).setx(400);
		    		ennemis.get(4).sety(500);
		    		ennemis.get(5).setx(450);
		    		ennemis.get(5).sety(500);
		    		ennemis.get(6).setx(500);
		    		ennemis.get(6).sety(500);
		    		ennemis.get(7).setx(600);
		    		ennemis.get(7).sety(500);
		    		ennemis.get(8).setx(600);
		    		ennemis.get(8).sety(500);
		    		ennemis.get(9).setx(650);
		    		ennemis.get(9).sety(500);
		    		ennemis.get(10).setx(700);
		    		ennemis.get(10).sety(500);
		    		ennemis.get(11).setx(750);
		    		ennemis.get(11).sety(500);
		    		ennemis.get(12).setx(800);
		    		ennemis.get(12).sety(500);
		    		ennemis.get(13).setx(950); // Enemie before "above "BTH""
		    		ennemis.get(13).sety(350); 
		    		ennemis.get(14).setx(1000);// Enemies above "BTH"
		    		ennemis.get(14).sety(220);
		    		ennemis.get(15).setx(1070); 
		    		ennemis.get(15).sety(250);
		    		ennemis.get(16).setx(1150); 
		    		ennemis.get(16).sety(250);
		    		ennemis.get(17).setx(1200);
		    		ennemis.get(17).sety(250);
		    		ennemis.get(18).setx(1220);
		    		ennemis.get(18).sety(250);
		    		ennemis.get(19).setx(1280);
		    		ennemis.get(19).sety(250);
		    		ennemis.get(20).setx(1670); //Enemies furthest away  to the right. 
		    		ennemis.get(20).sety(500);
		    		ennemis.get(21).setx(1700);
		    		ennemis.get(21).sety(500);
		    		ennemis.get(22).setx(1720);
		    		ennemis.get(22).sety(500);
		    		ennemis.get(23).setx(1770);
		    		ennemis.get(23).sety(500);
		    		ennemis.get(24).setx(1800);
		    		ennemis.get(24).sety(500);
		    		break;
	    		case 4:
	    			for(int j = 0 ; j < 25 ; j++){
	    				ennemis.add(new Ennemi(tileMap));
	    			}
	    			ennemis.get(0).setx(200);
	    			ennemis.get(0).sety(500);
	    			ennemis.get(1).setx(250);
	    			ennemis.get(1).sety(500);
	    			ennemis.get(2).setx(300);
	    			ennemis.get(2).sety(500);
	    			ennemis.get(3).setx(350);
	    			ennemis.get(3).sety(500);
	    			ennemis.get(4).setx(400);
	    			ennemis.get(4).sety(500);
	    			ennemis.get(5).setx(450);
	    			ennemis.get(5).sety(500);
	    			ennemis.get(6).setx(500);
	    			ennemis.get(6).sety(500);
	    			ennemis.get(7).setx(550);
	    			ennemis.get(7).sety(500);
	    			ennemis.get(8).setx(600);
	    			ennemis.get(8).sety(500);
	    			ennemis.get(9).setx(650);
	    			ennemis.get(9).sety(500);
	    			ennemis.get(10).setx(700);
	    			ennemis.get(10).sety(500);
	    			ennemis.get(11).setx(750);
	    			ennemis.get(11).sety(500);
	    			ennemis.get(12).setx(800);
	    			ennemis.get(12).sety(500);
	    			ennemis.get(13).setx(850);
	    			ennemis.get(13).sety(500);
	    			ennemis.get(14).setx(900);
	    			ennemis.get(14).sety(500);
	    			ennemis.get(15).setx(950);
	    			ennemis.get(15).sety(500);
	    			ennemis.get(16).setx(1000);
	    			ennemis.get(16).sety(500);
	    			ennemis.get(17).setx(1400);
	    			ennemis.get(17).sety(500);
	    			ennemis.get(18).setx(1450);
	    			ennemis.get(18).sety(500);
	    			ennemis.get(19).setx(1500);
	    			ennemis.get(19).sety(500);
	    			ennemis.get(20).setx(1550);
	    			ennemis.get(20).sety(500);
	    			ennemis.get(21).setx(1600);
	    			ennemis.get(21).sety(500);
	    			ennemis.get(22).setx(1650);
	    			ennemis.get(22).sety(500);
	    			ennemis.get(23).setx(1700);
	    			ennemis.get(23).sety(500);
	    			ennemis.get(24).setx(1750);
	    			ennemis.get(24).sety(500);
	    			break;
    	}
		return ennemis;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        map1 = new javax.swing.JRadioButton();
        map2 = new javax.swing.JRadioButton();
        map3 = new javax.swing.JRadioButton();
        map4 = new javax.swing.JRadioButton();
        nerd = new javax.swing.JRadioButton();
        partyAnimal = new javax.swing.JRadioButton();
        volumeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        boy = new javax.swing.JRadioButton();
        girl = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        easy = new javax.swing.JRadioButton();
        medium = new javax.swing.JRadioButton();
        hard = new javax.swing.JRadioButton();
        result = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 500));

        map1.setForeground(new java.awt.Color(255, 255, 255));
        map1.setText("Map 1");
        map1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map1ActionPerformed(evt);
            }
        });

        map2.setForeground(new java.awt.Color(255, 255, 255));
        map2.setText("Map2");
        map2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map2ActionPerformed(evt);
            }
        });

        map3.setForeground(new java.awt.Color(255, 255, 255));
        map3.setText("Map3");
        map3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map3ActionPerformed(evt);
            }
        });

        map4.setBackground(new java.awt.Color(255, 255, 255));
        map4.setForeground(new java.awt.Color(255, 255, 255));
        map4.setText("Map4");
        map4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map4ActionPerformed(evt);
            }
        });

        nerd.setForeground(new java.awt.Color(255, 255, 255));
        nerd.setText("Nerd");
        nerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nerdActionPerformed(evt);
            }
        });

        partyAnimal.setForeground(new java.awt.Color(255, 255, 255));
        partyAnimal.setText("Party Animal");
        partyAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partyAnimalActionPerformed(evt);
            }
        });

        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeSliderStateChanged(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Volume");

        result.setForeground(new java.awt.Color(255, 255, 255));
        
        boy.setForeground(new java.awt.Color(255, 255, 255));
        boy.setText("Boy");
        boy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boyActionPerformed(evt);
            }
        });

        girl.setForeground(new java.awt.Color(255, 255, 255));
        girl.setText("Girl");
        girl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girlActionPerformed(evt);
            }
        });

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gender");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Character");

        easy.setForeground(new java.awt.Color(255, 255, 255));
        easy.setText("Easy");
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });

        medium.setForeground(new java.awt.Color(255, 255, 255));
        medium.setText("Medium");
        medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumActionPerformed(evt);
            }
        });

        hard.setForeground(new java.awt.Color(255, 255, 255));
        hard.setText("Hard");
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(easy))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medium)
                                    .addComponent(girl))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boy)
                                    .addComponent(hard))
                                .addGap(40, 485, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nerd)
                                .addGap(22, 22, 22)
                                .addComponent(partyAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(result)
                                .addGap(76, 76, 76))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(map1)
                            .addComponent(map3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(map4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(map2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nerd)
                    .addComponent(partyAnimal)
                    .addComponent(result))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(girl)
                    .addComponent(boy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easy)
                    .addComponent(medium)
                    .addComponent(hard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(map1)
                    .addComponent(map2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(map3)
                    .addComponent(map4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))))
        );
    }// </editor-fold>                                              

    private void changeTextColours(){
    	
    }
    
    private void map2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.map = 2;
        
        this.mapChanged();
    }                                    

    private void map1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.map = 1;
        this.mapChanged();
    }                                    

    private void map3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.map = 3;
        this.mapChanged();
    }                                    

    private void map4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.map = 4;
        this.mapChanged();
    }                                    

    private void partyAnimalActionPerformed(java.awt.event.ActionEvent evt) {
    	JukeBox.play("badtouch");
    	JukeBox.stop("level1");
        if(this.characterSkin == 1 || this.characterSkin == 3){//if boy
            this.characterSkin = 3;
        }
        else{//if girl
            this.characterSkin = 4;
        }
        this.item = "bottle.png";
        repaint();
    }                                           

    private void nerdActionPerformed(java.awt.event.ActionEvent evt) {   
    	JukeBox.play("level1");
    	JukeBox.stop("badtouch");
        if(this.characterSkin == 1 || this.characterSkin == 3){//if boy
            this.characterSkin = 1;
        }
        else{//if girl
            this.characterSkin = 2;
        }
        this.item = "book.png";
        repaint();
    }                                    

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                          
        // TODO add your handling code here:
        float volume =this.volumeSlider.getValue();
        volume = volume*4/5 - 80;
       
    	JukeBox.setVolume("level1", volume);
		JukeBox.setVolume("item", volume);
		JukeBox.setVolume("killennemi", volume);
		JukeBox.setVolume("badtouch", volume);
        
        
        
    }                                         

    private void girlActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(this.characterSkin == 1 || this.characterSkin == 2){//if nerd
            this.characterSkin = 2;
        }
        else{//if party animal
            this.characterSkin = 4;
        }
        repaint();
    }                                    

    private void boyActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.characterSkin == 1 || this.characterSkin == 2){//if nerd
            this.characterSkin = 1;
        }
        else{//if party animal
            this.characterSkin = 3;
        }
        repaint();
    }        
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        this.start.goToGame();
    }  
    private void easyActionPerformed(java.awt.event.ActionEvent evt) {                                     
        switch(this.map){
        	case 1: this.time = 120;
        			break;
        	case 2: this.time = 120;
					break;
        	case 3: this.time = 140;
					break;
        	case 4: this.time = 130;
					break;
        }
    }                                    

    private void mediumActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	switch(this.map){
	    	case 1: this.time = 90;
	    			break;
	    	case 2: this.time = 90;
					break;
	    	case 3: this.time = 100;
					break;
	    	case 4: this.time = 105;
					break;
	    }
    }                                      

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {                                     
    	switch(this.map){
	    	case 1: this.time = 65;
	    			break;
	    	case 2: this.time = 65;
					break;
	    	case 3: this.time = 75;
					break;
	    	case 4: this.time = 60;
					break;
	    }
    }   
    

    private  void groupButtons(){
        bgMap = new ButtonGroup();
        bgMap.add(map1);
        bgMap.add(map2);
        bgMap.add(map3);
        bgMap.add(map4);
        bgMode = new ButtonGroup();
        bgMode.add(nerd);
        bgMode.add(partyAnimal);
        bgGender = new ButtonGroup();
        bgGender.add(boy);
        bgGender.add(girl);
        bgDifficulty = new ButtonGroup();
        bgDifficulty.add(easy);
        bgDifficulty.add(medium);
        bgDifficulty.add(hard);
    }
    
   
    


    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0,WIDTH, HEIGHT, null); // see javadoc for more info on the parameters
        g.drawImage(this.logoImage, WIDTH/2 - 577/6, 30,577/3, 132/3, null);
        g.drawImage(this.characterImages.get(this.characterSkin - 1), WIDTH/2 - 70, 110, 130, HEIGHT - 150, null);
        g.drawImage(this.headImages.get(0), 130, 10, 20, 18, null);
        g.drawImage(this.headImages.get(1), 100, 10, 20, 17, null);
        g.drawImage(this.headImages.get(2), 220, 10, 20, 17, null);
        g.drawImage(this.headImages.get(3), 190, 5, 20, 26, null);
    }
    
    private ButtonGroup bgDifficulty;
    private ButtonGroup bgGender;
    private javax.swing.ButtonGroup bgMode;
    private javax.swing.ButtonGroup bgMap;
    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton boy;
    private javax.swing.JRadioButton girl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel result;
    private javax.swing.JRadioButton map1;
    private javax.swing.JRadioButton map2;
    private javax.swing.JRadioButton map3;
    private javax.swing.JRadioButton map4;
    private javax.swing.JRadioButton nerd;
    private javax.swing.JRadioButton partyAnimal;
    private javax.swing.JSlider volumeSlider;
    private javax.swing.JRadioButton easy;
    private javax.swing.JRadioButton medium;
    private javax.swing.JRadioButton hard;
    // End of variables declaration                   
}
