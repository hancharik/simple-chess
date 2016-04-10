/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author mark
 */
public class GameLogic implements ActionListener{
    
    Random chance = new Random();
    GameBoard board;
    Timer timer;
    boolean playerOneToMove = true;
    int xMultiplier = 0;
       int yMultiplier = 0;
       int moveCounter = 0;
                     
      int tempX;
      int tempY;
     int pieceByNumber;
       
       
       
    public  GameLogic(MainPanel main){
    
        board = main.gameBoard;
        timer = new Timer(2000, this);
        timer.start();
    } // end constructor
    
     public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        String choice = event.getActionCommand();

        if (obj == timer) {
            movePiece();
        }
        }   

     
     
     
     /*
          
    private void movePiece() {
  
        
           
        
        
        if(playerOneToMove){
           
            boolean findPawn = false;
            
            if(!findPawn){
                for(int i = 0; i < board.size; i++ ){
            for(int j = 0; j < board.size; j++ ){
            if(board.pieceLocations[i][j]==1){
               movePawn(i,j); 
               findPawn = true;
               playerOneToMove = false;
               break;
            }
             }  // end j
             if(findPawn){
                 break;
             }
            }  // end i  
            }
          
            
            /*
            int thisPiece = chance.nextInt(board.playerOnePieces.size());
          System.out.println(" player one moving piece # " + thisPiece + ": "+ board.playerOnePieces.get(thisPiece).getY()/100 + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
          System.out.println(" to " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
          // System.out.println(" getting piece " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
         // Piece temp = board.board[board.playerOnePieces.get(thisPiece).getY()/100+1][board.playerOnePieces.get(thisPiece).getX()/100];
          System.out.println(" moving piece to " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 ); 
          board.board[board.playerOnePieces.get(thisPiece).getY()/100+1][board.playerOnePieces.get(thisPiece).getX()/100] = board.playerOnePieces.get(thisPiece);
           System.out.println(" filling in " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
        board.board[board.playerOnePieces.get(thisPiece).getY()/100][board.playerOnePieces.get(thisPiece).getX()/100] = new Piece();
        
      
        
       
         
          
          
        }else{
            
            
              boolean findPawn = false;
            
            if(!findPawn){
                for(int i = board.size-1; i >= 0; i-- ){
            for(int j = board.size-1; j >= 0; j-- ){
            if(board.pieceLocations[i][j]==3){
               movePawn(i,j);
               findPawn = true;
               playerOneToMove = true;
               break;
            }
             }  // end j
             if(findPawn){
                 break;
             }
            }  // end i  
            }
        
          //  System.out.println(" player two moving piece # " + thisPiece + ": " + board.playerTwoPieces.get(thisPiece).getX() + "," + board.playerTwoPieces.get(thisPiece).getY() ); 
          
        }
        
        board.refillBricks(); 
        board.printOutArrays();
    }  // end move piece
        
        
        
     */
     

            private void movePiece() {
             
                choosePiece();
   
        
        
      if(playerOneToMove){
        if(pieceByNumber == 1){
          movePawn(tempX,tempY); 
       
        }
        if(pieceByNumber == 3){
          movePawn(tempX,tempY);
         //  playerOneToMove = true; 
        }
      }else{
         if(pieceByNumber == 2){
          movePro(tempX,tempY); 
       
        }
        if(pieceByNumber == 4){
          movePro(tempX,tempY);
         //  playerOneToMove = true; 
        }   
      }
       playerOneToMove = !playerOneToMove;
       // board.fillBricks(); 
         moveCounter++;  
       //board.printOutArrays();
    }  // end move piece

    private void choosePiece(){
      
                    
    tempX = chance.nextInt(board.size);
     tempY = chance.nextInt(board.size);
      // int pieceByNumber;
        // for(int i = 0; i < board.size; i++ ){
        //    for(int j = 0; j < board.size; j++ ){
              //  pieceByNumber = board.pieceLocations[i][j];
        pieceByNumber = board.pieceLocations[tempX][tempY];
       
       
        if(playerOneToMove && pieceByNumber == 2 || pieceByNumber == 4 || pieceByNumber == 0){
            choosePiece();   
         }else if(!playerOneToMove && pieceByNumber == 1 || pieceByNumber == 3 || pieceByNumber == 0){
              choosePiece(); 
         }
      
      
  }
    
    private void movePawn(int x, int y){
       
       int choice = chance.nextInt(4)+1;
       System.out.println("choice" + choice);
       
       
       if(playerOneToMove){
          choice = 2; 
       }else{
         choice = 1;  
       }
       
       
        switch(choice){
            case 1 : xMultiplier = -1; yMultiplier = 0; break;  // up
            case 2 : xMultiplier = 1; yMultiplier = 0; break;  // down
            case 3 : xMultiplier = 0; yMultiplier = -1; break;  //left
            case 4 : xMultiplier = 0; yMultiplier = 1; break;  //right
            
            
        }
        
        if(x + xMultiplier < 0 || x + xMultiplier > board.size-1){
           xMultiplier = 0; yMultiplier = 0;// movePawn(x,y);
        }
        
        if(y + yMultiplier < 0 || y + yMultiplier > board.size-1){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
        
         if(board.pieceLocations[x][y]%2 == board.pieceLocations[x + xMultiplier][y + yMultiplier]%2){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
        
        System.out.print(" moving piece [" + x + "][" + y + "] (value = " + board.pieceLocations[x][y] + " )  to [" + (x + xMultiplier) + "][" + (y + yMultiplier) + "]");//(value = " + board.pieceLocations[x + multiplier][y] + ")" ); 
     
        Piece temp =  board.board[x + xMultiplier][y + yMultiplier];// int temp =  board.pieceLocations[x + xMultiplier][y + yMultiplier];
        System.out.println(" value = " + temp );
      board.board[x + xMultiplier][y + yMultiplier] = board.board[x][y]; 
       System.out.println(" board.pieceLocations[" + (x + xMultiplier) + "][" + (y + yMultiplier) + "] = " + board.pieceLocations[x][y] );
    board.board[x][y] = temp; 
       System.out.println(" board.pieceLocations[" + x  + "]["+y+"] = " + temp );
      // int temp =  board.pieceLocations[x + multiplier][y];
     //   board.pieceLocations[x + multiplier][y] = board.pieceLocations[x][y]; 
    //    board.pieceLocations[x][y] = temp; 
      board.repaint();
//board.refillBricks();
    } // end move pawn
    
    
      private void movePro(int x, int y){
       
       int choice = chance.nextInt(4)+1;
       System.out.println("choice" + choice);
        switch(choice){
            case 1 : xMultiplier = -2; yMultiplier = 0; break;  // up
            case 2 : xMultiplier = 2; yMultiplier = 0; break;  // down
            case 3 : xMultiplier = 0; yMultiplier = -2; break;  //left
            case 4 : xMultiplier = 0; yMultiplier = 2; break;  //right
            
            
        }
        
        if(x + xMultiplier < 0 || x + xMultiplier > board.size-1){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
        if(y + yMultiplier < 0 || y + yMultiplier > board.size-1){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
        
        
        System.out.println(" move #"+ moveCounter+" moving piece [" + x + "][" + y + "] (value = " + board.pieceLocations[x][y] + " )  to [" + (x + xMultiplier) + "][" + (y + yMultiplier) + "]");//(value = " + board.pieceLocations[x + multiplier][y] + ")" ); 
     
        int temp =  0;//board.pieceLocations[x + multiplier][y];
        System.out.println(" temp = " + temp );
      board.pieceLocations[x + xMultiplier][y + yMultiplier] = board.pieceLocations[x][y]; 
       System.out.println(" board.pieceLocations[" + (x + xMultiplier) + "][" + (y + yMultiplier) + "] = " + board.pieceLocations[x][y] );
    board.pieceLocations[x][y] = temp; 
       System.out.println(" board.pieceLocations[" + x  + "]["+y+"] = " + temp );
      // int temp =  board.pieceLocations[x + multiplier][y];
     //   board.pieceLocations[x + multiplier][y] = board.pieceLocations[x][y]; 
    //    board.pieceLocations[x][y] = temp; 
        // board.fillBricks();
    } // end move pawn 
      
      
      
      
}  // end class
