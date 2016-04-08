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
public class Pawn extends Piece{
    
    
    public Pawn(int player){
        
        super();
       
        
        /*   
        if(player == 1){
          colorValue = new Color(255 - super.offset,255 - super.offset,255 - super.offset);  
        }else{
          colorValue = new Color(0 + super.offset,0 + super.offset,0 + super.offset);   
        }
        */
        
        
        
        if(player == 1){
          colorValue = new Color(140,160,255);  
        }else{
          colorValue = new Color(255,130,130);   
        }
        
        
        
        setBackground(colorValue);
        
    }
    

    
}
