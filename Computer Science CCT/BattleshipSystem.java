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
  public void CreateShips() {
    Ships battleShip = new Battleship( 1, 4, 4);
    currPlayer.AddShip(battleShip, Ships.BATTLESHIP - 1);//creates a battleship and adds to the players array
    
    Ships cruiser = new Cruiser( 10, 3, 3);
    currPlayer.AddShip(cruiser, Ships.CRUISER - 1); //creates a cruiser and adds to the players array
    
    Ships carrier = new Carrier( 0, 5, 5);
    currPlayer.AddShip(carrier, Ships.CARRIER - 1); //creates a carrier and adds to the players array
    
    
    Ships destroyer = new Destroyer( 2, 2, 2);
    currPlayer.AddShip(destroyer, Ships.DESTROYER - 1);//creates a destroyer and adds to the players array
    
    Ships submarine = new Submarine( 3, 3, 3);
    currPlayer.AddShip(submarine, Ships.SUBMARINE - 1); //creates a Submarine and adds to the players array
  }
  
  //MADE BY AAYUSH
  /* Insert a ship into the player's grid
   * @param row - the starting row of the ship
   * @param col - the starting column of the ship
   * @param shipType - the type of ship to place
   * @param orientation - the orientation of the ship (0 for horizontal, 1 for vertical)
   * @return - status code indicating the result of the insertion
   */
  public int InsertShip(int row, int col, int shipType, int orientation) {
    Ships ship = currPlayer.GetShipType(shipType-1);
    int size = ship.GetSize();
    int gridRows = currPlayer.ShipGrid.length;
    int gridCols = currPlayer.ShipGrid[0].length;
    
    // Check if the ship is already placed
    if (ship.GetIsPlaced()) {
      return IS_PLACED;
    }
    
    // Check if row and col are within bounds
    else if (row < 0 || row >= gridRows || col < 0 || col >= gridCols) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    // Check if the initial placement box is full and all the boxes it occupies if full
    else if (currPlayer.ShipGrid[row][col] != null) {
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
      return INVALID_BOX;
    }
    
    // Check if ship placement exceeds grid boundaries
    else if ((orientation == 0 && col + size > gridCols) || (orientation == 1 && row + size > gridRows)) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    else {
      // Place the ship based on orientation
      for (int i = 0; i < size; i++) {
        if (orientation == 0) { // Horizontal placement
          currPlayer.ShipGrid[row][col + i] = ship;
        } 
        else { // Vertical placement
          currPlayer.ShipGrid[row + i][col] = ship;
        }
      }
      ship.SetIsPlaced(true);
      return SUCCESSFUL;
    }
  }
  
  
  //MADE BY AAYUSH
  /* Attack a position on the opponent's grid
   * @param row - the row to attack
   * @param col - the column to attack
   * @return - status code indicating the result of the attack
   */
  public int Attack(int row, int col) {
    if (row >= currPlayer.AttackGrid.length || col >= currPlayer.AttackGrid[0].length) {
      return OUT_OF_BOUNDS; 
    } 
    else if (currPlayer.AttackGrid[row][col] == 1 || currPlayer.AttackGrid[row][col] == -1) {
      return is_HIT; // Already hit
    } 
    else {
      if (currPlayer.GetName() == 0) { //if Captain 1
        // Check if the attack hits a ship on the opponent's grid
        if (allPlayers[1].ShipGrid[row][col] != null) {
          currPlayer.AttackGrid[row][col] = 1; // Mark hit on player's grid
          allPlayers[1].ShipGrid[row][col].SetLives(1); // Decrease the life of the hit ship
          boolean isSunk = allPlayers[1].ShipGrid[row][col].GetIsSunk();
          allPlayers[1].ShipGrid[row][col] = null; // Update opponent's ship grid to null
          if (isSunk){
            allPlayers[1].LifeDecrease();
          }
          return SUCCESSFUL; // Hit
        } 
        else {
          currPlayer.AttackGrid[row][col] = -1; // Mark miss on player's grid
          return MISS; // Miss
        }
      }
      else { //if Captain 2
        // Check if the attack hits a ship on the opponent's grid
        if (allPlayers[0].ShipGrid[row][col] != null) {
          currPlayer.AttackGrid[row][col] = 1; // Mark hit on player's grid
          allPlayers[0].ShipGrid[row][col].SetLives(1); // Decrease the life of the hit ship
          boolean isSunk = allPlayers[0].ShipGrid[row][col].GetIsSunk();
          allPlayers[0].ShipGrid[row][col] = null; // Update opponent's ship grid to null
          if (isSunk){
            allPlayers[0].LifeDecrease();
          }
          return SUCCESSFUL; // Hit
        } 
        else {
          currPlayer.AttackGrid[row][col] = -1; // Mark miss on player's grid
          return MISS; // Miss
        }
      }
    }
  }
  
  //MADE BY AAYUSH
  /* Perform a power attack with the specified ship
   * @param ship - the type of ship to perform the power attack
   */
  public int PerformPowerAttack(int ship, int row, int col) { 
    if (currPlayer.GetName() == 0) {
      return currPlayer.GetShipType(ship-1).PowerAttack(row, col, allPlayers[1], currPlayer); 
    }
    else {
      return currPlayer.GetShipType(ship-1).PowerAttack(row, col, allPlayers[0], currPlayer); 
    }
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
