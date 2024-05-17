//Made By Aayush
import java.util.Random;

public class Carrier extends Ships {
  private final int Power ;
  private final int size;
  public final int identity = 1; 
  private int lives;
  
  //================= CONSTRUCTOR =================//
  public Carrier(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
    super(startRow, startColumn, orientation, isSunk, isPlace);
    this.Power = 0;
    this.size =5;
    this.lives = 5;
  }
  //================ PUBLIC METHODS ===============//
  
  /* Get the Power of the Ship
   * @return - the power (int value)
   */
  public int GetPower() {
    return Power;
  }
  
  /* Gets the size of the ship 
   * @return - the int size of ship which is based on private variable in subclass
   */
  public int GetSize() {
    return size;
  }
  
  /* Get the identity of the ship
     * @return - the int identity of the ship which is based on private variable in subclass
     */
  public int GetIdentity() {
    return identity;
  }
  
  /* Set the number of lives of the ship as it decreases by one 
   @param live - the lives of the ship */
   public void SetLives(int live) {
     this.lives -= live;
   }
   
   /* Gets the lives of the ship
    * @return - the number of remaining lives that the ship has  
    */
   public int GetLives() {
     return lives;
   }
   
   //MADE BY AAYUSH
   //Carrier has power of guaranteed attack on a ship, using recursive method
   public void PowerAttack(int row, int col, Player opponent, Player currPlayer) {
     // Generate random row and column indices
     Random rand = new Random();
     row = rand.nextInt(10); // Assuming a 10x10 grid
     col = rand.nextInt(10);
     // Check if there's a ship at the randomly chosen location
     Ships ship = opponent.ShipGrid[row][col];
     if (ship != null) {
       // Ship exists at this location, mark it as hit
       opponent.ShipGrid[row][col] = null; // Mark it as hit (assuming 2 represents a hit)
       currPlayer.AttackGrid[row][col] = 1;
       opponent.ShipGrid[row][col].SetLives(1);
     } 
     else {
       // No ship at this location, try again
       PowerAttack(row, col, opponent, currPlayer); // Recursive call to try again
     }
   }


}