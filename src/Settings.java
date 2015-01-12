import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
    
    private int map = 4; //"Map_2.txt";
    
    private String tileSet = "tileset.gif";
    
    private TileMap tileMap; 
    
    private String item = "vodka.png";
    
    private int time = 90;//set Time in seconds
    
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
    
    public Settings(Menu start) {
        initComponents();
        this.start = start;
        this.tileMap = new TileMap("map" + this.map + ".txt", 32);
		this.tileMap.loadTiles("graphics/" + this.tileSet);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jSlider4 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("Return To Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nerd");

        jLabel2.setText("Party Animal");

        jLabel4.setText("Map1 ");

        jLabel5.setText("Settings");

        jLabel6.setText("Map 2");

        jLabel7.setText("Easy");

        jLabel8.setText("Hard");

        jLabel9.setText("Volume");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.start.goToMenu();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    // End of variables declaration//GEN-END:variables
}
