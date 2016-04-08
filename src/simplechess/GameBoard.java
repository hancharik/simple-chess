/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class GameBoard extends JPanel{
   
    int size = 8;
    public Piece[][] board;
    ArrayList <Piece> playerOnePieces = new ArrayList();
     ArrayList <Piece> playerTwoPieces = new ArrayList();
      Timer timer; 
     
    public GameBoard(){
        
        super();
        init();
        
    } // end constructor
    
 private void init(){
      
     setLayout(new GridLayout(size,size));
     makeBoard();
        
     repaint();
 }   
  
 private void makeBoard(){
     
     board = new Piece[size][size];
     createPlayerPieces(playerOnePieces, 1);
     createPlayerPieces(playerTwoPieces, 2);
     addPiecesToBoard();
 } // end make board
 
 private void createPlayerPieces(ArrayList pieces, int playerNumber){
     
     for(int i = 0; i < size; i++ ){
        Piece p = new Pawn(playerNumber);
        pieces.add(p);
     }
     
       for(int i = 0; i < size; i++ ){
        Piece p = new Pro(playerNumber);
        pieces.add(p);
     }
       
 } // end add pieces
 
  private void addPiecesToBoard(){
     
     for(int i = 0; i < size; i++ ){
         
           board[0][i] = playerOnePieces.get(i + size);
       //    playerOnePieces.get(i + size).setX(0);
      //     playerOnePieces.get(i + size).setY(i);
        board[1][i] = playerOnePieces.get(i);
    //   playerOnePieces.get(i).setX(1);
    //    playerOnePieces.get(i).setY(i);
     }
     
       for(int i = 0; i < size; i++ ){
          board[6][i] = playerTwoPieces.get(i);
        //   playerTwoPieces.get(i).setX(6);
      //  playerTwoPieces.get(i).setY(i);
         board[7][i] = playerTwoPieces.get(i + size);
        // playerTwoPieces.get(i + size).setX(7);
        //   playerTwoPieces.get(i + size).setY(i);
     }
       
       for(int i = 2; i < 6; i++ ){
        for(int j = 0; j < size; j++ ){
          board[i][j] = new Piece();
       
      }
     }  
    board[0][0] = new Piece();  
    board[5][5] = playerOnePieces.get(0);  
 fillBricks(); 
       printOutArrays();
 } // end add pieces
 
  public void fillBricks(){
      
           for(int i = 0; i < size; i++ ){
         for(int j = 0; j < size; j++ ){
            Piece p = new Piece();//board[i][j];
             p = board[i][j];
           // // p.setX(i);
           //  p.setY(j);
           
          this.add(p);
          //  p.setText(p.getY()/100 +"," + p.getX()/100);
       // p.repaint();
     }
     }  
      
  }
  public void printOutArrays(){
      
      for(int i = 0; i < playerTwoPieces.size(); i++){
        System.out.println("array # " + i + ":" + playerTwoPieces.get(i).x +","+ playerTwoPieces.get(i).y);  
      }
      
        for(int i = 0; i < size; i++ ){
         for(int j = 0; j < size; j++ ){
             board[i][j].setText(i +"," + j);
      
     }
     }  
        
        
  } // end print out arrays

 
  
} // end class
