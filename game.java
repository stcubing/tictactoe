package game;
import java.util.*;

public class game {

   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);

      Board gameBoard = new Board();
      enum State {
         WIN,
         LOSE,
         TIE,
         RUNNING
      }
      State gameState = State.RUNNING;

      int counter = 0;

      System.out.println("welcome to tic tac toe. you are X");

      while (gameState == State.RUNNING) {

         System.out.println(gameBoard);
         

         if (counter % 2 == 0) {
            // player's move
            int row = -1;
            int col = -1;

            while ((row < 0 || row > 2) || (col < 0 || col > 2)) {
               System.out.println("what row do u wanna place in");
               row = Integer.parseInt(scanner.nextLine());            
               System.out.println("what column do u wanna place in");
               col = Integer.parseInt(scanner.nextLine());
            }

            try {
               gameBoard.playerPlace(row,col);
            } catch (InvalidPlacementException e) {
               System.err.println(e);
            } catch (InvalidLocationException e) {
               System.err.println(e);
            }

         } else {
            // computer's move
            int[] compCoords = gameBoard.computer();
            System.out.println("computer places at " + compCoords[1] + "," + compCoords[0]);
            
            try {
               gameBoard.compPlace(compCoords);
            } catch (InvalidPlacementException e) {
               System.err.println(e);
            } catch (InvalidLocationException e) {
               System.err.println(e);
            }
         }

         if (gameBoard.win("X")) {
            System.out.println(gameBoard);
            System.out.println("you have won");
            gameState = State.WIN;
         } else if (gameBoard.win("O")) {
            System.out.println(gameBoard);
            System.out.println("the computer has won");
            gameState = State.LOSE;
         } else if (gameBoard.fullBoard()) {
            System.out.println(gameBoard);
            System.out.println("u guys tied");
            gameState = State.TIE;
         }
         
         counter++;

      }
      scanner.close();
   
   }
}
