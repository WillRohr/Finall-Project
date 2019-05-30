/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 805598
 */
public class Character {
    //Fields
    private int size;
    private Color color;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private ImageIcon ii;
    private Image img;
    private Rectangle bound;
    
    //Constructor
    public Character() {
        size = 10;
        color = Color.RED;
        x = 200;
        y = 200;
        dx = 3;
        dy = 3;
    }
    
    public Character(int x, int y, String imgSrc) {
        size = 100;
        color = Color.RED;
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
        ii = new ImageIcon(getClass().getResource(imgSrc));
        img = ii.getImage();
        bound = new Rectangle(this.x, this.y, this.size, this.size);
    }

   

    public Rectangle getBound() {
        return bound;
    }
    
    //Methods
    public void draw(Graphics g) {
        g.drawImage(img, x, y, size, size, null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(bound);
    }
    
    public void update() {
        x += dx;
        y += dy;
        bound = new Rectangle(this.x, this.y, this.size, this.size);
    }
    
    public void moveTo() {
        
    }
    
    public void shoot() {
        
    }
    
    public void die() {
        x = -500;
        y = -500;
    }
    
    public void kill() {
        
    }
    
    public void respawn() {
        
    }
    
    //Getters and Setters

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
}