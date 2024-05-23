//Made by Aayush
public class BattleshipSystem {
  private final static int MISS = 0;                   // Used in attack method if player has missed the ship
  private final static int SUCCESSFUL = 1;             // If the method is successful 
  private final static int OUT_OF_BOUNDS = -1;         // If the row or column chosen is out of bounds
  private final static int INVALID_BOX = -2;           // If the box is already occupied
  private final static int is_HIT = -3;                // If the position on the grid is already hit
  private final static int IS_PLACED = -4;             // If the ship is already placed
  
  private Player[] allPlayers;                         // Array to hold all players
  private Player currPlayer;                           // The current player
  public Object bs;                                    // Placeholder for battleship object
  private int numRounds;                               // The total number of rounds
  private int currRound;                               // The current round number
  
  //======================== Constructor =========================//
  //Made BY AAYUSH
  public BattleshipSystem(int numRounds) {
    allPlayers = new Player[2];
    allPlayers[0] = new Player(0, 5);
    allPlayers[1] = new Player(1, 5);
    this.numRounds = numRounds;
  }
  
  //========================= Private Method======================//
  
  //========================= PUBLIC METHODS======================//
  //MADE BY AHMHED & AAYUSH
  
  //Made by Aayush
  /* Create a ship based on the given choice
   * @param choice - the type of ship to create
   * @param row - the starting row of the ship
   * @param col - the starting column of the ship
   * @param orientation - the orientation of the ship (0 for horizontal, 1 for vertical)
   * @return - the created ship object
   */
  public Ships CreateShip(int choice, int row, int col, int orientation) {
    if (choice == 1) {
      Ships battleShip = new Battleship(row, col, orientation, 1, 4, 4);
      currPlayer.AddShip(battleShip, Ships.BATTLESHIP - 1);
      return battleShip; //creates a battleship
    } 
    else if (choice == 2) {
      Ships cruiser = new Cruiser(row, col, orientation, 10, 3, 3);
      currPlayer.AddShip(cruiser, Ships.CRUISER - 1);
      return cruiser; //creates a cruiser
    } 
    else if (choice == 3) {
      Ships carrier = new Carrier(row, col, orientation, 0, 5, 5);
      currPlayer.AddShip(carrier, Ships.CARRIER - 1);
      return carrier; //creates a carrier
    } 
    else if (choice == 4) {
      Ships destroyer = new Destroyer(row, col, orientation, 2, 2, 2);
      currPlayer.AddShip(destroyer, Ships.DESTROYER - 1);
      return destroyer; //creates a destroyer
    } 
    else {
      Ships submarine = new Submarine(row, col, orientation, 3, 3, 3);
      currPlayer.AddShip(submarine, Ships.SUBMARINE - 1);
      return submarine; //creates a Submarine
    }
  }
  
  //MADE BY AAYUSH
  /* Insert a ship into the player's grid
   * @param row - the starting row of the ship
   * @param col - the starting column of the ship
   * @param shipType - the type of ship to place
   * @param orientation - the orientation of the ship (0 for horizontal, 1 for vertical)
   * @return - status code indicating the result of the insertion
   */
  public int InsertShip(int row, int col, Ships shipType, int orientation) {
    int size = shipType.GetSize();
    int gridRows = currPlayer.ShipGrid.length;
    int gridCols = currPlayer.ShipGrid[0].length;
    
    // Check if the ship is already placed
    if (shipType.GetIsPlaced()) {
      return IS_PLACED;
    }
    
    // Check if row and col are within bounds
    if (row < 0 || row >= gridRows || col < 0 || col >= gridCols) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    // Check if the initial placement box is full
    if (currPlayer.ShipGrid[row][col] != null) {
      return INVALID_BOX; // Box is full
    }
    
    // Check if ship placement exceeds grid boundaries
    if ((orientation == 0 && col + size > gridCols) || (orientation == 1 && row + size > gridRows)) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    // Check if the entire ship placement area is free
    for (int i = 0; i < size; i++) {
      if (orientation == 0) { // Horizontal placement
        if (currPlayer.ShipGrid[row][col + i] != null) {
          return INVALID_BOX;
        }
      } 
      else { // Vertical placement
        if (currPlayer.ShipGrid[row + i][col] != null) {
          return INVALID_BOX;
        }
      }
    }
    
    // Place the ship based on orientation
    for (int i = 0; i < size; i++) {
      if (orientation == 0) { // Horizontal placement
        currPlayer.ShipGrid[row][col + i] = shipType;
      } 
      else { // Vertical placement
        currPlayer.ShipGrid[row + i][col] = shipType;
      }
    }
    shipType.SetIsPlaced(true);
    return SUCCESSFUL;
  }
  
