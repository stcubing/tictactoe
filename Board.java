package game;

import java.util.ArrayList;
import java.util.Random;


public class Board {

   private String[][] board;

   public Board() {
      board = new String[3][3];

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
               board[i][j] = " ";
         }
      }
   }


   public void playerPlace(int row, int col) throws InvalidPlacementException, InvalidLocationException {
      place("X", row, col);
   }

   public void compPlace(int[] coords) throws InvalidPlacementException, InvalidLocationException {
      place("O", coords[0], coords[1]);
   }
   public int[] computer() {
      ArrayList<int[]> availableSpaces = new ArrayList<int[]>();
   
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (board[i][j] == " ") {
               // add free spaces to a list
   
               int[] freePair = {i,j};
               availableSpaces.add(freePair);
            }
         }
      }
   
   
      // random index from dictionary
      Random random = new Random();
      int[] randomPair = availableSpaces.get(random.nextInt(availableSpaces.size()));

      return randomPair;
      
   }

   public void place(String player, int row, int col) throws InvalidPlacementException, InvalidLocationException {
      if (row > 2 || col > 2) {
         throw new InvalidLocationException();
      } else if (board[row][col] != " ") {
         throw new InvalidPlacementException();
      } else {
         board[row][col] = player;
      }
   }


   public boolean fullBoard() {
      int counter = 0;

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if (board[i][j] != " ") {
               counter += 1;
            }
         }
      }
      if (counter == 9) return true; else return false;
   }


   public boolean win(String player) {
      
      // horizontal
      for (int i = 0; i < 3; i++) {
         if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == player) {
            return true;
         }
      }
      // vertical
      for (int i = 0; i < 3; i++) {
         if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == player) {
            return true;
         }
      }
      // diag
      if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == player) {
         return true;
      }
      if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] == player) {
         return true;
      }

      return false;
   }


   @Override
   public String toString() {

      String flatBoard = "";

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            flatBoard += board[i][j];
            if (j != 2) {
               flatBoard += "|";
            }
         }
         
         flatBoard += "\n";
         if (i != 2) {
            flatBoard += "-+-+-\n";
         }
      }

      return flatBoard;
   }
}
