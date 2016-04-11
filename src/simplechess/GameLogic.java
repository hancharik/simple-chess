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
     int counter = 0;  
     int target1X = 0;
     int target1Y = 0;
     int target2X = 0;
     int target2Y = 0;
     int hero1x = 0;
     int hero1y = 0;
     int hero2x = 0;
     int hero2y = 0;
     boolean targetAquired = false;  
       
    public  GameLogic(MainPanel main){
    
        board = main.gameBoard;
        timer = new Timer(1000, this);
        timer.start();
    } // end constructor
    
     public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        String choice = event.getActionCommand();

        if (obj == timer) {
          
            movePiece();
           playerOneToMove = !playerOneToMove;
       //System.out.println(" 161 playerOneToMove = " + playerOneToMove );
        
        counter++;
        }
        }   

     

     

            private void movePiece() {
             
                choosePiece();
   
        
        
      if(playerOneToMove){
        if(pieceByNumber == 1){
          movePawn(tempX,tempY); 
       
        }
        if(pieceByNumber == 3){
        // movePawn(tempX,tempY);
     movePro(tempX,tempY);// //  playerOneToMove = true; 
        }
      }
       if(!playerOneToMove){
         if(pieceByNumber == 2){
        //  movePro(tempX,tempY); 
         movePawn(tempX,tempY);
        }
        if(pieceByNumber == 4){
      // movePawn(tempX,tempY);
      movePro(tempX,tempY);
         //  playerOneToMove = true; 
        }   
      }
      
      
      
        board.refillBricks(); 
         moveCounter++;  
         checkForWinner();
       //board.printOutArrays();
    }  // end move piece

            
            
   private void checkForWinner(){
         simplechess.SimpleChess.scf.m.label.setText("<html><h2><font color='black'>move: </font><font color='black'>" + counter + "</font><h2></html>");
       for(int i = 0; i < board.size; i++){
           
          if(board.pieceLocations[7][i] == 1){
             
              simplechess.SimpleChess.scf.m.label.setText("<html><h2><font color='blue'>blue wins! </font><font color='black'>(" + counter + " moves)</font><h2></html>");
             System.out.println("player one blue wins!");
             timer.stop();
          } 
           
          if(board.pieceLocations[0][i] == 2){
               simplechess.SimpleChess.scf.m.label.setText("<html><h2><font color='red'>red wins! </font><font color='black'>(" + counter + " moves)</font><h2></html>");
                System.out.println("red wins!");
             timer.stop();
          }  
           
           
           
       }
       
       
       
   }         
     
   
   
   

            
            
    private void choosePiece(){
      
                    
    tempX = chance.nextInt(board.size);
     tempY = chance.nextInt(board.size);
      // int pieceByNumber;
        // for(int i = 0; i < board.size; i++ ){
        //    for(int j = 0; j < board.size; j++ ){
              //  pieceByNumber = board.pieceLocations[i][j];
        pieceByNumber = board.pieceLocations[tempX][tempY];
       
       
      if(playerOneToMove && pieceByNumber != 1 ){// if(playerOneToMove && pieceByNumber == 1 || pieceByNumber == 3 || pieceByNumber == 0){// if(playerOneToMove && pieceByNumber == 2 || pieceByNumber == 4 || pieceByNumber == 0){
            choosePiece();   
          }else if(!playerOneToMove && pieceByNumber != 2){//}else if(!playerOneToMove && pieceByNumber == 2 || pieceByNumber == 4 || pieceByNumber == 0){
              choosePiece(); 
         }
      
      
  }
    
    private void movePawn(int x, int y){
       
       if(targetAquired){
           System.out.println("target aquired!");
       }
       
       
       
       int choice = 0;
       
     
        if (playerOneToMove) {

            
            checkForEnemies(1);
            
            
            
            
            if (x < board.size - 3) {
                if (board.pieceLocations[x + 2][y] != 2) {
                    choice = 2;
                }
            }
            if (x < board.size - 1) {
                if (board.pieceLocations[x + 1][y] == 2) {
                    choice = 2;
                }
            }
            if (x > 0) {
                if (board.pieceLocations[x - 1][y] == 2) {
                    choice = 1;
                }
            }
            if (y < board.size - 1) {
                if (board.pieceLocations[x][y + 1] == 2) {
                    choice = 4;
                }
            }

            if (y > 0) {
                if (board.pieceLocations[x][y - 1] == 2) {
                    choice = 3;
                }
            }

        } else {

            checkForEnemies(2);
            
            
            if (x > 1) {
                if (board.pieceLocations[x - 2][y] != 1) {
                    choice = 1;
                }
            }
            if (x > 0) {
                if (board.pieceLocations[x - 1][y] == 1) {
                    choice = 1;
                }
            }
            if (y < board.size - 1) {
                if (board.pieceLocations[x][y + 1] == 1) {
                    choice = 4;
                }
            }
            if (y > 0) {
                if (board.pieceLocations[x][y - 1] == 1) {
                    choice = 3;
                }
            }
            if (x < board.size - 1) {
                if (board.pieceLocations[x + 1][y] == 1) {
                    choice = 2;
                }
            }

        }

        
    
       
       
 
       
        if (choice == 0) {
            //         choice = chance.nextInt(4)+1;
            if (playerOneToMove) {
                choice = 2;
            } else {
                choice = 1;
            }

        }
       
            if (playerOneToMove) {
                 choice = 2;
            }else{
               choice = 1;  
            }
           
           
           
           
           
           
           
       
        // System.out.println("choice" + choice);

       
        switch(choice){
            case 1 : xMultiplier = -1; yMultiplier = 0; break;  // up
            case 2 : xMultiplier = 1; yMultiplier = 0; break;  // down
            case 3 : xMultiplier = 0; yMultiplier = -1; break;  //left
            case 4 : xMultiplier = 0; yMultiplier = 1; break;  //right
            
            
        }
        
        
        // check boundaries
        if(x + xMultiplier < 0 || x + xMultiplier > board.size-1){
           xMultiplier = 0; yMultiplier = 0;// movePawn(x,y);
        }
        
        if(y + yMultiplier < 0 || y + yMultiplier > board.size-1){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
   
        
       // if the piece is on your team, the checking for zero is so that empty spaces arent included in the evens. this lets us scale up to different piece types
       //  if(board.pieceLocations[x][y]%2 == board.pieceLocations[x + xMultiplier][y + yMultiplier]%2 && board.pieceLocations[x + xMultiplier][y + yMultiplier] != 0){
             
       if(board.pieceLocations[x][y] == board.pieceLocations[x + xMultiplier][y + yMultiplier]){
            xMultiplier = 0; yMultiplier = 0;//movePawn(x,y);
        }
        
        
     //   System.out.print(" moving piece [" + x + "][" + y + "] (value = " + board.pieceLocations[x][y] + " )  to [" + (x + xMultiplier) + "][" + (y + yMultiplier) + "]");//(value = " + board.pieceLocations[x + multiplier][y] + ")" ); 
     
        int temp =   board.pieceLocations[x + xMultiplier][y + yMultiplier];// int temp =  board.pieceLocations[x + xMultiplier][y + yMultiplier];
      //  System.out.println(" value = " + temp );
      if( board.pieceLocations[x + xMultiplier][y + yMultiplier] !=  board.pieceLocations[x][y]  ){
        temp = 0;  
      }
       board.pieceLocations[x + xMultiplier][y + yMultiplier] =  board.pieceLocations[x][y]; 
    //   System.out.println(" board.pieceLocations[" + (x + xMultiplier) + "][" + (y + yMultiplier) + "] = " + board.pieceLocations[x + xMultiplier][y + yMultiplier] );
     board.pieceLocations[x][y] = temp; 
    //  System.out.println(" board.pieceLocations[" + x  + "]["+y+"] = " + board.pieceLocations[x][y] );
      // int temp =  board.pieceLocations[x + multiplier][y];
     //   board.pieceLocations[x + multiplier][y] = board.pieceLocations[x][y]; 
    //    board.pieceLocations[x][y] = temp; 
     // board.repaint();
        //board.refillBricks();
        board.printOutArrays();
        //board.repaint();
    } // end move pawn
    
    
    private void checkForEnemies(int player){
        
       if(player==1){
           targetAquired = false;
          for(int i = 0; i < 3; i++ ){
           for(int j = 0; j < board.size; j++ ){
              if( board.pieceLocations[i][j]==2){
                target1X = i;
                target1Y = j;
                targetAquired = true;
                 System.out.println("player two piece in the camp!!!");
                 searchForHero(1);
                return;
              } 
               
         }
        }
       } else{
            targetAquired = false;
            for(int i = board.size-1; i > 4; i-- ){
           for(int j = board.size-1; j > 0; j-- ){
              if( board.pieceLocations[i][j]==1){
                target2X = i;
                target2Y = j;
                targetAquired = true;
                System.out.println("player one piece in the perimeter!!!");
                searchForHero(2);
                return;
              } 
               
         }
        }
       }
        
        
    } // end check for enemies
    
       private void searchForHero(int player){

           if (player == 1) {

               for (int i = -1; i < 2; i++) {
                   for (int j = -1; j < 2; j++) {
                       if (board.pieceLocations[target1X+i][target1Y+j] == 1) {
                           hero1x = target1X + i;
                           hero1y = target1Y + j;
                           System.out.println("player one hero found!!!");
                           return;
                       }

                   }
               }
           } else {
               for (int i = -1; i < 2; i++) {
                   for (int j = -1; j < 2; j++) {
                       if (board.pieceLocations[target2X+i][target2Y+j] == 2) {
                           hero2x = target2X + i;
                           hero2y = target2Y + j;
                           System.out.println("player two hero found!!!");
                           return;
                       }

                   }
               }
           }


       
       
   } // end search for hero
    
    
    
    
      private void movePro(int x, int y){
       
       int choice = chance.nextInt(4)+1;
     //  System.out.println("choice" + choice);
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
        
        
        
     //     System.out.print(" moving piece [" + x + "][" + y + "] (value = " + board.pieceLocations[x][y] + " )  to [" + (x + xMultiplier) + "][" + (y + yMultiplier) + "]");//(value = " + board.pieceLocations[x + multiplier][y] + ")" ); 
     
        int temp =   board.pieceLocations[x + xMultiplier][y + yMultiplier];// int temp =  board.pieceLocations[x + xMultiplier][y + yMultiplier];
       
         if( board.pieceLocations[x + xMultiplier][y + yMultiplier] !=  board.pieceLocations[x][y]  || board.pieceLocations[x + xMultiplier][y + yMultiplier] !=  board.pieceLocations[x][y] + 2){
        temp = 0;  
      }
   //     System.out.println(" value = " + temp );
       board.pieceLocations[x + xMultiplier][y + yMultiplier] =  board.pieceLocations[x][y]; 
   //    System.out.println(" board.pieceLocations[" + (x + xMultiplier) + "][" + (y + yMultiplier) + "] = " + board.pieceLocations[x + xMultiplier][y + yMultiplier] );
     board.pieceLocations[x][y] = temp; 
  //     System.out.println(" board.pieceLocations[" + x  + "]["+y+"] = " + board.pieceLocations[x][y] );
      // int temp =  board.pieceLocations[x + multiplier][y];
     //   board.pieceLocations[x + multiplier][y] = board.pieceLocations[x][y]; 
    //    board.pieceLocations[x][y] = temp; 
        // board.fillBricks();
    } // end move pawn 
      
      
      
      
}  // end class
