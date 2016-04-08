/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


/**
 *
 * @author mark
 */
public class MainPanel extends JPanel{
    
    GameBoard gameBoard = new GameBoard();
 GameLogic gameLogic = new GameLogic(this);
    
    public MainPanel(){
    
        super();
        
        setLayout(null);
        gameBoard.setBounds(0,0,800,800);
        add(gameBoard);
   // gameBoard.setFocusable(true);
    //    repaint();
    } // end constructor

    
    
} // end class
