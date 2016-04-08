/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author mark
 */
public class Piece extends JButton {

    Color colorValue = new Color(154, 160, 166);//Color.WHITE;
    int offset = 56;  // sets the pawns to a less intense shade. pro is full 255 in r,g,b value
    public int x = 0;
    public int y = 0;

    public Piece() {

        super();
        setBackground(colorValue);

    }

    
    
    boolean validMove(){
        
        return true;
    }
    
  
    
      
    
      
      
}
