/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegame;

/**
 *
 * @author 805598
 */
public class Stone extends Character {
    
    
public Stone(int x, int y) {
        super(x, y, "/images/infinitystone.png");
        super.setDy(1);
    }
}
