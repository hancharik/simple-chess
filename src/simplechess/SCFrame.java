/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author mark
 */
public class SCFrame extends JFrame{
    
    MainPanel m = new MainPanel();
    
    public SCFrame(){
         getContentPane().setLayout(new BorderLayout());
             
      this.setSize(1000,1000);//this.setSize(640, 960);
       // this.setSize(1920,1080);
       getContentPane().add(m,"Center");
        this.setLocationRelativeTo(null);
        this.setTitle("Simple Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
