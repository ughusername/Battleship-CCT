public abstract class Ships {
  public static final int CARRIER = 1;      // Carrier identity
  public static final int BATTLESHIP = 2;   // Battleship identity
  public static final int CRUISER = 3;      // Cruiser identity
  public static final int DESTROYER = 4;    // Destroyer identity
  public static final int SUBMARINE = 5;    // Submarine identity
  private int startRow;                     // The variable for the starting row of the ship
  private int startColumn;                  // The variable for the starting column of the ship
  private int orientation;                  // The orientation of the ship, whether the ship is horizontal or vertical
  private int shipType;                     // The variable that holds the ship type of the ship
  private int numofShips = 5;               // The variable that holds the number of ships
  private boolean IsPlaced;                 // Variable to store if the ship is placed or not
  private boolean IsSunk;                   // Variable to store if the ship is sunk or not
  private int Power;                        // The power of the ship
  private int size;                         // The size of the ship
  private int lives;                        // The lives of the ship
  
  //==================== CONSTRUCTORS ====================//
  public Ships() {
    // Default constructor
  }
  
  public Ships(int startRow, int startColumn, int orientation, int Power, int size, int lives) {
    this.startColumn = startColumn;
    this.startRow = startRow;
    this.orientation = orientation;
    this.Power = Power;
    this.size = size;
    this.lives = lives;
    this.IsPlaced = false;
    this.IsSunk = false;
  }
  
  //=================== PUBLIC METHODS ===================//
  /* Get the name of the ship type
   * @param shipType - the type of the ship
   * @return - the name of the ship type
   */
  public String GetShipName(int shipType) {
    switch (shipType) {
      case CARRIER:
        return "Carrier";
      case BATTLESHIP:
        return "Battleship";
      case CRUISER:
        return "Cruiser";
      case DESTROYER:
        return "Destroyer";
      case SUBMARINE:
        return "Submarine";
      default:
        return "Unknown";
    }
  }
  
  /* Get the remaining number of ships
   * @return - the number of remaining ships
   */
  public int GetRemaningShips() {
    return numofShips;
  }
  
  /* Set the start row of the ship
   * @param StartRow - the starting row of the ship
   */
  public void SetStartRow(int StartRow) {
    this.startRow = StartRow;
  }
  
  /* Get the start row of the ship
   * @return - the starting row of the ship
   */
  public int GetStartRow() {
    return startRow;
  }
  
  /* Set the start column of the ship
   * @param startColumn - the starting column of the ship
   */
  public void SetStartColumn(int startColumn) {
    this.startColumn = startColumn;
  }
  
  /* Get the start column of the ship
   * @return - the starting column of the ship
   */
  public int GetStartColumn() {
    return startColumn;
  }
  
  /* Set the orientation of the ship
   * @param orientation - 0 is horizontal, 1 is vertical
   */
  public void SetOrientation(int orientation) {
    this.orientation = orientation;
  }
  
  /* Get the orientation of the ship
   * @return - the orientation of the ship
   */
  public int GetOrientation() {
    return orientation;
  }
  
  /* Get the power of the ship
   * @return - the power of the ship
   */
  public int GetPower() {
    return Power;
  }
  
  /* Get the size of the ship
   * @return - the size of the ship
   */
  public int GetSize() {
    return size;
  }
  
  /* Set the number of lives of the ship as it decreases by one
   * @param live - the lives of the ship
   */
  public void SetLives(int live) {
    this.lives -= live;
  }
  
  /* Get the number of remaining lives of the ship
   * @return - the number of remaining lives of the ship
   */
  public int GetLives() {
    return lives;
  }
  
  /* Set if the ship is placed or not
   * @param isPlaced - if the ship is placed or not
   */
  public void SetIsPlaced(boolean isPlaced) {
    this.IsPlaced = isPlaced;
  }
  
  /* Get if the ship is placed or not
   * @return - if the ship is placed or not
   */
  public boolean GetIsPlaced() {
    return IsPlaced;
  }
  
  /* Set if the ship is sunk or not
   * @param IsSunk - if the ship is sunk or not
   */
  public void SetIsSunk(boolean IsSunk) {
    this.IsSunk = IsSunk;
  }
  
  /* Get if the ship is sunk or not
   * @return - if the ship is sunk or not
   */
  public boolean GetIsSunk() {
    return IsSunk;
  }
  
  //MADE BY AAYUSH
  /* Perform a special attack with the ship
   * @param row - the row where the attack will be placed
   * @param col - the column where the attack will be placed
   * @param opponent - the opponent player who stores the ship grids
   * @param currPlayer - the current player who stores the attack grid
   */
  public abstract void PowerAttack(int row, int col, Player opponent, Player curPlayer);
  
  //Made by Aayush
  /* Get the identity of the ship
   * @return - the identity of the ship
   */
  public abstract int GetIdentity();
}
