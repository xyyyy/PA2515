import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.ButtonGroup;

/**
 *
 * @author M
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Settings
     */
        private final Menu start;
    
    private int characterSkin = 4;//1-4 dependnds on gender and behaviour
    
    private int volume = 50; //0-100
    
    private int map = 1; 
    
    private String tileSet = "tileset.gif";
    
   private TileMap tileMap; 
    
    private String item = "vodka.png";
    
    private int time = 90;//set Time in seconds
    public Settings(Menu start) {
        initComponents();
        groupButtons();
        this.start = start;
        this.map1.doClick();
        this.mapChanged();
        
    }
    private void mapChanged(){
    	this.tileMap = new TileMap("map" + this.map + ".txt", 32); 
		this.tileMap.loadTiles("graphics/" + this.tileSet); 
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

        map1.setText("Map 1");
        map1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map1ActionPerformed(evt);
            }
        });

        map2.setText("Map2");
        map2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map2ActionPerformed(evt);
            }
        });

        map3.setText("Map3");
        map3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map3ActionPerformed(evt);
            }
        });

        map4.setText("Map4");
        map4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                map4ActionPerformed(evt);
            }
        });

        nerd.setText("Nerd");
        nerd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nerdActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Volume");

        boy.setText("Boy");
        boy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boyActionPerformed(evt);
            }
        });

        girl.setText("Girl");
        girl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girlActionPerformed(evt);
            }
        });
        

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Gender");

        jLabel3.setText("Character");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(map1)
                                .addGap(18, 18, 18)
                                .addComponent(map2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(girl)
                                    .addComponent(nerd))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(map3)
                                .addGap(18, 18, 18)
                                .addComponent(map4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boy)
                                    .addComponent(partyAnimal))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nerd)
                    .addComponent(partyAnimal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(girl)
                    .addComponent(boy))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(map1)
                    .addComponent(map2)
                    .addComponent(map3)
                    .addComponent(map4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1))
                    .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

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
        if(this.characterSkin == 1 || this.characterSkin == 3){//if boy
            this.characterSkin = 3;
        }
        else{//if girl
            this.characterSkin = 4;
        }
    }                                           

    private void nerdActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(this.characterSkin == 1 || this.characterSkin == 3){//if boy
            this.characterSkin = 1;
        }
        else{//if girl
            this.characterSkin = 2;
        }
    }                                    

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                          
        // TODO add your handling code here:
        int value =this.volumeSlider.getValue();
        
    }                                         

    private void girlActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(this.characterSkin == 1 || this.characterSkin == 2){//if nerd
            this.characterSkin = 2;
        }
        else{//if party animal
            this.characterSkin = 4;
        }
    }                                    

    private void boyActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.characterSkin == 1 || this.characterSkin == 2){//if nerd
            this.characterSkin = 1;
        }
        else{//if party animal
            this.characterSkin = 3;
        }
    }        
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        this.start.goToMenu();
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
    }
    private javax.swing.ButtonGroup bgMode;
    private javax.swing.ButtonGroup bgMap;
    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton boy;
    private javax.swing.JRadioButton girl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton map1;
    private javax.swing.JRadioButton map2;
    private javax.swing.JRadioButton map3;
    private javax.swing.JRadioButton map4;
    private javax.swing.JRadioButton nerd;
    private javax.swing.JRadioButton partyAnimal;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration                   
}
