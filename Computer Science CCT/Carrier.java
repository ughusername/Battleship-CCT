// Made By Aayush
import java.util.Random;

public class Carrier extends Ships {
  public final int identity = 1; // The variable to hold the identity of the ship
  
  //================= CONSTRUCTOR =================//
  public Carrier(int startRow, int startColumn, int orientation, int Power, int size, int lives) {
    super(startRow, startColumn, orientation, Power, size, lives);
  }
  
  //================ PUBLIC METHODS ===============//
  
  /* Get the identity of the ship
   * @return - the int identity of the ship which is based on private variable in subclass
   */
  public int GetIdentity() {
    return identity;
  }
  
  // MADE BY AAYUSH
  // Carrier has power of guaranteed attack on a ship, using recursive method
  public void PowerAttack(int row, int col, Player opponent, Player currPlayer) {
    // Generate random row and column indices
    Random rand = new Random();
    row = rand.nextInt(10); // Assuming a 10x10 grid
    col = rand.nextInt(10);
    
    // Check if there's a ship at the randomly chosen location
    Ships ship = opponent.ShipGrid[row][col];
    if (ship != null) {
      // Ship exists at this location, mark it as hit
      currPlayer.AttackGrid[row][col] = 1;
      ship.SetLives(ship.GetLives() - 1);
    } else {
      // No ship at this location, try again
      PowerAttack(row, col, opponent, currPlayer); // Recursive call to try again
    }
  }
}
