//Made By Aayush
public class Submarine extends Ships { 
  public final int identity = 5;          // The variable to hold the identity of the ship
  
  //================= CONSTRUCTOR =================//
  //Made By Aayush
  /* Constructor to initialize a Submarine object
   * @param startRow - the starting row of the submarine
   * @param startColumn - the starting column of the submarine
   * @param orientation - the orientation of the submarine (0 for horizontal, 1 for vertical)
   * @param Power - the power of the submarine
   * @param size - the size of the submarine
   * @param lives - the number of lives of the submarine
   */
  public Submarine( int Power, int size, int lives) {
    super( Power, size, lives);
  }
  
  //================ PUBLIC METHODS ===============//
  //Made By Aayush
  /* Get the identity of the ship
   * @return - the int identity of the ship which is based on a private variable in the subclass
   */
  public int GetIdentity() {
    return identity;
  }
  
  //Made By Aayush
  /* Submarine will attack an entire column
   * @param row - the row from which the attack starts
   * @param col - the column which the attack will be placed on
   * @param opponent - the opponent player whose ship grid will be attacked
   * @param currPlayer - the current player who is performing the attack
   */
  public int PowerAttack(int row, int col, Player opponent, Player currPlayer) {
    if (this.GetPower() == -1) {
      return this.No_POWER; //Already used Power cannot use again
    }
    else {
      for (int i = 0; i < 10; i++) {
        if (opponent.ShipGrid[row][i] != null) {
          currPlayer.AttackGrid[row][i] = 1;               // Mark hit on current player's attack grid
          opponent.ShipGrid[row][i].SetLives(1);           // Decrease the life of the hit ship
        } else {
          currPlayer.AttackGrid[row][i] = -1;               // Mark miss on current player's attack grid
        }
      }
      this.SetPower(-1);
      return this.SUCCESSFUL;
    }
  }
}