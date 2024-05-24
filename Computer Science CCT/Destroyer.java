//Made By Aayush
public class Destroyer extends Ships {
  public final int identity = 4;          // The variable to hold the identity of the ship
  
  //================= CONSTRUCTOR =================//
  //Made By Aayush
  /* Constructor to initialize a Destroyer object
   * @param startRow - the starting row of the destroyer
   * @param startColumn - the starting column of the destroyer
   * @param orientation - the orientation of the destroyer (0 for horizontal, 1 for vertical)
   * @param Power - the power of the destroyer
   * @param size - the size of the destroyer
   * @param lives - the number of lives of the destroyer
   */
  public Destroyer( int Power, int size, int lives) {
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
  /* Power to attack a 2x2 grid around the spot chosen by the player
   * @param row - the row where the attack is centered
   * @param col - the column where the attack is centered
   * @param opponent - the opponent player whose ship grid will be attacked
   * @param currPlayer - the current player who is performing the attack
   */
  public int PowerAttack(int row, int col, Player opponent, Player currPlayer) {
    if (this.GetPower() == -1) {
      return this.No_POWER; 
    }
    else {
      for (int i = row - 1; i <= row + 1; i++) {
        for (int j = col - 1; j <= col + 1; j++) {
          if (i >= 0 && i < opponent.ShipGrid.length && j >= 0 && j < opponent.ShipGrid[0].length) { // Check boundaries
            if (opponent.ShipGrid[i][j] != null) {
              currPlayer.AttackGrid[i][j] = 1;               // Mark hit on current player's attack grid
              opponent.ShipGrid[i][j].SetLives(1);           // Decrease the life of the hit ship
            } 
            else {
              currPlayer.AttackGrid[i][j] = -1;               // Mark miss on current player's attack grid
            }
          }
        }
      }
      this.SetPower(-1);
      return this.SUCCESSFUL;
    }
  }
}
