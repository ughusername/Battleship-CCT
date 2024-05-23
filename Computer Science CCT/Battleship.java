public class Battleship extends Ships {
  public final int identity = 2;  // The variable to hold the identity of the ship
  
  //================= CONSTRUCTOR =================//
  //Made By Aayush
  /* Constructor to initialize a Battleship object
   * @param startRow - the starting row of the battleship
   * @param startColumn - the starting column of the battleship
   * @param orientation - the orientation of the battleship (0 for horizontal, 1 for vertical)
   * @param Power - the power of the battleship
   * @param size - the size of the battleship
   * @param lives - the number of lives of the battleship
   */
  public Battleship(int startRow, int startColumn, int orientation, int Power, int size, int lives) {
    super(startRow, startColumn, orientation, Power, size, lives);
  }
  
  //================ PUBLIC METHODS ===============//
  //Made By Aayush
  /* Get the identity of the ship
   * @return - the int identity of the ship which is based on a private variable in the subclass
   */
  public int GetIdentity() {
    return identity;
  }
       
  //MADE BY AAYUSH
  /* Battleship will attack an entire column
   * @param row - the row from which the attack starts
   * @param col - the column which the attack will be placed on
   * @param opponent - the opponent player whose ship grid will be attacked
   * @param currPlayer - the current player who is performing the attack
   */
  public void PowerAttack(int row, int col, Player opponent, Player currPlayer) {
    for (int i = 0; i < 10; i++) {
      if (opponent.ShipGrid[i][col] != null) {
        currPlayer.AttackGrid[i][col] = 1;               // Mark hit on current player's attack grid
        opponent.ShipGrid[i][col].SetLives(1);           // Decrease the life of the hit ship
      } else {
        currPlayer.AttackGrid[i][col] = 0;               // Mark miss on current player's attack grid
      }
    }
  }
}
