package simplegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 805598
 */
public class Simple extends JPanel {

    private Chungus jeff;
    private Shrek dude;
    private Alien[] aliens;
    private ArrayList<Carrot> carrots;
    private ArrayList<Stone> stones;
    private Timer timer;
    private boolean gameover;
    private long lastTime;
        
    public Simple() {
        super();
        jeff = new Chungus(1000 / 2, 1060 - 400);
        dude = new Shrek(1000 / 2, 550 - 400);
        aliens = new Alien[20];
        carrots = new ArrayList<>();
        stones = new ArrayList<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100/60);
        lastTime = System.currentTimeMillis();
        spawnAliens();
    }
    
    private void spawnAliens() {
        for(int i = 0; i <20; i++){
        aliens[i] = new Alien(25 + i * 50, 50);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long dT = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g.setColor(Color.red);
        this.setBackground(Color.BLACK); 
        dude.draw(g);
        jeff.draw(g);
        
        for (Alien alien : aliens) {
            alien.draw(g);
        }
        for (Carrot carrot : carrots) {
            if (carrot != null) {
                carrot.draw(g);
            }
        }
        for (Stone stone : stones) {
            if (stone != null) {
                stone.draw(g);
            }
        }
        if(gameover == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.white);
            g.drawString("Game over", 325, 400); 
}

    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            jeff.update();
            dude.update();
            for (Carrot carrot : carrots) {
                    carrot.update();
            }
            for (Stone stone : stones) {
                  stone.update();   
            
            }
            
            for (Alien alien : aliens) {
                if(alien == null) {
                    continue;
                }
                wallCollisions(alien);
                alien.update();
            if (alien.getY() >= 1000)
                    gameover = true;
                for (Carrot carrot : carrots) {
                    collisionDetection(alien, carrot);
                }                      
            }
           
                    wallCollisions(dude);
                    dude.update();
                if (dude.getY() >= 10000) {
                    gameover = true;
                    
                    
                }
                for (Carrot carrot : carrots) {
                    collisionDetection(dude, carrot);
                }
                for (Stone stone : stones) {
                    collisionDetection(jeff, stone);
                    
                } 
                wallCollisions(jeff);
                   
                    
                collisionDetection2(dude, jeff);
            repaint();
        }
    }
    //remake above code for stone and shrek
    private void collisionDetection(Character obj1, Character obj2) {
        if (obj1.getBound().intersects(obj2.getBound())) {
            obj1.die();
            obj2.die();
        }
    }
     private void collisionDetection2(Character obj1, Character obj2) {
        if (obj1.getBound().intersects(obj2.getBound())) {
            obj1.die();
            
        }
    }
    private void wallCollisions(Character c) {
       
        if (c.getX() <= 0 || c.getX() + 30 >= this.getWidth()){
            c.setDx(-c.getDx());
        }
    }

    
    public void keyPressed(KeyEvent e) {
        final int SPEED = 1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jeff.setDx(SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jeff.setDx(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            jeff.setDy(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jeff.setDy(SPEED);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            dude.setDx(SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            dude.setDx(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            dude.setDy(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            dude.setDy(SPEED);
        
        }
        }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            jeff.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            jeff.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_UP)
            jeff.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            jeff.setDy(0);
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            carrots.add( new Carrot(jeff.getX(), jeff.getY()) );
            //missiles[0] = new Missile(jeff.getX(), jeff.getY());
    if (e.getKeyCode() == KeyEvent.VK_D)
            dude.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_A)
            dude.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_W)
            dude.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_S)
            dude.setDy(0);
        if (e.getKeyCode() == KeyEvent.VK_F)
            stones.add( new Stone(dude.getX(), dude.getY()) );
    }   
    
    
    
    
    }  


  
        
   
    
    
    
