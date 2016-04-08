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
        }
        }   

    private void movePiece() {
        if(playerOneToMove){
            int thisPiece = chance.nextInt(board.playerOnePieces.size());
          System.out.println(" player one moving piece # " + thisPiece + ": "+ board.playerOnePieces.get(thisPiece).getY()/100 + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
          System.out.println(" to " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
          // System.out.println(" getting piece " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
         // Piece temp = board.board[board.playerOnePieces.get(thisPiece).getY()/100+1][board.playerOnePieces.get(thisPiece).getX()/100];
          System.out.println(" moving piece to " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 ); 
          board.board[board.playerOnePieces.get(thisPiece).getY()/100+1][board.playerOnePieces.get(thisPiece).getX()/100] = board.playerOnePieces.get(thisPiece);
           System.out.println(" filling in " + thisPiece + ": "+ (board.playerOnePieces.get(thisPiece).getY()/100+1) + "," + board.playerOnePieces.get(thisPiece).getX()/100 );
        board.board[board.playerOnePieces.get(thisPiece).getY()/100][board.playerOnePieces.get(thisPiece).getX()/100] = new Piece();
         board.fillBricks();
         board.repaint();
          
          playerOneToMove = false;
        }else{
            int thisPiece = chance.nextInt(board.playerTwoPieces.size());
          System.out.println(" player two moving piece # " + thisPiece + ": " + board.playerTwoPieces.get(thisPiece).getX() + "," + board.playerTwoPieces.get(thisPiece).getY() ); 
          playerOneToMove = true;
        }
    }
    
    
}  // end class