  //MADE BY AAYUSH
  /* Attack a position on the opponent's grid
   * @param row - the row to attack
   * @param col - the column to attack
   * @return - status code indicating the result of the attack
   */
  public int Attack(int row, int col) {
    if (row > currPlayer.AttackGrid.length || col > currPlayer.AttackGrid[0].length) {
      return OUT_OF_BOUNDS; 
    } 
    else if (currPlayer.AttackGrid[row][col] == 1) {
      return is_HIT; // Already hit
    } 
    else {
      // Check if the attack hits a ship on the opponent's grid
      if (allPlayers[1].ShipGrid[row][col] != null) {
        currPlayer.AttackGrid[row][col] = 1; // Mark hit on player's grid
        allPlayers[1].ShipGrid[row][col].SetLives(1); // Decrease the life of the hit ship
        allPlayers[1].ShipGrid[row][col] = null; // Update opponent's ship grid to null
        return SUCCESSFUL; // Hit
      } 
      else {
        currPlayer.AttackGrid[row][col] = -1; // Mark miss on player's grid
        return MISS; // Miss
      }
    }
  }
  
  //MADE BY AAYUSH
  /* Perform a power attack with the specified ship
   * @param ship - the type of ship to perform the power attack
   */
  public int PerformPowerAttack(int ship) {
    return currPlayer.GetShipType(ship).PowerAttack(0, 0, allPlayers[1], currPlayer); 
  }
  
  //Made by Aayush
  /* Set the current player
   * @param index - the index of the player (0 or 1)
   */
  public void SetCurrPlayer(int index) {
    if (index == 0) {
      this.currPlayer = allPlayers[0];
    } 
    else {
      this.currPlayer = allPlayers[1];
    }
  }  
  
  //Made by Aayush
  /* Get the current player
   * @return - the current player
   */
  public Player GetCurrPlayer() {
    return currPlayer;
  }
  
  //Made by Aayush
  /* Get the name of the current player
   * @return - the name of the current player ("Captain 1" or "Captain 2")
   */
  public String GetCurrPlayerName() {
    if (currPlayer.GetName() == 0) {
      return "Captain 1";
    } 
    else {
      return "Captain 2";
    }
  }
  
  //Made by Aayush
  /* Switch the turn to the next player
   */
  public void SwitchPlayer() {
    if (currPlayer.GetName() == 0) {
      currPlayer = allPlayers[1];
    } 
    else {
      currPlayer = allPlayers[0];
    }
  }
  
  //Made by Aayush
  /* Set the current round number
   * @param newCurrRound - the new current round number
   */
  public void SetCurrRound(int newCurrRound) {
    this.currRound = newCurrRound;
  }
  
  //Made by Aayush
  /* Get the total number of rounds
   * @return - the total number of rounds
   */
  public int GetNumRounds() {
    return numRounds;
  } 
  
  //Made by Aayush
  /* Get the current round number
   * @return - the current round number
   */
  public int GetCurrRound() {
    return this.currRound;
  }
  
  //Made by Aayush
  /* Check if the current round has a winner
   * @return - true if the current player has
   * 
   no remaining lives, false otherwise
   */
  public boolean HasRoundWinner() {
    if (currPlayer.GetLives() == 0) {
      return true;
    } 
    else {
      return false; 
    }
  }
  
  //Made by Aayush
  /* Get the game winner based on the score
   * @return - the index of the winning player (0 or 1)
   */
  public int GetGameWinnner() {
    if (allPlayers[0].GetScore() > allPlayers[1].GetScore()) {
      return 0;
    } 
    else {
      return 1;
    }
  }
}
