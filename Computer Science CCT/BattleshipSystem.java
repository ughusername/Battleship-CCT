//Made by Aayush
public class BattleshipSystem {
  private final static int MISS = 0;                   //Used in attack method if player has missed the ship
  private final static int SUCCESSFUL = 1;             //If the method is successful 
  private final static int OUT_OF_BOUNDS = -1;         //If the row or column chosen is out of bounds
  private final static int INVALID_BOX = -2;           //If the box is already occupied
  private final static int is_HIT = -3;                //If the position on the grid is already hit
  private final static int IS_PLACED = -4;             //If the ship is already placed
  
  private Player[] allPlayers;                         //
  private Player currPlayer;                           //
  public Object bs;                                    //
  private int numRounds;                               //
  private int currRound;                               //
  
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
  public Ships CreateShip(int choice, int row, int col, int orientation){
    if (choice ==1) {
      Ships battleShip = new Battleship(row, col, orientation);
      currPlayer.AddShip(battleShip, Ships.BATTLESHIP -1);
      return battleShip;
    }
    else if (choice ==2) {
      Ships cruiser = new Cruiser(row, col, orientation);
      currPlayer.AddShip(cruiser, Ships.CRUISER-1);
      return cruiser;
    }
    else if(choice == 3){
      Ships Carrier = new Carrier(row, col, orientation);
      currPlayer.AddShip(Carrier, Ships.CARRIER -1);
      return Carrier;
    }
    else if(choice == 4) {
      Ships Destroyer = new Destroyer(row, col, orientation);
      currPlayer.AddShip(Destroyer, Ships.DESTROYER -1);
      return Destroyer;
    }
    else {
      Ships Submarine = new Submarine(row, col, orientation);
      currPlayer.AddShip(Submarine, Ships.SUBMARINE-1);
      return Submarine;
    }
  }
  
  //MADE BY AAYUSH
  public int InsertShip(int row, int col, Ships ShipType, int orientation) {
    int size = ShipType.GetSize();
    int gridRows = currPlayer.ShipGrid.length;
    int gridCols = currPlayer.ShipGrid[0].length;
    
    // Check if the ship is already placed
    if (ShipType.GetIsPlaced()) {
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
        currPlayer.ShipGrid[row][col + i] = ShipType;
      } 
      else { // Vertical placement
        currPlayer.ShipGrid[row + i][col] = ShipType;
      }
    }
    ShipType.SetIsPlaced(true);
    return SUCCESSFUL;
  }
  
  //MADE BY AAYUSH
  public int Attack(int row, int col) {
    if (row > currPlayer.AttackGrid.length || col > currPlayer.AttackGrid[0].length) {
      return OUT_OF_BOUNDS; 
    }
    
    else if (currPlayer.AttackGrid[row][col] == 1) {
      return is_HIT; //already hit. 
    }
    
    else {
      // Check if the attack hits a ship on the opponent's grid
      if (allPlayers[1].ShipGrid[row][col] != null) {
        currPlayer.AttackGrid[row][col] = 1; // Mark hit on players grid
        allPlayers[1].ShipGrid[row][col] = null; //update opponents shipgrid to null
        allPlayers[1].ShipGrid[row][col].SetLives(1);
        return SUCCESSFUL; // Hit
      } 
      else {
        currPlayer.AttackGrid[row][col] = -1; // Mark miss on currPlayers grid
        return MISS; // Miss
      }
    }
  }
  
  //MADE BY AAYUSH
  /*Method to call*/
  public void PerformPowerAttack(int Ship) {
    currPlayer.GetShipType(Ship).PowerAttack(0,0, allPlayers[1], currPlayer); 
  }
  
  //Made by Aayush
  /* Set who will be the current player
   * @param index - The value that represents the player. This
   *                is based on the array position of where the 
   *                player is stored. */
  public void SetCurrPlayer(int index) {
    if (index == 0) {
      this.currPlayer = allPlayers[0];
    }
    else {
      this.currPlayer = allPlayers[1];
    }
  }  
  
  //Made by Aayush
  public Player GetCurrPlayer() {
    return currPlayer;
  }
  
  //Made by Aayush
  public String GetCurrPlayerName(){
    if (currPlayer.GetName() ==0) {
      return "Captain 1";
    }
    else {
      return "Captain 2";
    }
  }
  
  //Made by Aayush
  /* Switch player's turn to the next player (If current player is 1, then it 
   * switches to 0. If current player is 0, then it switches to 1) */   
  public void SwitchPlayer() {
    if (currPlayer.GetName() == 0) {
      currPlayer = allPlayers[1];
    } 
    else {
      currPlayer = allPlayers[0];
    }
  }
  
  //Made by Aayush
  /* Set the current round number.
   * @param newCurrRound - The current new round number */
  public void SetCurrRound(int newCurrRound) {
    this.currRound = newCurrRound;
  }
  
  //Made by Aayush
  /* Get the total rounds
   * @return - The total number of rounds. */
  public int GetNumRounds() {
    return numRounds;
  } 

  public int GetCurrRound(){
    return this.currRound;
  }
  
  public boolean HasRoundWinner(){
    if (currPlayer.GetLives() == 0){
      return true;
    }
    else {
      return false; 
    }
  }

  public int GetGameWinnner(){
    if (allPlayers[0].GetScore()>allPlayers[1].GetScore()){
      return 0;
    }
    else {
      return 1;
    }
  }
}