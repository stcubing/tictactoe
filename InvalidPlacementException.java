package game;

public class InvalidPlacementException extends Exception {
   public InvalidPlacementException() {
      super("invalid placement - somethings already there");
   }
}

