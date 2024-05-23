public abstract class Ships {
    public static final int CARRIER = 1;      //The variable that stores the Carrier 
    public static final int BATTLESHIP = 2;   //The variable that stores the Battleship
    public static final int CRUISER = 3;      //The variable that stores the Cruiser
    public static final int DESTROYER = 4;    //The variable that stores the Destroyer
    public static final int SUBMARINE = 5;    //The variable that stores the Submarine
    private int startRow;                     //The variable for the starting row of the ship 
    private int startColumn;                  //The variable for the starting coloumn of the ship
    private int orientation;                  //The orientation of the ship wheather the ship is horizontal or vertical 
    private int shipType;                     //The variable that holds the ship type of the ship
    private int numofShips = 5;               //The variable that holds the number of ships
    private boolean IsPlaced;                 //Check if the ship is placed or not
    private boolean IsSunk;                   //Check if the ship is sunk or not 
    private int Power;
    

    //==================== CONSTRUCTORS ====================//
    public Ships() {
      
    }

    public Ships(int startRow, int startColumn, int orientation) {
      this.startColumn = startColumn;
      this.startRow = startRow;
      this.orientation = orientation;
      this.IsPlaced = false;
      this.IsSunk = false;
    }
    
    //=================== PUBLIC METHODS ===================//
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
    
    public int GetRemaningShips() {
      return numofShips;
    }

    
  /*Set the start row of the ship
   * @param Startrow - the starting row of the ship */
  public void SetStartRow(int StartRow) {
    this.startRow = StartRow;
  }
  
  /* Get Start Row of Ship
   * @return - Row ship is at */
  public int GetStartRow() {
    return startRow;
  }
  
  
  /*Set the start Column of the ship
   * @param startColumn - the starting column of the ship */
  public void SetStartColumn(int startColumn) {
    this.startColumn = startColumn;
  }
  
  /* Get Start Column of Ship
   * @return - Column ship is at */
  public int GetStartColumn() {
    return startColumn;
  }
  
  /* Set the orientation  of the ship
   * @param orientation - 0 is horizontal, 1 is vertical */
  public void SetOrientation(int orientation) {
    this.orientation = orientation;
  }
  
  /* Get Orientation of Ship
   * @return - value of orientation */
  public int GetOrientation() {
    return orientation;
  }
    
    public abstract int GetPower();
    
    public abstract int GetSize();
    
    public abstract int GetIdentity(); 
    
    public abstract void SetLives(int live);
    
    public abstract int GetLives();

    public void SetIsPlaced(boolean isPlaced){
      this.IsPlaced = isPlaced;
     }
  
     public boolean GetIsPlaced(){
      return IsPlaced;
     }
  
     public void SetIsSunk(boolean IsSunk){
      this.IsSunk = IsSunk;
     }
  
     public boolean GetIsSunk(){
      return IsSunk;
     }
    
    //MADE BY AAYUSH
    /* Attacks with a special move and each ship has a special attack
     * @param row - the row which the attack will be placed
     * @param col - the column which the attack will be placed
     * @param opponent - the opponent player which stores the shipgrids
     * @param currPlayer - the currPlayer which stores the attackgrid  */
    public abstract void PowerAttack( int row, int col, Player opponent, Player curPlayer);
  
}   