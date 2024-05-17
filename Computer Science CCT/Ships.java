public abstract class Ships {
    public static final int CARRIER = 1; 
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private int startRow;
    private int startColumn;
    private int orientation;
    private int shipType;
    private int numofShips = 5;
    private boolean IsPlaced;
    private boolean IsSunk;
    

    //==================== CONSTRUCTORS ====================//
    public Ships() {
      
    }

    public Ships(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
      this.startColumn = startColumn;
      this.startRow = startRow;
      this.orientation = orientation;
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