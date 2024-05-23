//Made By Aayush
public class Cruiser extends Ships {
  public final int identity = 3;         // The variable to hold the identity of the ship
  
  //================= CONSTRUCTOR =================//
  //Made By Aayush
  /* Constructor to initialize a Cruiser object
   * @param startRow - the starting row of the cruiser
   * @param startColumn - the starting column of the cruiser
   * @param orientation - the orientation of the cruiser (0 for horizontal, 1 for vertical)
   * @param Power - the power of the cruiser
   * @param size - the size of the cruiser
   * @param lives - the number of lives of the cruiser
   */
  public Cruiser(int startRow, int startColumn, int orientation, int Power, int size, int lives) {
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
  
  //MADE BY AHMED
  /* Attack the grid with power accordingly
   * @param row - the row of the grid
   * @param col - the column of the grid
   * @param opponent - the opponent player whose ship grid will be attacked
   * @param currPlayer - the current player who is performing the attack
   */
  public int PowerAttack(int row, int col, Player opponent, Player currPlayer) {
    return this.No_POWER;
    //No powerAttack for cruiser
  }
}
