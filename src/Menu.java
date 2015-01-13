/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

/**
 *
 * @author M
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
    
   // private final MainMenu menu = new MainMenu(this);

    
    private final Settings settings;
 
    private  GamePanel game = null;

    public GamePanel getGame() {
        return game;
    }
    
    public Settings getSettings(){
    	return this.settings;
    }
    
    public Menu() {
       
        initComponents();
       URL url =  ClassLoader.getSystemResource("graphics/icon.jpg");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);
        setSize(WIDTH, HEIGHT);
        float volume = -40;
        JukeBox.init();
		JukeBox.load("level1.wav", "level1");
		JukeBox.load("getitem.wav", "item");
		JukeBox.load("killennemi.wav", "killennemi");
		JukeBox.load("badtouch.wav", "badtouch");
		JukeBox.setVolume("level1", volume);
		JukeBox.setVolume("item", volume);
		JukeBox.setVolume("killennemi", volume);
		JukeBox.setVolume("badtouch", volume);
		settings = new Settings(this);
		
        this.goToMenu();
    }
    
    public boolean ifGameStarted(){
        if(game == null){
            return false;
        }
        return true;
    } 
    
   
    
 
    
    
    
    public void goToGame(){
    	GamePanel gp = new GamePanel(this);
    	//gp.addNotify();
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(gp);
		this.pack();
		this.revalidate();
		this.setState(Frame.ICONIFIED);
		this.setState(Frame.NORMAL);
		this.setVisible(true);

		
        /*if(this.game == null){
            game = new GamePanel();
        }
        this.changePanel(game);*/
    }
    
    public void goToMenu(){
        this.goToSettings();
        }
    public void goToMenu(String m){
    	this.settings.setMessage(m);
        this.goToSettings();
        }


    public void goToSettings(){
        this.changePanel(settings);
    }
    
    
    
  
    private void changePanel(JPanel panel){
        this.setContentPane(panel);
        this.invalidate();
        this.validate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
