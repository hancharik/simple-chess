/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author mark
 */
public class MainPanel extends JPanel{
    
    GameBoard gameBoard = new GameBoard();
 GameLogic gameLogic = new GameLogic(this);
 JLabel label = new JLabel("playing tournament...");   
    public MainPanel(){
    
        super();
        
        setLayout(null);
        gameBoard.setBounds(0,0,800,800);
        label.setBounds(340,840,260,40);
        add(gameBoard);
        add(label);
   // gameBoard.setFocusable(true);
    //    repaint();
    } // end constructor

    
    
} // end class
