/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.Color;

/**
 *
 * @author mark
 */
public class Pro extends Piece{
    
    
    public Pro(int player){
        
        super();
        
        /*
         if(player == 1){
          colorValue = new Color(255,255,255);  
        }else{
          colorValue = new Color(0,0,0);   
        }
        */
          if(player == 1){
          colorValue = new Color(0,0,255);  
        }else{
          colorValue = new Color(255,0,0);   
        }
        
        this.setText("pro");
         setBackground(colorValue);
    }
    
  
      
}
