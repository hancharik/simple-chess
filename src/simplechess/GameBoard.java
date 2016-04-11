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
    int playerOnePieceNumber = 0;
    int playerTwoPieceNumber  = 0;
    public Piece[][] board;
    public int[][] pieceLocations;
    ArrayList <Piece> playerOnePieces = new ArrayList();
     ArrayList <Piece> playerTwoPieces = new ArrayList();
      
     
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
     pieceLocations = new int[size][size];
     createPlayerPieces(playerOnePieces, 1);
     createPlayerPieces(playerTwoPieces, 2);
     addPiecesToBoard();
    // System.out.println("playerOnePieceNumber = " + playerOnePieceNumber + ", playerTwoPieceNumber = " + playerTwoPieceNumber + "!!");
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
           pieceLocations[0][i] = 1;//3;
           playerOnePieceNumber++;
       //    playerOnePieces.get(i + size).setX(0);
      //     playerOnePieces.get(i + size).setY(i);
        board[1][i] = playerOnePieces.get(i);
           pieceLocations[1][i] = 1;
           playerOnePieceNumber++;
    //   playerOnePieces.get(i).setX(1);
    //    playerOnePieces.get(i).setY(i);
     }
     
       for(int i = 0; i < size; i++ ){
          board[6][i] = playerTwoPieces.get(i);
          pieceLocations[6][i] = 2;
          playerTwoPieceNumber++;
        //   playerTwoPieces.get(i).setX(6);
      //  playerTwoPieces.get(i).setY(i);
         board[7][i] = playerTwoPieces.get(i + size);
          pieceLocations[7][i] = 2;//4;
        playerTwoPieceNumber++;// playerTwoPieces.get(i + size).setX(7);
        //   playerTwoPieces.get(i + size).setY(i);
     }
       
       for(int i = 2; i < 6; i++ ){
        for(int j = 0; j < size; j++ ){
          board[i][j] = new Piece();
          pieceLocations[i][j] = 0;
       
      }
     }  
       // THESE WORK!!!!
   // board[0][0] = new Piece();  
   // board[5][5] = new Pawn(1);//playerOnePieces.get(0);  
   //   board[4][4] = new Pawn(2);//playerOnePieces.get(0);  
     //  board[0][2] = new Piece();
 fillBricks(); 
       //printOutArrays();
 } // end add pieces
 
  public void fillBricks(){
        
            Piece p;
        
           for(int i = 0; i < size; i++ ){
            for(int j = 0; j < size; j++ ){
             
          
             
                switch(pieceLocations[i][j]){
                    case 1 :  p = new Pawn(1); break;
                    case 2 : p = new Pawn(2); break;
                    case 3 :  p = new Pro(1); break;
                    case 4 :  p = new Pro(2); break;
                    default :  p = new Piece();  // leaving out case 0 because same as default
                }
             
             
                board[i][j] = p;
                this.add(board[i][j]);
    
             } // end j
            }  // end i
      
  }
  
    public void refillBricks(){
        
               Piece p;
        
           for(int i = 0; i < size; i++ ){
            for(int j = 0; j < size; j++ ){
             
          this.remove(board[i][j]);
             
                switch(pieceLocations[i][j]){
                    case 1 :  p = new Pawn(1); break;
                    case 2 : p = new Pawn(2); break;
                    case 3 :  p = new Pro(1); break;
                    case 4 :  p = new Pro(2); break;
                    default :  p = new Piece();  // leaving out case 0 because same as default
                }
             
             
                board[i][j] = p;
                this.add(board[i][j]);
    
             } // end j
            }  // end i
  }
  public void printOutArrays(){
  
      
        for(int i = 0; i < size; i++ ){
         for(int j = 0; j < size; j++ ){
              
            board[i][j].setText(i +"," + j);//board[i][j].setText(""+pieceLocations[i][j]);
      // System.out.println("board[" + i + "][" + j +"] is a "+ pieceLocations[i][j]);  
     }
     }  
        
        
  } // end print out arrays

 
  
} // end class
