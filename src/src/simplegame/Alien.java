/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
/**
 *
 * @author jword
 */
public class Alien extends Character {
    //Fields
    private ImageIcon ii;
    private Image img;
    
    //Constructor
    public Alien(int x, int y) {
        super(x, y, "/images/ree.png");
        super.setDy(0);
        super.setDx(1);
    }    
}