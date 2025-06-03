package game;

public class InvalidLocationException extends Exception {
   public InvalidLocationException() {
      super("invalid location - out of bounds");
   }
}

