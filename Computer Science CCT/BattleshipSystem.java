//Made by Aayush
public class BattleshipSystem {
  public final static int HEIGHT = 10;                 //fixed height of the grid
  public final static int WIDTH = 10;                  //fixed width of the grid
  private final static int MISS = 0;                   //Used in attack method if player has missed the ship
  private final static int SUCCESFULL = 1;             //If the method is successful 
  private final static int OUT_OF_BOUNDS = -1;         //If the row or column chosen is out of bounds
  private final static int INVALID_BOX = -2;           //If the box is already occupied
  private final static int is_HIT = -3;                 //If the position on the grid is already hit
  private final static int IS_PLACED = -4;             //If the ship is already placed
  
  private Ships[][] ShipGrid;    
  private int[][] AttackGrid;
  private Player[] allPlayers;
  private Player currPlayer;
  public Object bs;
  private int numRounds;
  private int currRound;
  
  //======================== Constructor =========================//
  //Made BY AAYUSH
  public BattleshipSystem(int numRounds) {
    allPlayers = new Player[2];
    allPlayers[0] = new Player(0, 5);
    allPlayers[1] = new Player(1, 5);
    this.numRounds = numRounds;
    ShipGrid = new Ships[HEIGHT][WIDTH];
    AttackGrid = new int[HEIGHT][WIDTH];
  }
  
  //========================= Private Method======================//
  
  //========================= PUBLIC METHODS======================//
  //MADE BY AHMHED & AAYUSH
  
  //MADE BY AAYUSH
  public int InsertShip(int row, int col, Ships ShipType, int orientation) {
    int size = ShipType.GetSize();
    int gridRows = ShipGrid.length;
    int gridCols = ShipGrid[0].length;
    
    // Check if row and col are within bounds
    if (ShipType.GetIsPlaced()){
      return IS_PLACED;
    }
    
    if (row < 0 || row >= gridRows || col < 0 || col >= gridCols) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    // Check if box is empty
    if (ShipGrid[row][col] != null) {
      return INVALID_BOX; // Box is full
    }
    
    // Check if ship placement exceeds grid boundaries
    if ((orientation == 0 && col + size > gridCols) || (orientation == 1 && row + size > gridRows)) {
      return OUT_OF_BOUNDS; // Out of bounds
    }
    
    // Place ship based on orientation
    for (int i = 0; i < size; i++) {
      if (orientation == 0) { //Vertical placement
        currPlayer.ShipGrid[row][col + i] = ShipType;
      } 
      else { //Horizontal Placement
        currPlayer.ShipGrid[row + i][col] = ShipType;
      }
    }
    ShipType.SetIsPlaced(true);
    return SUCCESFULL; // Successful
  }
  
  //MADE BY AAYUSH
  public int Attack(int row, int col) {
    if (row > AttackGrid.length || col > AttackGrid[0].length) {
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
          return SUCCESFULL; // Hit
        } 
        else {
          currPlayer.AttackGrid[row][col] = -1; // Mark miss on currPlayers grid
          return MISS; // Miss
        }
    }
  }

  //MADE BY AAYUSH
  public int PerformPowerAttack(int Ship) {
      currPlayer.GetShipType(Ship).PowerAttack(0,0, allPlayers[1], currPlayer); 
      return 1;
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
   * switches to O. If current player is O, then it switches to 1) */   
  public void SwitchPlayer() {
    if (currPlayer.GetName() == 0) {
      currPlayer = allPlayers[1];
    } 
    else {
      currPlayer = allPlayers[0];
    }
  }
  
  //Made by Aayush
  /* Get the 2D Ships array
   * @return - The 2D grid containing Ship objects */
  public Ships[][] GetShipGrid(){
    return ShipGrid;
  }
  
  //Made by Aayush
  /* Get the 2D array Attackgrid
   * @return - The 2D grid containing integers */
  public int[][] GetAttackGrid() {
    return AttackGrid;
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


  //Made by Aayush
  /*public boolean GetIsAllShipsPlaced(){
    int count = 0;
    for (int i = 0; i < currPlayer.GetShipTypes().length; i++)
    if (currPlayer.GetShipType(i).GetIsPlaced()){
      count++;
    }
    if (count == 5) {
      return true;
    }
    else {
      return false; 
    }
  }*/
}